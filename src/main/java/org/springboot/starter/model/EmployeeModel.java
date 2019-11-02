package org.springboot.starter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springboot.starter.retail.entities.DeptEmp;
import org.springboot.starter.retail.entities.DeptManager;
import org.springboot.starter.retail.entities.Salary;
import org.springboot.starter.retail.entities.Title;

public class EmployeeModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4772972160882857876L;
	
	private Integer empNo;

	private Date birthDate;

	private String firstName;

	private String gender;

	private Date hireDate;

	private String lastName;

	private List<DeptEmp> deptEmps;

	private List<DeptManager> deptManagers;

	private List<Salary> salaries;

	private List<Title> titles;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<DeptEmp> getDeptEmps() {
		return deptEmps;
	}

	public void setDeptEmps(List<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	public List<DeptManager> getDeptManagers() {
		return deptManagers;
	}

	public void setDeptManagers(List<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
}
