package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.BillstatusDAOImp;
import com.thecoffeshop.entity.Billstatus;
import com.thecoffeshop.repository.BillstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BillstatusDAO implements BillstatusDAOImp {
    @Autowired
    BillstatusRepository billstatusRepository;

    @Override
    @Transactional
    public Boolean addBillstatus(Billstatus billstatus) {
        Boolean aBoolean;
        try{
            billstatusRepository.save(billstatus);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public List<Billstatus> findAll() {
        return billstatusRepository.findAllByIsdelete(this.IS_NOT_DELETE);
    }

    @Override
    public List<Billstatus> findLimit(int start) {
        return billstatusRepository.findAllByLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
    }

    @Override
    public Billstatus getInfoById(String billstatusid) {
        Billstatus billstatus;
        try{
            billstatus = billstatusRepository.findById(billstatusid).get();
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            billstatus = null;
        }
        return billstatus;
    }

    @Override
    public Boolean deleteBillstatus(String billstatusid) {
        Boolean aBoolean;
        try{
            billstatusRepository.deleteById(billstatusid);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean editBilldetail(Billstatus billstatus) {
        Boolean aBoolean;
        try{
            billstatusRepository.save(billstatus);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }
}
