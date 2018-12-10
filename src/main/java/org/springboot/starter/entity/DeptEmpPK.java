package org.springboot.starter.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dept_emp database table.
 * 
 */
@Embeddable
public class DeptEmpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="emp_no")
	private Integer empNo;

	@Column(name="dept_no")
	private String deptNo;

	public DeptEmpPK() {
	}
	public Integer getEmpNo() {
		return this.empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getDeptNo() {
		return this.deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeptEmpPK)) {
			return false;
		}
		DeptEmpPK castOther = (DeptEmpPK)other;
		return 
			(this.empNo == castOther.empNo)
			&& this.deptNo.equals(castOther.deptNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empNo;
		hash = hash * prime + this.deptNo.hashCode();
		
		return hash;
	}
}