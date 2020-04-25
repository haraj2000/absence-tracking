package com.suivi.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String typeFormation;
	
	
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
	public String getTypeFormation() {
		return typeFormation;
	}
	public void setTypeFormation(String typeFormation) {
		this.typeFormation = typeFormation;
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

	public Séance(Long id, String libelle, Date date, Date hourStart, Date hourStop, String typeFormation) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.date = date;
		this.hourStart = hourStart;
		this.hourStop = hourStop;
		this.typeFormation = typeFormation;
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
				+ ", hourStop=" + hourStop + ", typeFormation=" + typeFormation + "]";
	}

	
}
