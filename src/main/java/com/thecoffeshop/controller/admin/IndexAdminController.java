package com.thecoffeshop.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.thecoffeshop.DTO.*;
import com.thecoffeshop.common.Common;
import com.thecoffeshop.entity.*;
import com.thecoffeshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;


@Controller
@RequestMapping("")
public class IndexAdminController extends Common {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	DinnertableService dinnertableService;
	@Autowired
	TablestatusService tablestatusService;
	@Autowired
	ProductService productService;
	@Autowired
	BillService billService;
	@Autowired
	BilldetailService billdetailService;
	@Autowired
	VoucherService voucherService;
	@Autowired
	ExportbillService exportbillService;

	@GetMapping(value = { "/admin/index" })
	public String index(ModelMap modelMap, HttpSession httpSession) {
		String emId = "1";
		httpSession.setAttribute("emId", emId);
		httpSession.getAttribute("emId").toString();
		Employee employee = employeeService.getInfoById(emId);
		modelMap.addAttribute(employee);
		// danh sách bàn

		List<indexAdminDTO> dtos = new ArrayList<indexAdminDTO>();
		List<Dinnertable> dinnertables = dinnertableService.findAll();
		for (Dinnertable dinnertable : dinnertables) {
			indexAdminDTO indexAdminDTO = new indexAdminDTO();
			indexAdminDTO.setDinnertable(dinnertable);

			dtos.add(indexAdminDTO);
		}
		modelMap.addAttribute("dtos", dtos);
		return "/admin/index";
	}

	@GetMapping(value = "/admin/index-modal")
	public String Modal(ModelMap modelMap, @RequestParam String dinnertableid) {

		Dinnertable dinnertable = dinnertableService.getInfoById(Integer.valueOf(dinnertableid.trim()));
		if (dinnertable == null) {
			modelMap.addAttribute("results", "Bàn này không tồn tại!");
			return "/admin/public/Danger";
		}

		List<Tablestatus> listTablestatus = tablestatusService.findAll();
		// list trạng thái bàn
		List<TableStatusDTO> tableStatusDTOs = new ArrayList<TableStatusDTO>();

		for (Tablestatus tablestatus : listTablestatus) {
			TableStatusDTO dto = new TableStatusDTO();
			dto.setTablestatusid(tablestatus.getTablestatusid());
			dto.setName(tablestatus.getName());
			tableStatusDTOs.add(dto);
		}
		modelMap.addAttribute("tableStatusDTOs", tableStatusDTOs);
		List<Dinnertable> dinnertables = dinnertableService.dsBanTrong();
		modelMap.addAttribute("dinnertables", dinnertables);
		modelMap.addAttribute("dinnertable", dinnertable);
		// list product

		return "/admin/public/modal-index";
	}

	@GetMapping("/admin/index/product")
	public String getListProduct(ModelMap modelMap, @RequestParam String startPosition, @RequestParam String inputSearch){
		int IntstartPosition = Integer.valueOf(startPosition.trim()) - 1;
		if (IntstartPosition < 0) {
			IntstartPosition = 0;
		}
		if (inputSearch == "") {
			inputSearch = null;
		}
		List<Product> products = productService.getListProductLimit(IntstartPosition, null, inputSearch, null);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO dto = new ProductDTO();
			dto.setProductid(product.getProductid());
			dto.setName(product.getName());
			dto.setImage(product.getImage());
			productDTOs.add(dto);
		}
		modelMap.addAttribute("productDTOs", productDTOs);

		return "/admin/public/modal-index-detail/productList";
	}

	@GetMapping("/admin/index/bill")
	public String getBill(ModelMap modelMap, @RequestParam String dinnertableid){
		Bill bill = billService.getInfoLastBill(Integer.valueOf(dinnertableid.trim()));
		List<Billdetail> billdetailList = null;
		int totalPriceBill = 0;
		if (bill != null){
			billdetailList =  billdetailService.getInfoBilldetailByBillId(bill.getBillid());
			totalPriceBill = billService.getTotalPriceOfBill2(billdetailList);
		}

		if (bill != null){
			modelMap.addAttribute("billid", bill.getBillid());
			modelMap.addAttribute("billSTARTDATETIME", bill.getStartdatetime());
			modelMap.addAttribute("totalPriceBill", totalPriceBill);
			List<BillDetailDTO> dtos = billService.converterBillDetail(billdetailList);
			modelMap.addAttribute("dtos", dtos);
		}
		return "/admin/public/modal-index-detail/pay";
	}

	@PostMapping(value = "/admin/index-changeTable")
	public @ResponseBody String changeTable(ModelMap modelMap, @RequestParam String billid,
			@RequestParam String dinnertableid) {

		List<JsonObject> jsonObjects = new ArrayList<JsonObject>();

		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			JsonObject result = new JsonObject();
			result.addProperty("mes", "Hoá đơn này không tồn tại!");
			return result.toString();
		}

		Dinnertable dinnertable2 = dinnertableService.getInfoById(Integer.valueOf(dinnertableid.trim()));
		if (dinnertable2 == null) {
			JsonObject result = new JsonObject();
			result.addProperty("mes", "Bàn này không tồn tại!");
			return result.toString();
		}

		// Đổi trạng thái bàn mới giống trạng thái bàn cũ

		JsonObject resultOLD = new JsonObject();
		Dinnertable dinnertable = bill.getDinnertable();
		resultOLD.addProperty("id", dinnertable.getTablestatus().getTablestatusid());
		resultOLD.addProperty("name", dinnertable.getTablestatus().getName());
		jsonObjects.add(resultOLD);
		Tablestatus tablestatus2 = bill.getDinnertable().getTablestatus();
		dinnertable2.setTablestatus(tablestatus2);
		dinnertableService.editDinnertable(dinnertable2);
//		// Đổi trạng thái bàn cũ thành đang trống
		Tablestatus tablestatus = tablestatusService.getInfoById(5);
		dinnertable.setTablestatus(tablestatus);
		Boolean aBoolean = dinnertableService.editDinnertable(dinnertable);

		JsonObject resultNEW = new JsonObject();
		resultNEW.addProperty("id", 5);
		resultNEW.addProperty("name", tablestatusService.getInfoById(5).getName());
		jsonObjects.add(resultNEW);
//		
//		// Cập nhật hóa đơn của bàn -> bàn mới
		bill.setDinnertable(dinnertable2);
		billService.editBill(bill);

		return jsonObjects.toString();
	}

	@PostMapping(value = "/admin/index-updateTableStatus")
	public @ResponseBody String UpdateTableStatus(ModelMap modelMap, @RequestParam String dinnertableid,
			@RequestParam String tablestatusid) {

		Dinnertable dinnertable = dinnertableService.getInfoById(Integer.valueOf(dinnertableid.trim()));
		if (dinnertable == null) {

			return "{\"mes\":\"Bàn này không tồn tại!\"}";
		}

		Tablestatus tablestatus = tablestatusService.getInfoById(Integer.valueOf(tablestatusid.trim()));
		if (tablestatus == null) {
			return "{\"mes\":\"Trạng thái bàn này không tồn tại!\"}";
		}

		dinnertable.setTablestatus(new Tablestatus(Integer.valueOf(tablestatusid.trim())));
		dinnertableService.editDinnertable(dinnertable);

		JsonObject result = new JsonObject();
		result.addProperty("id", tablestatus.getTablestatusid());
		result.addProperty("name", tablestatus.getName());
		result.addProperty("mes", "Câp nhât trang thái bàn thành công!");
		return result.toString();
//		return "{\"nameTableStatus\":\"" + tablestatus.getName() + "\", \"class\":\"badge badge-success\",\"mes\":\"Cập nhật trạng thái bàn thành công!\"}";
	}

	@PostMapping(value = "/admin/index-updateBillDetail") // khi click nút THÊM SẢN PHẨM vào hóa đơn
	public String UpdateBillDetail(ModelMap modelMap, @RequestParam String dinnertableid,
			@RequestParam String listProduct) {

		Bill bill = billService.getInfoLastBill(Integer.valueOf(dinnertableid.trim()));
		int lastBillId;
		if (bill == null) {// kiểm tra bill có sẵn chưa -> chưa thì thêm
			bill = new Bill();
//			bill.setEmployee(employee);
			bill.setBillstatus(new Billstatus("CTT"));
			bill.setDinnertable(new Dinnertable(Integer.valueOf(dinnertableid.trim())));
			bill.setStartdatetime(new Date());
			bill.setUpdateat(new Date());
			bill.setIsdelete(IS_NOT_DELETE);
			lastBillId = billService.addBill(bill);
		} else {
			lastBillId = bill.getBillid();
		}

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonObject = objectMapper.readTree(listProduct);
			JsonNode jsonArray = jsonObject.get("listProduct");

			String productid;
			int quantity;
			for (JsonNode product : jsonArray) {
				productid = product.get("productid").asText();
				quantity = product.get("quantity").asInt();
				/* check */

				if (quantity < 0) {
					modelMap.addAttribute("results", "Số lượng không đúng!");
					return "/admin/public/Danger";
				}
				/* check[END] */

				if (quantity > 0) {
					Billdetail billdetail = new Billdetail();
					billdetail.setId(new BilldetailId(productid, lastBillId));
					billdetail.setQuantity(quantity);
					billdetail.setUpdateat(new Date());
					billdetail.setIsdelete(IS_NOT_DELETE);
					Boolean aBoolean = billdetailService.addBilldetail(billdetail);
				}
			}

		} catch (Exception e) {
			modelMap.addAttribute("results", "Lỗi bất ngờ!");
			return "/admin/public/Danger";
		}
		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}

	@PostMapping(value = "/admin/index-updateBillStatus") // khi click nút THANH TOÁN
	public String UpdateBillStatus(ModelMap modelMap, @RequestParam String billid, @RequestParam String voucherName) {

		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			modelMap.addAttribute("results", "Hoá đơn này không tồn tại!");
			return "/admin/public/Danger";
		}
		if (voucherName != "" && !voucherService.checkVoucher(voucherName.trim())) {
			modelMap.addAttribute("results", "Voucher này không tồn tại!");
			return "/admin/public/Danger";
		} else {
			if (voucherName != "") {
				Voucher voucher = voucherService.findByName(voucherName.trim());
				bill.setVoucher(voucher);
			}
		}

		// trừ sản phẩm trong kho
		List<Billdetail> billdetails = billdetailService.getInfoBilldetailByBillId(Integer.parseInt(billid));
		List<String> results = new ArrayList<String>();
		for (Billdetail billdetail : billdetails) {
			String productid = billdetail.getProduct().getProductid();
			int totalProduct = exportbillService.totalQuantityProduct(productid);
			if (billdetail.getQuantity() > totalProduct) {
				results.add(billdetail.getProduct().getName() + " không đủ số lượng trong kho!");
			}
		}
		if (results.size() > 0) {
			modelMap.addAttribute("results", results);
			return "/admin/public/Danger";
		} else {
			for (Billdetail billdetail : billdetails) {
				String productid = billdetail.getProduct().getProductid();
				List<Exportbill> exportbills = exportbillService.getListExportBillbyProduct(productid);
				for (Exportbill exportbill : exportbills) {
					int quantity = billdetail.getQuantity();
					// số nhập nhỏ hơn số lượng đang có
					if ((exportbill.getQuantityInventory() - quantity) >= 0) {
						exportbill.setQuantityInventory(exportbill.getQuantityInventory() - quantity);
						exportbill.setQuantityThrow(exportbill.getQuantityThrow() + quantity);
						Boolean aBoolean = exportbillService.editExportbill(exportbill);
					}
					// số nhập lớn hơn số lượng đang có
					if ((exportbill.getQuantityInventory() - quantity) < 0) {
						quantity = quantity - exportbill.getQuantityInventory();
						exportbill.setQuantityInventory(0);
						exportbill.setQuantityThrow(exportbill.getQuantityThrow() + exportbill.getQuantityInventory());
						exportbillService.editExportbill(exportbill);
					}
				}
			}
			bill.setUpdateat(new Date());
			bill.setBillstatus(new Billstatus("DTT"));
			bill.setEnddate(new Date());
			bill.setUpdateat(new Date());
			billService.editBill(bill);
			Dinnertable dinnertable = bill.getDinnertable();
			Tablestatus tablestatus = tablestatusService.getInfoById(5);
			dinnertable.setTablestatus(tablestatus);
			Boolean aBoolean = dinnertableService.editDinnertable(dinnertable);
			modelMap.addAttribute("result", "Thanh toán thành công!");
			return "/admin/public/Success"; // thành công
		}

	}

	@PostMapping(value = "/admin/index-updateBill") // khi click nút LƯU CHỈNH SỬA hóa đơn
	public String UpdateBill(ModelMap modelMap, @RequestParam String billid, @RequestParam String listProduct) {

		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			modelMap.addAttribute("results", "Hoá đơn này không tồn tại!");
			return "/admin/public/Danger";
		}

		// cập nhật bill detail cũ
		List<Billdetail> billdetails = billdetailService.getInfoBilldetailByBillId(Integer.valueOf(billid.trim()));
		for (Billdetail billdetail : billdetails) {

			if (listProduct.indexOf(billdetail.getId().getProductid()) == -1) {// không có trong listProduct - > xóa
				billdetail.setUpdateat(new Date());
				billdetail.setIsdelete(IS_DELETE);
				billdetailService.editBilldetail(billdetail);
			}
		}
		/*List<Billdetail> billdetails1 = billdetailService.getInfoBilldetailByBillId(Integer.valueOf(billid.trim()));
		if (billdetails1.size() == 0 ){
			bill.setIsdelete(true);
			bill.setBillstatus(new Billstatus("KCM"));
			billService.editBill(bill);
		}*/
		modelMap.addAttribute("result", "Chỉnh sửa hóa đơn thành công!");
		return "/admin/public/Success";
	}

	@PostMapping(value = "/admin/index-checkVoucher")
	public @ResponseBody String checkVoucher(@RequestParam String voucherName, @RequestParam String billid) {

		JsonObject result = new JsonObject();
		
		Voucher voucher = voucherService.findByName(voucherName);
		if (voucher == null) {
			result.addProperty("mes", "Voucher không tồn tại!");
			return result.toString();
		}
		Date now = new Date();
		// voucher hết hạn hoặc chưa áp dụng HOẶC đã sử dụng hết
		if ((now.before(voucher.getStartdatetime()) && now.after(voucher.getEnddate())) || voucher.getCount() >= voucher.getNumber()) {
			result.addProperty("mes", "Voucher hết hạn hoặc đã sử dụng hết!");
			return result.toString();
		}
		voucher.setCount(voucher.getCount()+1);
		voucherService.editVoucher(voucher);
		float totalPriceBill = billService.getTotalPriceOfBill(Integer.valueOf(billid));
		//giảm giá theo tiền
		float discount = voucher.getDiscount();
		if(voucher.getDiscount() < 1) {//giảm giá theo %
			discount = totalPriceBill * (voucher.getDiscount());
		}
		result.addProperty("discount", discount);
		result.addProperty("totalPriceOLD", (int)totalPriceBill);
		result.addProperty("totalPriceNEW", (int)(totalPriceBill - discount));

		return result.toString();
	}

	public Billdetail getBillDetailByList(List<Billdetail> billdetailList, BilldetailId billdetailId){
		Billdetail billdetail = null;
		for (Billdetail billdetail1: billdetailList) {
			if (billdetailId.equals(billdetail1.getId())){
				billdetail = billdetail1;
			}
		}
		return billdetail;
	};

	public List<Dinnertable> dsBanTrong(List<Dinnertable> dinnertableList){
		List<Dinnertable> dinnertables = new ArrayList<>();
		for (Dinnertable dinnertable: dinnertableList
			 ) {
			if (dinnertable.getTablestatus().getTablestatusid() == 5){
				dinnertables.add(dinnertable);
			}
		}
		return dinnertables;
	}

}
