package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.BilldetailDAOImp;
import com.thecoffeshop.entity.*;
import com.thecoffeshop.repository.BilldetailRepository;
import com.thecoffeshop.repository.ProductRepository;
import com.thecoffeshop.service.BillService;
import com.thecoffeshop.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BilldetailDAO implements BilldetailDAOImp {
    @Autowired
    BilldetailRepository billdetailRepository;

    @Autowired
    BillService billService;

    @Autowired
    PriceService priceService;


    @Override
    public Boolean addBilldetail(Billdetail billdetail) {
        Boolean aBoolean;
        try {
            billdetailRepository.save(billdetail);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public List<Billdetail> getInfoBilldetailByBillId(int billid) {
        return billdetailRepository.findAllBilldetailByBillid(billid, this.IS_NOT_DELETE);
    }

    @Override
    @Transactional
    public Billdetail getInfoBilldetailByBilldetailId(BilldetailId billdetailId) {
        Billdetail billdetail;
        try{
            billdetail = billdetailRepository.findById(billdetailId).get();
        }catch (Exception e){
            billdetail = null;
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return billdetail;
    }

    @Override
    @Transactional
    public Boolean deleteBilldetail(BilldetailId billdetailId) {
        Boolean aBoolean;
        try {
            billdetailRepository.deleteById(billdetailId);
            aBoolean = true;
        }catch (Exception e){
            aBoolean = false;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return aBoolean;
    }

    @Override
    @Transactional
    public Boolean editBilldetail(Billdetail billdetail) {
        Boolean aBoolean;
        try {
            billdetailRepository.save(billdetail);
            aBoolean = true;
        }catch (Exception e){
            aBoolean = false;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return aBoolean;
    }

    @Override
    @Transactional
    public int getPriceOfBillDetail(BilldetailId billdetailId) {
        int billId = billdetailId.getBillid();
        int price;
        try {
            Date startdatetime = billService.getInfoById(billId).getStartdatetime();
            // lấy số lượng của sản phẩm
            Billdetail billdetail = billdetailRepository.findByIdAndIsdelete(billdetailId, this.IS_NOT_DELETE);
            // giá = số lượng * giá của sản phẩm
            price = billdetail.getQuantity()
                    * getSinglePriceOfBillDetail(billdetailId.getProductid(), startdatetime);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            price = -1;
        }
        return price;

    }

    @Override
    public int getSinglePriceOfBillDetail(Integer ProductId, Date startdatetime) {
        Price price;
        int pr;
        try {
            price = priceService.getSinglePriceOfBillDetail(ProductId, this.IS_NOT_DELETE, startdatetime);
            pr = price.getPrice();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            pr = -1;
        }
        return pr;
    }
}
