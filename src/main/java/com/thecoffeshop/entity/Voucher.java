package com.thecoffeshop.entity;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Voucher generated by hbm2java
 */
@Entity
@Table(name = "voucher", catalog = "theshopcoffee")
public class Voucher implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "VOUCHERID", unique = true, nullable = false)
	private int voucherid;

	@Column(name = "NAME")
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTDATETIME", length = 19)
	private Date startdatetime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDDATE", length = 10)
	private Date enddate;

	@Column(name = "NUMBER")
	private Integer number;

	@Column(name = "COUNT")
	private Integer count;

	@Column(name = "SALEOFF")
	private Integer saleoff;

	@Column(name = "DISCOUNT")
	private float discount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEAT", length = 19)
	private Date updateat;

	@Column(name = "ISDELETE")
	private Boolean isdelete;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voucher")
	private Set<Bill> bills = new HashSet<Bill>(0);

	public Voucher() {
	}

	public Voucher(int voucherid) {
		this.voucherid = voucherid;
	}

	public Voucher(int voucherid, String name, Date startdatetime, Date enddate, Integer number, Integer count,
				   float discount, Date updateat, Boolean isdelete, Set<Bill> bills) {
		this.voucherid = voucherid;
		this.name = name;
		this.startdatetime = startdatetime;
		this.enddate = enddate;
		this.number = number;
		this.count = count;
		this.discount = discount;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.bills = bills;
	}


	public int getVoucherid() {
		return this.voucherid;
	}

	public void setVoucherid(int voucherid) {
		this.voucherid = voucherid;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Date getStartdatetime() {
		return this.startdatetime;
	}

	public void setStartdatetime(Date startdatetime) {
		this.startdatetime = startdatetime;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSaleoff() {
		return saleoff;
	}

	public void setSaleoff(Integer saleoff) {
		this.saleoff = saleoff;
	}


	public float getDiscount() {
		return this.discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
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

	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}


}
