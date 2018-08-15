package org.springboot.starter.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the salaries database table.
 * 
 */
@Entity
@Table(name="salaries")
@NamedQuery(name="Salary.findAll", query="SELECT s FROM Salary s")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalaryPK id;

	private Integer salary;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	public Salary() {
	}

	public SalaryPK getId() {
		return this.id;
	}

	public void setId(SalaryPK id) {
		this.id = id;
	}

	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}