package com.thecoffeshop.controller.admin;

import com.thecoffeshop.DTO.BillDTO;
import com.thecoffeshop.DTO.ProductDTO;
import com.thecoffeshop.entity.*;
import com.thecoffeshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("")
public class BillUserOrderController {
    @Autowired
    BillService billService;

    @Autowired
    PriceService priceService;

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PositionService positionService;

    @GetMapping("/admin/getlistuserorder")
    public String getUserOrder(ModelMap modelMap){
        List<Bill> billList = billService.getListUserOrder();
        List<BillDTO> dtos = new ArrayList<>();
        for (Bill bill : billList) {
            BillDTO billDTO = new BillDTO();
            billDTO.setBill(bill);
            billDTO.setTotalPrice(billService.getTotalPriceOfBill(bill.getBillid()));
            billDTO.setBillstatus(bill.getBillstatus());
            dtos.add(billDTO);
        }
        modelMap.addAttribute("dtos", dtos);
        return "admin/public/userorder";
    }

    @GetMapping("/admin/getlistuserorderall")
    public String getUserOrderAll(ModelMap modelMap){
        List<Bill> billList = billService.getListUserOrderAll();
        List<BillDTO> dtos = new ArrayList<>();
        for (Bill bill : billList) {
            BillDTO billDTO = new BillDTO();
            billDTO.setBill(bill);
            billDTO.setTotalPrice(billService.getTotalPriceOfBill(bill.getBillid()));
            billDTO.setBillstatus(bill.getBillstatus());
            dtos.add(billDTO);
        }
        modelMap.addAttribute("dtos", dtos);
        return "admin/management-system/bill-user-order";
    }
    @GetMapping("/admin/getdetailbillid/{billid}")
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
            Set<Employee> listEmployee = positionService.getInfoById("5").getEmployees();//chưa lấy ds shipper
            modelMap.addAttribute("value", bill);
            modelMap.addAttribute("listEmployee", listEmployee);
            modelMap.addAttribute("tongtien", tongtien);
            modelMap.addAttribute("productDTOs", productDTOs);
            modelMap.addAttribute("customer", customer);
        }
        return "admin/management-system/detail-bill-user-order";
    }

    @PostMapping("/admin/duyetdonhang")
    public String duyetDonHang(@RequestParam String billid, @RequestParam String employeeid){
        Bill bill = billService.getInfoById(Integer.parseInt(billid));
        bill.setBillstatus(new Billstatus("DS"));
        bill.setEmployee(new Employee("3"));
        billService.editBill(bill);
        return "redirect:/admin/getlistuserorderall";
    }

}
