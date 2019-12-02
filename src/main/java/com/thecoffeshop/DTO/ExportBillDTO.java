package com.thecoffeshop.DTO;

import com.thecoffeshop.entity.Employee;
import com.thecoffeshop.entity.Exportbill;

public class ExportBillDTO {

	private Exportbill exportbill;

	private Boolean canDelete;

	private Employee employee;

	private int countBillDetail;

	public Exportbill getExportbill() {
		return exportbill;
	}

	public void setExportbill(Exportbill exportbill) {
		this.exportbill = exportbill;
	}

	public int getCountBillDetail() {
		return countBillDetail;
	}

	public void setCountBillDetail(int countBillDetail) {
		this.countBillDetail = countBillDetail;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

}
