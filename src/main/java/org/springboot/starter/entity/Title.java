package org.springboot.starter.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the titles database table.
 * 
 */
@Entity
@Table(name="titles")
@NamedQuery(name="Title.findAll", query="SELECT t FROM Title t")
public class Title implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TitlePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;


	public Title() {
	}

	public TitlePK getId() {
		return this.id;
	}

	public void setId(TitlePK id) {
		this.id = id;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}