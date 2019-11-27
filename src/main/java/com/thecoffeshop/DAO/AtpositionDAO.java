package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.AtpositionDAOImp;
import com.thecoffeshop.entity.Atposition;
import com.thecoffeshop.entity.AtpositionId;
import com.thecoffeshop.repository.AtpositonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AtpositionDAO implements AtpositionDAOImp {
    @Autowired
    AtpositonRepository atpositonRepository;

    @Override
    @Transactional
    public Boolean addAtposition(Atposition atposition) {
        Boolean aBoolean;
        try {
            atpositonRepository.save(atposition);
            aBoolean = true;
        }catch (Exception e){
            e.printStackTrace();
            aBoolean = false;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return aBoolean;
    }

    @Override
    public Atposition getInfoById(AtpositionId atpositionId) {
        Atposition atposition;
        try {
            atposition = atpositonRepository.findByIdAndIsdelete(atpositionId, this.IS_NOT_DELETE);
        }catch (Exception e){
            e.printStackTrace();
            atposition = null;
        }
        return atposition;
    }

    @Override
    public Boolean checkExistPosition(String positionid) {
        Boolean aBoolean;
        try {
            List<Atposition> atpositionList = atpositonRepository.checkExistPosition(positionid);
            if (atpositionList.size()!= 0){
                aBoolean = true;
            } else {
                aBoolean = false;
            }

        }catch (Exception e){
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Boolean deleteAtposition(AtpositionId atpositionId) {
        Boolean aBoolean;
        try{
            atpositonRepository.deleteById(atpositionId);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public Boolean editAtposition(Atposition atposition) {
        Boolean aBoolean;
        try {
            atpositonRepository.save(atposition);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }
}
