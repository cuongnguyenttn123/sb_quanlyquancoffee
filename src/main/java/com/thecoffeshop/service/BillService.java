package com.thecoffeshop.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.thecoffeshop.DAOImpl.BillDAOImp;
import com.thecoffeshop.DTO.BillDetailDTO;
import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Billdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;


@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class BillService implements BillDAOImp {

	@Autowired
	BillDAO billDAO;

	@Override
	public int addBill(Bill bill) {
		bill.setIsdelete(this.IS_NOT_DELETE);
		return billDAO.addBill(bill);
	}

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		return billDAO.findAll();
	}

	@Override
	public Bill getInfoById(int billid) {
		// TODO Auto-generated method stub
		return billDAO.getInfoById(billid);
	}

	@Override
	public Boolean deleteBill(int billid) {
		// TODO Auto-generated method stub
		return billDAO.deleteBill(billid);
	}

	@Override
	public Boolean editBill(Bill bill) {
		// TODO Auto-generated method stub
		return billDAO.editBill(bill);
	}

	@Override
	public Boolean checkExistBillStatus(String billstatusid) {
		// TODO Auto-generated method stub
		return billDAO.checkExistBillStatus(billstatusid);
	}

	@Override
	public Boolean checkExistVoucher(int voucherid) {
		// TODO Auto-generated method stub
		return billDAO.checkExistVoucher(voucherid);
	}

	@Override
	public Boolean checkExistDinnerTable(int dinnertableid) {
		// TODO Auto-generated method stub
		return billDAO.checkExistDinnerTable(dinnertableid);
	}

	@Override
	public List<Bill> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return billDAO.findLimit(startPosition);
	}

	@Override
	public int getTotalPriceOfBill(int billid) {
		// TODO Auto-generated method stub
		return billDAO.getTotalPriceOfBill(billid);
	}

	@Override
	public int getTotalPriceOfBill2(List<Billdetail> billdetailListl) {
		return billDAO.getTotalPriceOfBill2(billdetailListl);
	}

	@Override
	public Bill getInfoLastBill(int dinnertableid) {
		// TODO Auto-generated method stub
		return billDAO.getInfoLastBill(dinnertableid);
	}

	@Override
	public int thongkeTongTienTrongNgay(Date date) {
		// TODO Auto-generated method stub
		return billDAO.thongkeTongTienTrongNgay(date);
	}

	@Override
	public int thongkeSoHoaDonTrongNgay(Date date) {
		// TODO Auto-generated method stub
		return billDAO.thongkeSoHoaDonTrongNgay(date);
	}

	@Override
	public int thongkeTongTienTrongTuan(int tuan) {
		// TODO Auto-generated method stub
		return billDAO.thongkeTongTienTrongTuan(tuan);
	}

	@Override
	public int thongkeSoHoaDonTrongTuan(int tuan) {
		// TODO Auto-generated method stub
		return billDAO.thongkeSoHoaDonTrongTuan(tuan);
	}

	@Override
	public int thongkeTongTienTrongThang(int thang) {
		// TODO Auto-generated method stub
		return billDAO.thongkeTongTienTrongThang(thang);
	}

	@Override
	public int thongkeSoHoaDonTrongThang(int thang) {
		// TODO Auto-generated method stub
		return billDAO.thongkeSoHoaDonTrongThang(thang);
	}

	@Override
	public List<BillDetailDTO> converterBillDetail(List<Billdetail> billdetail) {
		return billDAO.converterBillDetail(billdetail);
	}

	@Override
	public Bill checkExistBillStatusAndCustomerId(Integer customerId) {
		return billDAO.checkExistBillStatusAndCustomerId(customerId);
	}

	@Override
	public List<Bill> getBillByCustomerId(int customerid) {
		return billDAO.getBillByCustomerId(customerid);
	}

	public Bill getBillFullRelaByBillId(int billid){
		return billDAO.getBillFullRelaByBillId(billid);
	}

}
