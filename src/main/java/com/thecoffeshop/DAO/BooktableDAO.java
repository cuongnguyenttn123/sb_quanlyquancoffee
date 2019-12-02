package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.BooktableDAOImp;
import com.thecoffeshop.entity.Booktable;
import com.thecoffeshop.entity.BooktableId;
import com.thecoffeshop.repository.BooktableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BooktableDAO implements BooktableDAOImp {
    @Autowired
    BooktableRepository booktableRepository;

    @Override
    public Boolean addBooktable(Booktable booktable) {
        Boolean aBoolean;
        try {
            booktableRepository.save(booktable);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public List<Booktable> findAll() {
        return booktableRepository.findAllByIsdelete(this.IS_NOT_DELETE);
    }

    @Override
    public Booktable getInfoByBooktableId(BooktableId booktableId) {
        return booktableRepository.findByIdAndIsdelete(booktableId, this.IS_NOT_DELETE);
    }

    @Override
    public Boolean deleteBooktable(BooktableId booktableId) {
        Boolean aBoolean;
        try {
            booktableRepository.deleteById(booktableId);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean editBooktable(Booktable booktable) {
        Boolean aBoolean;
        try {
            booktableRepository.save(booktable);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean checkExistDinnerTable(int dinnertableid) {
        Boolean aBoolean;
        List<Booktable> booktable = new ArrayList<>();
        try {

            booktable = booktableRepository.checkExistDinnerTable(dinnertableid);
            if (booktable.size() != 0){
                aBoolean = true;
            }else {
                aBoolean = false;
            }

        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }
}
