package com.suivi.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Séance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date hourStart;
	@Temporal(TemporalType.TIME)
	private Date hourStop;
	@ManyToOne
	private TypeSéance typeSéance;
	
	
	public TypeSéance getTypeSéance() {
		return typeSéance;
	}
	public void setTypeSéance(TypeSéance typeSéance) {
		this.typeSéance = typeSéance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getHourStart() {
		return hourStart;
	}
	public void setHourStart(Date hourStart) {
		this.hourStart = hourStart;
	}
	public Date getHourStop() {
		return hourStop;
	}
	public void setHourStop(Date hourStop) {
		this.hourStop = hourStop;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Séance( Date date, Date hourStart, Date hourStop, TypeSéance typeSéance) {
		super();
		this.date = date;
		this.hourStart = hourStart;
		this.hourStop = hourStop;
		this.typeSéance = typeSéance;
	}
	public Séance() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Séance other = (Séance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Séance [id=" + id + ", libelle=" + libelle + ", date=" + date + ", hourStart=" + hourStart
				+ ", hourStop=" + hourStop + ", typeSéance=" + typeSéance + "]";
	}


	
}
