package com.thecoffeshop.entity;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import javax.persistence.*;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "theshopcoffee")
public class Employee implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEEID", unique = true, nullable = false, length = 7)
	private int employeeid;

	@Column(name = "NAME")
	private String name;

	@Column(name = "avt")
	private String avt;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "SEX")
	private Boolean sex;

	@Column(name = "PHONE", unique = true, length = 11)
	private String phone;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "USENAME")
	private String usename;

	@Column(name = "PASSWORD")
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEAT", length = 19)
	private Date updateat;

	@Column(name = "ISDELETE")
	private Boolean isdelete;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private Set<Bill> bills = new HashSet<Bill>(0);

	@ManyToMany
	@JoinTable(
			name = "atposition",
			joinColumns = @JoinColumn(name = "employeeid"),
			inverseJoinColumns = @JoinColumn(name = "positionid"))
	private Set<Position> positions = new HashSet<Position>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private Set<Exportbill> exportbills = new HashSet<Exportbill>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private Set<Register> registers = new HashSet<Register>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private Set<Importbill> importbills = new HashSet<Importbill>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private Set<Booktable> booktables = new HashSet<Booktable>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private Set<Salary> salaries = new HashSet<Salary>(0);

	public Employee(int i) {
	}

	public Employee() {
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvt() {
		return avt;
	}

	public void setAvt(String avt) {
		this.avt = avt;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdateat() {
		return updateat;
	}

	public void setUpdateat(Date updateat) {
		this.updateat = updateat;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public Set<Position> getPositions() {
		return positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}

	public Set<Exportbill> getExportbills() {
		return exportbills;
	}

	public void setExportbills(Set<Exportbill> exportbills) {
		this.exportbills = exportbills;
	}

	public Set<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(Set<Register> registers) {
		this.registers = registers;
	}

	public Set<Importbill> getImportbills() {
		return importbills;
	}

	public void setImportbills(Set<Importbill> importbills) {
		this.importbills = importbills;
	}

	public Set<Booktable> getBooktables() {
		return booktables;
	}

	public void setBooktables(Set<Booktable> booktables) {
		this.booktables = booktables;
	}

	public Set<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(Set<Salary> salaries) {
		this.salaries = salaries;
	}

	@Transient
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Position position: this.positions) {
			authorities.add(new SimpleGrantedAuthority(position.getName()));
		}
		return authorities;
	}

}