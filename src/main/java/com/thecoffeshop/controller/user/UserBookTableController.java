package com.thecoffeshop.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thecoffeshop.common.Common;
import com.thecoffeshop.entity.Booktable;
import com.thecoffeshop.entity.BooktableId;
import com.thecoffeshop.entity.Customer;
import com.thecoffeshop.service.BooktableService;
import com.thecoffeshop.service.CustomerService;
import com.thecoffeshop.service.DinnertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("")
public class UserBookTableController extends Common {

	@Autowired
	CustomerService customerService;
	@Autowired
	BooktableService booktableService;
	@Autowired
	DinnertableService dinnertableService;

	@GetMapping(value = "/book-table")
	public String index(ModelMap modelMap) {

		List<Integer> lists = dinnertableService.getListCountChair();
		modelMap.addAttribute("lists", lists);

		return "/user/bookTable";
	}

	@PostMapping(value = "/book-table")
	public String bookTable(ModelMap modelMap, @RequestParam String name, @RequestParam String address,
			@RequestParam String phone, @RequestParam String startdatetime, @RequestParam String countpeople,
			@RequestParam String notice) {

		/* check */
		List<String> results = checkForm(name, address, phone, startdatetime, countpeople);
		if (results.size() > 0) {
			modelMap.addAttribute("results", results);
			return "/admin/public/Danger";
		}
		/* check[END] */

		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(Integer.valueOf(phone));
		customer.setIsdelete(super.IS_NOT_DELETE);

		int lastCustomerID = customerService.addCustomer(customer);

		if (lastCustomerID == -1) {
			modelMap.addAttribute("results", "Lỗi bất ngờ!");
			return "/admin/public/Danger";
		}

		Booktable booktable = new Booktable();
		BooktableId id = new BooktableId(lastCustomerID, 1, "1");
		booktable.setId(id);

		String[] output = startdatetime.split("T");
		System.out.println(output);
		Date DatetimeStart = null;
		try {
			DatetimeStart = super.sdfDateTimeField1.parse(startdatetime);
			DatetimeStart.setTime(Long.parseLong(output[1]));
			DatetimeStart.setDate(Integer.parseInt(output[0]));
		} catch (Exception e) {
		}
		booktable.setStartdatetime(DatetimeStart);
		booktable.setStatus(super.STATUS_NOT_CONFIRM);
		booktable.setCountpeople(Integer.valueOf(countpeople.trim()));
		booktable.setNotice(notice.trim());
		booktable.setUpdateat(new Date());
		booktable.setIsdelete(IS_NOT_DELETE);
		if (!booktableService.addBooktable(booktable)) {
			modelMap.addAttribute("results", "Lỗi bất ngờ!");
			return "/admin/public/Danger";// Ä‘Ã£ tá»“n táº¡i
		}

		modelMap.addAttribute("result", "Đặt bàn thành công!");
		return "/admin/public/Success";
	}

	public List<String> checkForm(String name, String address, String phone, String startdatetime, String countpeople) {
		List<String> results = new ArrayList<String>();

		if (name.trim().length() <= 0 || name.trim().length() > 255) {
			results.add("Tên không thể để trống và tối đa 255 ký tự!");
		}
		if (address.trim().length() <= 0 || name.trim().length() > 255) {
			results.add("Địa chỉ không thể để trống và tối đa 255 ký tự");
		}
//		if (!super.checkNumberPhone(phone.trim())) {
//			results.add("Số điện thoại không đúng!");
//		}
		if (startdatetime.trim().length() <= 0) {
			results.add("Ngày đến trong được để trống!");
		}
		if (countpeople.trim().length() <= 0) {
			results.add("Vui lòng chọn loại bàn hoặc nhập số người!");
		}

		return results;
	}
}
