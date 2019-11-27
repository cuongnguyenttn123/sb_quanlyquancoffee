package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.TablestatusDAOImp;
import com.thecoffeshop.entity.Tablestatus;
import com.thecoffeshop.repository.TablestatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TablestatusDAO implements TablestatusDAOImp {
	@Autowired
	TablestatusRepository tablestatusRepository;

	@Override
	public Boolean addTablestatus(Tablestatus tablestatus) {
		Boolean aBoolean;
		try{
			tablestatusRepository.save(tablestatus);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Tablestatus> findAll() {
		return tablestatusRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Tablestatus> findLimit(int start) {
		return tablestatusRepository.findAllLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
	}

	@Override
	public Tablestatus getInfoById(int tablestatusid) {
		return tablestatusRepository.findById(tablestatusid).get();
	}

	@Override
	public Boolean checkExist(String name) {
		Boolean aBoolean;
		Tablestatus tablestatus;
		try{
			tablestatus = tablestatusRepository.findByName(name);
			if (tablestatus != null){
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
	public Boolean deleteTablestatus(int tablestatusid) {
		Boolean aBoolean;
		try{
			tablestatusRepository.deleteById(tablestatusid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editTablestatus(Tablestatus tablestatus) {
		Boolean aBoolean;
		try{
			tablestatusRepository.save(tablestatus);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}
}