package com.thecoffeshop.controller.shipper;

import com.thecoffeshop.DTO.BillDTO;
import com.thecoffeshop.DTO.ProductDTO;
import com.thecoffeshop.entity.*;
import com.thecoffeshop.service.BillService;
import com.thecoffeshop.service.EmployeeService;
import com.thecoffeshop.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/shipper/")
public class ShipperController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    BillService billService;

    @Autowired
    PriceService priceService;

    @GetMapping("login")
    public String getLogin() {
        return "admin/management-system/shipper/shipper";
    }

    @PostMapping("login")
    public String loginUser(ModelMap modelMap, HttpSession httpSession, @RequestParam String emUsername, @RequestParam String emPassword) {
        String result = "";
        try {

            String checkLogin = employeeService.logIn(emUsername, emPassword);
            Employee employee = employeeService.getEmployeeByUsernameandpass(emUsername, emPassword);
            if (checkLogin != null) {
                StringBuilder redirect = new StringBuilder("redirect:/shipper/billall/");
                redirect.append(employee.getEmployeeid());
                return redirect.toString();
            } else {
                result = "redirect:/shipper/login";
            }

        } catch (Exception e) {
            result = "redirect:/shipper/login";
        }
        return result;
    }

    @GetMapping("/billall/{employeeid}")
    public String getBillAll(ModelMap modelMap, @PathVariable String employeeid){
        List<Bill> billList = billService.getListBillShipper(employeeid);
        List<BillDTO> dtos = new ArrayList<>();
        for (Bill bill : billList) {
            BillDTO billDTO = new BillDTO();
            billDTO.setBill(bill);
            billDTO.setTotalPrice(billService.getTotalPriceOfBill(bill.getBillid()));
            billDTO.setBillstatus(bill.getBillstatus());
            dtos.add(billDTO);
        }
        modelMap.addAttribute("dtos", dtos);
        return "admin/management-system/shipper/content/content";
    }
    @GetMapping("detailbill/{billid}")
    public String getBillDetailById(ModelMap modelMap, @PathVariable String billid){
        Bill bill= billService.getInfoById(Integer.parseInt(billid));
        Customer customer = new Customer();
        if (bill != null){
            customer = bill.getCustomer();
        }
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
                    List<Image> images = new ArrayList<Image>();
                    if (product.getImages().size() > 0) {
                        Set<Image> setImages = product.getImages();
                        for (Image image : setImages) {
                            images.add(image);
                        }
                        dto.setImages(images);
                    }
                    dto.setNumber(billdetail1.getQuantity());
                    dto.setPrice(priceService.getOldPrice(product.getProductid()));
                    tongtien += billdetail1.getQuantity()*dto.getPrice();
                    productDTOs.add(dto);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            modelMap.addAttribute("value", bill);
            modelMap.addAttribute("tongtien", tongtien);
            modelMap.addAttribute("productDTOs", productDTOs);
            modelMap.addAttribute("customer", customer);
        }
        return "admin/management-system/shipper/shipper-tracking";
    }

    @GetMapping("done/{billid}")
    public String duyetDonHang(@PathVariable String billid){
        Bill bill = billService.getInfoById(Integer.parseInt(billid));
        bill.setBillstatus(new Billstatus("DTT"));
        billService.editBill(bill);
        StringBuilder redirect = new StringBuilder("redirect:/shipper/billall/");
        redirect.append(bill.getEmployee().getEmployeeid());
        return redirect.toString();

    }

}
