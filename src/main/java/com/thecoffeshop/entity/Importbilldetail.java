package com.thecoffeshop.entity;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import javax.persistence.*;
import java.util.Date;

/**
 * Importbilldetail generated by hbm2java
 */
@Entity
@Table(name = "importbilldetail", catalog = "theshopcoffee")
public class Importbilldetail implements java.io.Serializable {
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "materialdetailid", column = @Column(name = "MATERIALDETAILID", nullable = false)),
			@AttributeOverride(name = "importbillid", column = @Column(name = "IMPORTBILLID", nullable = false)) })
	private ImportbilldetailId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IMPORTBILLID", nullable = false, insertable = false, updatable = false)
	private Importbill importbill;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATERIALDETAILID", nullable = false, insertable = false, updatable = false)
	private Materialdetail materialdetail;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEAT", length = 19)
	private Date updateat;

	@Column(name = "ISDELETE")
	private Boolean isdelete;

	public Importbilldetail() {
	}

	public Importbilldetail(ImportbilldetailId id, Importbill importbill, Materialdetail materialdetail) {
		this.id = id;
		this.importbill = importbill;
		this.materialdetail = materialdetail;
	}

	public Importbilldetail(ImportbilldetailId id, Importbill importbill, Materialdetail materialdetail,
			Integer quantity, Date updateat, Boolean isdelete) {
		this.id = id;
		this.importbill = importbill;
		this.materialdetail = materialdetail;
		this.updateat = updateat;
		this.isdelete = isdelete;
	}


	public ImportbilldetailId getId() {
		return this.id;
	}

	public void setId(ImportbilldetailId id) {
		this.id = id;
	}


	public Importbill getImportbill() {
		return this.importbill;
	}

	public void setImportbill(Importbill importbill) {
		this.importbill = importbill;
	}


	public Materialdetail getMaterialdetail() {
		return this.materialdetail;
	}

	public void setMaterialdetail(Materialdetail materialdetail) {
		this.materialdetail = materialdetail;
	}

	public Date getUpdateat() {
		return this.updateat;
	}

	public void setUpdateat(Date updateat) {
		this.updateat = updateat;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

}
