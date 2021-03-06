package org.springboot.starter.retail.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dept_manager database table.
 * 
 */
@Entity
@Table(name="dept_manager")
@NamedQuery(name="DeptManager.findAll", query="SELECT d FROM DeptManager d")
public class DeptManager implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeptManagerPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	//bi-directional many-to-one association to Employee
/*	@ManyToOne
	@JoinColumn(name="emp_no")
	private Employee employee;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="dept_no")
	private Department department;*/

	public DeptManager() {
	}

/*	@PrePersist
	public void setDepartManagerPkId(){
		id =new DeptManagerPK();
		id.setDeptNo(department.getDeptNo());
		id.setEmpNo(employee.getEmpNo());
	}*/
	
	public DeptManagerPK getId() {
		return this.id;
	}

	public void setId(DeptManagerPK id) {
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

	/*public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}*/

}