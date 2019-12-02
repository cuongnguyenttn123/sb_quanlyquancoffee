package com.thecoffeshop.DAOImpl;


import com.thecoffeshop.entity.Atposition;
import com.thecoffeshop.entity.AtpositionId;

public interface AtpositionDAOImp extends CommonDAOImp {

	public Boolean addAtposition(Atposition atposition);

	public Atposition getInfoById(AtpositionId atpositionId);

//	public Atposition getInfoByEmployeeId(String employeeid);

	public Boolean checkExistPosition(String positionid);

	public Boolean deleteAtposition(AtpositionId atpositionId);

	public Boolean editAtposition(Atposition atposition);

}
