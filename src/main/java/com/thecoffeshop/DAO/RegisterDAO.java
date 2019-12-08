package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.RegisterDAOImp;
import com.thecoffeshop.entity.Register;
import com.thecoffeshop.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RegisterDAO implements RegisterDAOImp {
	@Autowired
	RegisterRepository registerRepository;

	@Override
	public Boolean addRegister(Register register) {
		Boolean aBoolean;
		try{
			registerRepository.save(register);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Register getInfoById(int registerid) {
		return registerRepository.findById(registerid).get();
	}

	@Override
	public List<Register> getListRegisterOnWeek(Date from, Date to) {
		List<Register> registerList;
		try {
			registerList = registerRepository.getListRegisterOnWeek(from, to, this.IS_NOT_DELETE);
		}catch (Exception e){
			e.printStackTrace();
			registerList = new ArrayList<>();
		}
		return registerList;
	}

	@Override
	public Boolean checkExistSchedule(String scheduleid) {
		Boolean aBoolean;
		List<Register> registerList;
		try{
			registerList = registerRepository.checkExistSchedule(scheduleid, this.IS_NOT_DELETE);
			if (registerList.size()>0){
				aBoolean = true;
			}else {
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
	public Boolean deleteRegister(Register register) {
		Boolean aBoolean;
		try{
			registerRepository.delete(register);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editRegister(Register register) {
		Boolean aBoolean;
		try{
			registerRepository.save(register);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Register> listByDateScheduleid(java.sql.Date date, String scheduleid) {
		List<Register> registerList;
		try{
			registerList = registerRepository.listByDateScheduleid(date, scheduleid, this.IS_NOT_DELETE);
		}catch (Exception e){
			registerList = null;
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

		}
		return registerList;
	}

	@Override
	public List<Register> getScheduleEmployee(Date date, String scheduleid,String emId) {
		return registerRepository.getScheduleEmployee(date,scheduleid,emId, 2, this.IS_NOT_DELETE);
	}
}
