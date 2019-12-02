package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.DinnertableDAOImp;
import com.thecoffeshop.entity.Dinnertable;
import com.thecoffeshop.repository.DinnertableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DinnertableDAO implements DinnertableDAOImp {
	@Autowired
	DinnertableRepository dinnertableRepository;

	@Override
	public Boolean addDinnertable(Dinnertable dinnertable) {
		Boolean aBoolean;
		try {
			dinnertableRepository.save(dinnertable);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Dinnertable> findAll() {
		return dinnertableRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Dinnertable> dsBanTrong() {
		List<Dinnertable> dinnertables;
		try{
			dinnertables = dinnertableRepository.findAllTableEmply(5, this.IS_NOT_DELETE);
		}catch (Exception e){
			e.printStackTrace();
			dinnertables = new ArrayList<>();
		}
		return dinnertables;
	}

	@Override
	public List<Dinnertable> findLimit(int start) {
		return dinnertableRepository.findAllByLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
	}

	@Override
	public Dinnertable getInfoById(int dinnertableid) {
		return dinnertableRepository.findById(dinnertableid).get();
	}

	@Override
	public List<Integer> getListCountChair() {
		List<Integer> integers;
		List<Dinnertable> dinnertableList;
		try {
			dinnertableList = dinnertableRepository.findAllCountChair(this.IS_NOT_DELETE);
			integers = new ArrayList<>();
			if (dinnertableList.size() > 0){

				for (Dinnertable dinnertable: dinnertableList
					 ) {
					integers.add(dinnertable.getCountchair());
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			integers = new ArrayList<>();
		}
		return integers;
	}

	@Override
	public Boolean checkExistDinnerTable(String name) {
		Boolean aBoolean;
		try {
			Dinnertable dinnertable = dinnertableRepository.checkExistDinnerTable(name);
			if (dinnertable != null){
				aBoolean = true;
			} else {
				aBoolean = false;
			}

		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean deleteDinnertable(int dinnertableid) {
		Boolean aBoolean;
		try {
			dinnertableRepository.deleteById(dinnertableid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editDinnertable(Dinnertable dinnertable) {
		Boolean aBoolean;
		try {
			dinnertableRepository.save(dinnertable);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			aBoolean = false;
		}
		return aBoolean;
	}
}