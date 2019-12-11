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


    @GetMapping("bill")
    public String getBillAll(ModelMap modelMap){
        List<Bill> billList = billService.getListBillShipper("3");
        List<BillDTO> dtos = new ArrayList<>();
        for (Bill bill : billList) {
            BillDTO billDTO = new BillDTO();
            billDTO.setBill(bill);
            billDTO.setTotalPrice(billService.getTotalPriceOfBill(bill.getBillid()));
            billDTO.setBillstatus(bill.getBillstatus());
            dtos.add(billDTO);
        }
        modelMap.addAttribute("dtos", dtos);
        return "shipper/content";
    }
    @GetMapping("bill/{id}")
    public String getBillDetailById(ModelMap modelMap, @PathVariable String id){
        Bill bill= billService.getInfoById(Integer.parseInt(id));
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
                    dto.setImage(product.getImage());
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
        return "shipper/shipper-tracking";
    }

    @GetMapping("done/{id}")
    public String duyetDonHang(@PathVariable String id){
        Bill bill = billService.getInfoById(Integer.parseInt(id));
        bill.setBillstatus(new Billstatus("DTT"));
        billService.editBill(bill);
        StringBuilder redirect = new StringBuilder("redirect:/shipper/bill/");
        redirect.append(bill.getEmployee().getEmployeeid());
        return redirect.toString();

    }

}
