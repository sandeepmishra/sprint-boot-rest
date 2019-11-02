package org.springboot.starter.employees.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the dept_emp database table.
 * 
 */
@Entity
@Table(name="dept_emp")
@NamedQuery(name="DeptEmp.findAll", query="SELECT d FROM DeptEmp d")
public class DeptEmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeptEmpPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	@ManyToOne
	@JoinColumn(name="emp_no",insertable=false, updatable=false)
	private Employee employee;
	
	public DeptEmp() {
	}

	@PrePersist 
	public void setDeptEmpkId() {
		this.id.setEmpNo(employee.getEmpNo());
	}
	
	public DeptEmpPK getId() {
		return this.id;
	}

	public void setId(DeptEmpPK id) {
		this.id = id;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}