package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Booktable;
import com.thecoffeshop.entity.BooktableId;

import java.util.List;


public interface BooktableDAOImp extends CommonDAOImp {

	public Boolean addBooktable(Booktable booktable);

	public List<Booktable> findAll();

	public Booktable getInfoByBooktableId(BooktableId booktableId);

	public Boolean deleteBooktable(BooktableId booktableId);

	public Boolean editBooktable(Booktable booktable);

	public Boolean checkExistDinnerTable(int dinnertableid);
}
