package com.thecoffeshop.controller.admin;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.thecoffeshop.common.Common;
import com.thecoffeshop.service.BillService;
import com.thecoffeshop.service.ImportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("")
public class ThongKeThuChiController extends Common {

	@Autowired
	BillService billService;
	@Autowired
	ImportBillService importBillService;

	@GetMapping(value = "/admin/statistic-profit")
	public String index() {

		return "/admin/statistic/thu-chi";
	}

	@PostMapping(value = "/admin/statistic-profit")
	public @ResponseBody String load() {
		
	/*ngay*/
		// bill
		Date date = new java.sql.Date(new java.util.Date().getTime());
		int soluongBillTrongNgay = billService.thongkeSoHoaDonTrongNgay(date);
		int tongtienBillTrongNgay = billService.thongkeTongTienTrongNgay(date);
		// importbill
		int soluongImportBillTrongNgay = importBillService.soluongImportBill(date);
		int tongtienImportBillTrongNgay = importBillService.tongtienImportBill(date);
		
		String ngay = "{"
				+ "\"soluongBillTrongNgay\":\"" + soluongBillTrongNgay + "\","
				+ "\"tongtienBillTrongNgay\":\"" + tongtienBillTrongNgay + "\"," 
				+ "\"soluongImportBillTrongNgay\":\"" + soluongImportBillTrongNgay + "\"," 
				+ "\"tongtienImportBillTrongNgay\":\"" + tongtienImportBillTrongNgay + "\"" 
				+ "}";
	/*ngay [END]*/

	/*tuan*/
		Calendar calendar = Calendar.getInstance();
		int temb = calendar.get(calendar.DAY_OF_WEEK) - 1;
		calendar.roll(calendar.DAY_OF_MONTH, -temb);// lấy ngày bắt đầu của tuần
		
		String tuan = "["; 
		for(int i = 1; i<=7; i++) {
			//Sun -> Mon
			//bill
			int soluongBillTrongTuan = billService.thongkeSoHoaDonTrongNgay(calendar.getTime());
			int tongtienBillTrongTuan = billService.thongkeTongTienTrongNgay(calendar.getTime());
			// importbill
			int soluongImportBillTrongTuan = importBillService.soluongImportBill(calendar.getTime());
			int tongtienImportBillTrongTuan = importBillService.tongtienImportBill(calendar.getTime());
			
			String stringTemb = "{"
					+ "\"soluongBillTrongTuan\":" + soluongBillTrongTuan + ","
					+ "\"tongtienBillTrongTuan\":" + tongtienBillTrongTuan + "," 
					+ "\"soluongImportBillTrongTuan\":" + soluongImportBillTrongTuan + "," 
					+ "\"tongtienImportBillTrongTuan\":" + tongtienImportBillTrongTuan + "" 
					+ "}";
			if(i==7) {
				tuan += stringTemb + "";
			}
			else {
				tuan += stringTemb + ",";
			}
			calendar.roll(calendar.DAY_OF_MONTH, 1);
		}
		tuan += "" + "]";

	/*tuan [END]*/
	
	/*thang*/
		calendar = Calendar.getInstance();

		int weekOfYear = calendar.get(calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(calendar.WEEK_OF_MONTH);
		int week  = weekOfYear - weekOfMonth + 1;
		String thang = "["; 
		for(int i = 0; i< 4; i++) {
			//bill
			int soluongBillTrongThang = billService.thongkeSoHoaDonTrongTuan(week);
			int tongtienBillTrongThang = billService.thongkeTongTienTrongTuan(week);
			// importbill
			int soluongImportBillTrongThang = importBillService.soluongImportBillTrongTuan(week);
			int tongtienImportBillTrongThang = importBillService.tongtienImportBillTrongTuan(week);
			week++;
			String stringTemb = "{"
					+ "\"soluongBillTrongThang\":" + soluongBillTrongThang + ","
					+ "\"tongtienBillTrongThang\":" + tongtienBillTrongThang + "," 
					+ "\"soluongImportBillTrongThang\":" + soluongImportBillTrongThang + "," 
					+ "\"tongtienImportBillTrongThang\":" + tongtienImportBillTrongThang + "" 
					+ "}";
			if(i==3) {
				thang += stringTemb + "";
			}
			else {
				thang += stringTemb + ",";
			}
		}
		thang += "" + "]";
	/*thang[END]*/	

	/*nam*/
		calendar = Calendar.getInstance();
		String nam = "["; 
		for(int i = 1; i<= 12; i++) {
			//bill
			int soluongBillTrongNam = billService.thongkeSoHoaDonTrongThang(i);
			int tongtienBillTrongNam = billService.thongkeTongTienTrongThang(i);
			// importbill
			int soluongImportBillTrongNam = importBillService.soluongImportBillTrongThang(i);
			int tongtienImportBillTrongNam = importBillService.tongtienImportBillTrongThang(i);
			String stringTemb = "{"
					+ "\"soluongBillTrongNam\":" + soluongBillTrongNam + ","
					+ "\"tongtienBillTrongNam\":" + tongtienBillTrongNam + "," 
					+ "\"soluongImportBillTrongNam\":" + soluongImportBillTrongNam + "," 
					+ "\"tongtienImportBillTrongNam\":" + tongtienImportBillTrongNam + "" 
					+ "}";
			if(i==12) {
				nam += stringTemb + "";
			}
			else {
				nam += stringTemb + ",";
			}
		}
		nam += "" + "]";
	/*nam[END]*/
		
		
		String result = "{"
				+ "\"ngay\":" + ngay + ","
				+ "\"tuan\":" + tuan + ","
				+ "\"thang\":" + thang + ","
				+ "\"nam\":" + nam + ""
				+"}";
		
		return result;
	}
}
