package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.BillDAOImp;
import com.thecoffeshop.DTO.BillDetailDTO;
import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Billdetail;
import com.thecoffeshop.entity.BilldetailId;
import com.thecoffeshop.entity.Price;
import com.thecoffeshop.repository.BillRepository;
import com.thecoffeshop.service.BilldetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BillDAO implements BillDAOImp {
    @Autowired
    BillRepository repository;
    
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    BilldetailService billdetailService;

    @Override
    public int addBill(Bill bill) {
        int lastId;
        try {
            repository.save(bill);
            lastId = bill.getBillid();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            lastId = -1;
        }
        return lastId;
    }

    @Override
    public List<Bill> findAll() {
        return repository.findAllByIsdelete(this.IS_NOT_DELETE);
    }

    @Override
    public List<Bill> findLimit(int start) {
        return repository.findAllByLimit(this.IS_NOT_DELETE,start*this.MAX_RESULTS, this.MAX_RESULTS);
    }

    @Override
    public Bill getInfoById(int billid) {
        return repository.findById(billid).get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Boolean deleteBill(int billid) {
        Boolean aBoolean;
        try {
            repository.deleteById(billid);
            aBoolean = true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean editBill(Bill bill) {
        Boolean aBoolean;
        try {
            repository.save(bill);
            aBoolean = true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean checkExistBillStatus(String billstatusid) {
        Boolean aBoolean;
        List<Bill> billList;
        try {
            billList = repository.checkExistBillStatus(billstatusid);
            if (billList.size()!= 0){
                aBoolean = true;
            }else {
                aBoolean= false;
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean checkExistVoucher(int voucherid) {
        Boolean aBoolean;
        List<Bill> billList;
        try {
            billList = repository.checkExistVoucher(voucherid);
            if (billList.size()!= 0){
                aBoolean = true;
            }else {
                aBoolean= false;
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean checkExistDinnerTable(int dinnerTableId) {
        Boolean aBoolean;
        List<Bill> billList;
        try {
            billList = repository.checkExistDinnerTable(dinnerTableId);
            if (billList.size()!= 0){
                aBoolean = true;
            }else {
                aBoolean= false;
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    @Transactional
    public int getTotalPriceOfBill(int billid) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Billdetail b WHERE b.id.billid =:billid AND b.isdelete =:isdelete");
            List<Billdetail> billdetails = entityManager
                    .createQuery(stringBuilder.toString(), Billdetail.class)
                    .setParameter("billid", billid).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

            int totalPrice = 0;
            for (Billdetail billdetail : billdetails) {
                String productId = billdetail.getProduct().getProductid();
                int price = billdetailService.getPriceOfBillDetail(new BilldetailId(productId, billid));
                totalPrice += price;
            }
            return totalPrice;

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }
    @Override
    @Transactional
    public int getTotalPriceOfBill2(Bill bill){
        try {
            Bill bill1 = bill;
            int totalPrice = 0;
            for (Billdetail billdetail : bill.getBilldetails()) {
                String productId = billdetail.getProduct().getProductid();
                //int price = billdetailService.getPriceOfBillDetail(new BilldetailId(productId, bill.getBillid()));
                int price = getPriceBySet(billdetail.getProduct().getPrices());
                totalPrice += price;
            }
            return totalPrice;
        }catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }
    @Override
    public Bill getInfoLastBill(int dinnertableid) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Bill b WHERE b.isdelete =:isdelete AND b.billstatus.billstatusid = 'CTT' AND b.dinnertable.dinnertableid =:dinnertableid AND b.startdatetime <= now() ORDER BY b.startdatetime DESC");

            Bill bill = entityManager.createQuery(stringBuilder.toString(), Bill.class).setParameter("dinnertableid", dinnertableid)
                    .setParameter("isdelete", this.IS_NOT_DELETE).setFirstResult(0).setMaxResults(1).getSingleResult();
            return bill;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    @Override
    public int thongkeTongTienTrongNgay(Date date) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Bill b WHERE  DATE(b.startdatetime) = DATE(:date) AND b.billstatus.billstatusid = 'DTT' AND b.isdelete =:isdelete");
            List<Bill> bills = entityManager.createQuery(stringBuilder.toString(), Bill.class).setParameter("date", date).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

            int total = 0;
            for (Bill bill : bills) {
                total += getTotalPriceOfBill(bill.getBillid());
            }
            return total;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int thongkeSoHoaDonTrongNgay(Date date) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Bill b WHERE  DATE(b.startdatetime) = DATE(:date) AND b.billstatus.billstatusid = 'DTT' AND b.isdelete =:isdelete");
            List<Bill> bills = entityManager.createQuery(stringBuilder.toString(),Bill.class).setParameter("date", date)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
            return bills.size();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int thongkeTongTienTrongTuan(int tuan) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Bill b WHERE  WEEK(b.enddate) =: tuan AND b.billstatus.billstatusid = 'DTT' AND b.isdelete =:isdelete");
            List<Bill> bills = entityManager.createQuery(stringBuilder.toString(), Bill.class).setParameter("tuan", tuan)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

            int total = 0;
            for (Bill bill : bills) {
                total += getTotalPriceOfBill(bill.getBillid());
            }
            return total;
        } catch (Exception e) {

            return 0;
        }
    }

    @Override
    public int thongkeSoHoaDonTrongTuan(int tuan) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Bill b WHERE  WEEK(b.enddate) =:tuan AND b.billstatus.billstatusid = 'DTT' AND b.isdelete =:isdelete");
            List<Bill> bills = entityManager.createQuery(stringBuilder.toString(), Bill.class)
                    .setParameter("tuan", tuan)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
            return bills.size();
        } catch (Exception e) {

            return 0;
        }
    }

    @Override
    public int thongkeTongTienTrongThang(int thang) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Bill b WHERE  MONTH(b.enddate) =: thang AND b.billstatus.billstatusid = 'DTT' AND b.isdelete =:isdelete");
            List<Bill> bills = entityManager.createQuery(stringBuilder.toString(), Bill.class).setParameter("thang", thang).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

            int total = 0;
            for (Bill bill : bills) {
                total += getTotalPriceOfBill(bill.getBillid());
            }
            return total;
        } catch (Exception e) {

            return 0;
        }
    }

    @Override
    public int thongkeSoHoaDonTrongThang(int thang) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Bill b WHERE  MONTH(b.enddate) =: thang AND b.billstatus.billstatusid = 'DTT' AND b.isdelete =:isdelete");
            List<Bill> bills = entityManager.createQuery(stringBuilder.toString(), Bill.class).setParameter("thang", thang).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
            return bills.size();
        } catch (Exception e) {

            return 0;
        }
    }

    @Override
    public List<BillDetailDTO> converterBillDetail(Set<Billdetail> billdetailSet) {
        List<BillDetailDTO> billDetailDTOS = new ArrayList<BillDetailDTO>();
        for (Billdetail billdetail : billdetailSet) {
            BillDetailDTO dto = new BillDetailDTO();
            String productid = billdetail.getProduct().getProductid();
            String name = billdetail.getProduct().getName();
            dto.setProductid(productid);
            dto.setName(name);

            dto.setQuantity(billdetail.getQuantity());
            int SinglePrice = getPriceBySet(billdetail.getProduct().getPrices());
            int TotalPrice = billdetail.getQuantity()*SinglePrice;
            dto.setSinglePrice(SinglePrice);
            dto.setTotalPrice(TotalPrice);
            billDetailDTOS.add(dto);
        }
        return billDetailDTOS;
    }

    public int getPriceBySet(Set<Price> priceSet){
        Price price = null;
        int i = 0;
        for (Price  price1: priceSet) {
            if (i == 0){
                price = price1;
            }else {
                if (price.getStartdatetime().before(price1.getStartdatetime())){
                    price = price1;
                }
            }
            i++;

        }
        return price.getPrice();
    }
}
