package com.thecoffeshop.controller.user;

import com.thecoffeshop.DAO.BillDAO;
import com.thecoffeshop.DTO.BillDTO;
import com.thecoffeshop.DTO.ProductDTO;
import com.thecoffeshop.common.Common;
import com.thecoffeshop.entity.*;
import com.thecoffeshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
@SessionAttributes({"gio-hang", "customer"})

public class UserOrderProductController extends Common {

    @Autowired
    CategoryProductService categoryProductService;

    @Autowired
    ProductService productService;

    @Autowired
    PriceService priceService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BillService billService;
    @Autowired
    VoucherService voucherService;

    @Autowired
    BilldetailService billdetailService;

    @GetMapping("gio-hang")
    @ResponseBody
    public String getGioHang(HttpSession httpSession, @RequestParam String PId, @RequestParam String Name,  @RequestParam String price){
        String aBoolean = "false";
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(Name);
        productDTO.setProductid(PId);
        productDTO.setNumber(1);
        productDTO.setPrice(Integer.parseInt(price));
        try {
            if (null == httpSession.getAttribute("gio-hang")){
                List<ProductDTO> gioHangList = new ArrayList<ProductDTO>();
                gioHangList.add(productDTO);
                httpSession.setAttribute("gio-hang", gioHangList);
                aBoolean = String.valueOf(gioHangList.size());
            }else {
                List<ProductDTO> gioHangList = (List<ProductDTO>) httpSession.getAttribute("gio-hang");
                int index = kiemTraGioHang(httpSession, productDTO);
                if (index==-1){
                    gioHangList.add(productDTO);
                }else {
                    int i=gioHangList.get(index).getNumber();
                    gioHangList.get(index).setNumber(i+1);
                }
                httpSession.setAttribute("gio-hang", gioHangList);
                aBoolean = String.valueOf(gioHangList.size());
            }

        }catch (Exception e){
            e.printStackTrace();
            aBoolean = "false";
        }

        return aBoolean;
    }
    @GetMapping("reset")
    @ResponseBody
    public String getGioHang(HttpSession httpSession){
        List<ProductDTO> gioHangList = (List<ProductDTO>) httpSession.getAttribute("gio-hang");
        gioHangList.removeAll(gioHangList);
        httpSession.setAttribute("gio-hang", gioHangList);
        return "0";
    }

    @GetMapping(value = "order-product", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String index(ModelMap modelMap, HttpSession httpSession) {
        List<ProductDTO> productDTOs = (List<ProductDTO>) httpSession.getAttribute("gio-hang");
        Integer tongtien = 0;
        for (ProductDTO productDTO: productDTOs
             ) {
            tongtien+= productDTO.getNumber()*productDTO.getPrice();
        }
        modelMap.addAttribute("productDTOs", productDTOs);
        modelMap.addAttribute("tongtien", tongtien);
        return "/user/orderProduct";
    }


    @PostMapping(value = "order-product", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String index(ModelMap modelMap, HttpSession httpSession, @RequestParam String listCart,
                        @RequestParam String listNumberProduct) {

        modelMap.addAttribute("listCart", listCart);
        modelMap.addAttribute("listNumberProduct", listNumberProduct);

        /* display Categoryproduct on combobox */
        List<Categoryproduct> categoryProducts = categoryProductService.findAll();
        modelMap.addAttribute("categoryProducts", categoryProducts);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        List<String> listProductId = this.listProductCart(listCart);
        List<Integer> listNumber = this.listNumberCart(listNumberProduct);

        int i = 0;
        for (String productid : listProductId) {

            Product product = productService.getInfoById(productid);
            if (product != null) {
                try {
                    ProductDTO dto = new ProductDTO();
                    dto.setProductid(product.getProductid());
                    dto.setName(product.getName());
                    dto.setCategoryproductNAME(product.getCategoryproduct().getName());
                    dto.setUpdateat(product.getUpdateat());
                    dto.setImage(product.getImage());
                    dto.setNumber(listNumber.get(i));
                    dto.setPrice(priceService.getOldPrice(product.getProductid()));
                    productDTOs.add(dto);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            i++;
        }
        modelMap.addAttribute("productDTOs", productDTOs);

        return "/user/orderProduct";
    }

    @PostMapping(value = "/pay-cart", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String orderProduct(ModelMap modelMap, HttpSession httpSession, @RequestParam String name,
                               @RequestParam String address, @RequestParam String phone,@RequestParam String pass, @RequestParam String startdatetime,
                               @RequestParam String notice, @RequestParam String voucherName) {

        Customer customer = customerService.checkPhoneOfCustommer(Integer.parseInt(phone), pass);
        List<ProductDTO> productDTOS = (List<ProductDTO>) httpSession.getAttribute("gio-hang");
        int lastCustomerID = -1;
        if (null == customer){
            customer = new Customer();
            customer.setName(name);
            customer.setAddress(address);
            customer.setPhone(Integer.valueOf(phone));
            customer.setPassword(pass);
            customer.setIsdelete(super.IS_NOT_DELETE);
            lastCustomerID = customerService.addCustomer(customer);
        } else {
            customer.setName(name);
            customer.setAddress(address);
            customer.setIsdelete(super.IS_NOT_DELETE);
            customer.setPassword(pass);
            lastCustomerID = customerService.editCustomer(customer);
        }
        int billid = 0;
        if (lastCustomerID != -1) { /* customer has inserted */
            Bill bill = billService.checkExistBillStatusAndCustomerId(lastCustomerID);
            if (bill == null){
                bill = new Bill();
                Date DatetimeStart = null;
                try {
                    DatetimeStart = super.sdf.parse(startdatetime);
                } catch (Exception e) {
                }
                bill.setStartdatetime(DatetimeStart);
                bill.setNotice(notice);
                bill.setCustomer(customer);
                bill.setBillstatus(new Billstatus("CD"));
                if (voucherName != null && voucherService.checkVoucher(voucherName.trim())) {
                    Voucher voucher = voucherService.findByName(voucherName);
                    bill.setVoucher(voucher);
                }

                billid = billService.addBill(bill);
                if (billid != -1) { /* bill has inserted */
                    for (ProductDTO productDTO1 : productDTOS) {
                        if (productService.getInfoById(productDTO1.getProductid()) != null) {// product is exist
                            Billdetail billdetail = new Billdetail();
                            BilldetailId billdetailId = new BilldetailId(productDTO1.getProductid(), billid);
                            billdetail.setId(billdetailId);
                            billdetail.setBill(bill);
                            billdetail.setProduct(new Product(productDTO1.getProductid()));
                            billdetail.setQuantity(productDTO1.getNumber());
                            billdetail.setIsdelete(super.IS_NOT_DELETE);
                            billdetail.setUpdateat(new Date());
                            billdetailService.addBilldetail(billdetail);
                        }
                    }

                }
            }else {
                billid = bill.getBillid();
                List<Billdetail> billdetails = billdetailService.getInfoBilldetailByBillId(billid);
                for (Billdetail billdetail: billdetails) {
                    billdetail.setIsdelete(true);
                    billdetail.setUpdateat(new Date());
                    billdetailService.editBilldetail(billdetail);
                }
                for (ProductDTO productDTO : productDTOS) {
                    if (productService.getInfoById(productDTO.getProductid()) != null) {// product is exist
                        Billdetail billdetail = new Billdetail();
                        BilldetailId billdetailId = new BilldetailId(productDTO.getProductid(), billid);
                        billdetail.setId(billdetailId);
                        billdetail.setBill(bill);
                        billdetail.setProduct(new Product(productDTO.getProductid()));
                        billdetail.setQuantity(productDTO.getNumber());
                        billdetail.setIsdelete(super.IS_NOT_DELETE);
                        billdetail.setUpdateat(new Date());
                        billdetailService.addBilldetail(billdetail);
                    }
                }

            }
            httpSession.setAttribute("customer",customer);
            List<ProductDTO> gioHangList = (List<ProductDTO>) httpSession.getAttribute("gio-hang");
            gioHangList.removeAll(gioHangList);
            httpSession.setAttribute("gio-hang", gioHangList);
        }
        String url = "redirect:/user/ordertracking/"+Integer.toString(billid);
        return url;
    }

    @GetMapping(value = "/ordertracking/{id}")
    public String orderTracking(ModelMap modelMap, @PathVariable String id, HttpSession httpSession){
        Customer customer = (Customer) httpSession.getAttribute("customer");
        if (customer != null){
            try {
                Bill bill= billService.getInfoById(Integer.parseInt(id));
                modelMap.addAttribute("value", bill);
                Integer tongtien = 0;
                Set<Billdetail> billdetail = bill.getBilldetails();
                List<ProductDTO> productDTOs = new ArrayList<>();
                for (Billdetail billdetail1: billdetail) {
                    Product product = billdetail1.getProduct();
                    if (product != null) {
                        try {
                            ProductDTO dto = new ProductDTO();
                            dto.setProductid(product.getProductid());
                            dto.setName(product.getName());
                            dto.setCategoryproductNAME(product.getCategoryproduct().getName());
                            dto.setUpdateat(product.getUpdateat());
                            dto.setImage(product.getImage());
                            dto.setNumber(billdetail1.getQuantity());
                            dto.setPrice(priceService.getOldPrice(product.getProductid()));
                            tongtien += billdetail1.getQuantity()*dto.getPrice();
                            productDTOs.add(dto);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                    modelMap.addAttribute("tongtien", tongtien);
                    modelMap.addAttribute("productDTOs", productDTOs);
                    modelMap.addAttribute("customer", customer);
                }
                return "/user/orderTracking";
            }catch (Exception e){
                return "redirect:/";
            }
        }else{
            return "user/login";
        }


    }

    @GetMapping("/viewsbill")
    public String getViewOrderProduct(ModelMap modelMap, HttpSession httpSession){

        Customer customer = (Customer) httpSession.getAttribute("customer");
        if (customer != null){
            List<Bill> billList = billService.getBillByCustomerId(customer.getCustomerid());
            List<BillDTO> dtos = new ArrayList<>();
            for (Bill bill : billList) {
                BillDTO billDTO = new BillDTO();
                billDTO.setBill(bill);
                billDTO.setTotalPrice(billService.getTotalPriceOfBill(bill.getBillid()));
                billDTO.setBillstatus(bill.getBillstatus());
                dtos.add(billDTO);
            }
            modelMap.addAttribute("dtos", dtos);
            modelMap.addAttribute("customer", customer);
            return "user/billOrder";
        }else{
            return "user/login";
        }

    }
    @GetMapping("/huydonhang")
    @ResponseBody
    public String huyDonHang(Integer billId, HttpSession httpSession){
        Customer customer = (Customer) httpSession.getAttribute("customer");
        if (customer != null){
            String cancelOrder = "";
            try {
                Bill bill = billService.getInfoById(billId);
                bill.setBillstatus(new Billstatus("HDH"));
                bill.setUpdateat(new Date());
                billService.editBill(bill);
                cancelOrder = "success";
            }catch (Exception e){
                cancelOrder = "failed";
            }
            return cancelOrder;
        }else{
            return "user/login";
        }
    }

    @GetMapping("/login")
    public String getLogin(){
        return "user/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginUser(ModelMap modelMap, HttpSession httpSession, @RequestParam String sdt, @RequestParam String pass){
        String result = "";
        try {

            Customer customer = customerService.checkPhoneOfCustommer(Integer.parseInt(sdt), pass);
            if (customer != null){
                httpSession.setAttribute("customer", customer);
                result = "succeess";
            }else {
                result = "failed";
            }

        }catch (Exception e){
            result = "failed";
        }
        return result;
    }

    private static int kiemTraGioHang(HttpSession httpSession, ProductDTO productDTO) {
        List<ProductDTO> gioHangList = (List<ProductDTO>) httpSession.getAttribute("gio-hang");
        for (int x = 0; x<gioHangList.size(); x++){
            if (gioHangList.get(x).getProductid().equalsIgnoreCase(productDTO.getProductid())){
                return x;
            }
        }
        return -1;
    }


}
