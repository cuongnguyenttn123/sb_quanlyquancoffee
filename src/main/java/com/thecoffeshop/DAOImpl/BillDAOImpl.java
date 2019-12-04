package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.DTO.BillDetailDTO;
import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Billdetail;

import java.util.Date;
import java.util.List;

public interface BillDAOImpl extends CommonDAOImp {
    public int addBill(Bill bill);

    public List<Bill> findAll();

    public List<Bill> findLimit(int startPosition);

    public Bill getInfoById(int billid);

    public Boolean deleteBill(int billid);

    public Boolean editBill(Bill bill);

    public Boolean checkExistBillStatus(String billstatusid);

    public Boolean checkExistVoucher(int voucherid);

    public Boolean checkExistDinnerTable(int dinnertableid);

    public int getTotalPriceOfBill(int billid);
    public int getTotalPriceOfBill2(List<Billdetail> billdetailList);

    public Bill getInfoLastBill(int dinnertableid);

    // thống kê tổng tiền thu vào trong ngày, tổng hóa đơn trong ngày
    public int thongkeTongTienTrongNgay(Date date);

    public int thongkeSoHoaDonTrongNgay(Date date);

    // thống kê tổng tiền thu vào trong tuần, tổng hóa đơn trong tuần
    public int thongkeTongTienTrongTuan(int tuan);

    public int thongkeSoHoaDonTrongTuan(int tuan);

    // thống kê tổng tiền thu vào trong tuần, tổng hóa đơn trong năm
    public int thongkeTongTienTrongThang(int thang);

    public int thongkeSoHoaDonTrongThang(int thang);

    public List<BillDetailDTO> converterBillDetail(List<Billdetail> billdetail);

    public Bill checkExistBillStatusAndCustomerId(Integer customerId);

    List<Bill> getBillByCustomerId(int customerid);

    public List<Bill> getListUserOrder();

    List<Bill> getListUserOrderAll();

    List<Bill> getListBillShipper(String emId);
}
