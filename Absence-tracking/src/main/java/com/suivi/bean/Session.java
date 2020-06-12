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
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private String reference;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStart;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStop;
	@ManyToOne
	private TypeSession typeSession;
	private int periode;
	
	
	
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public TypeSession getTypeSession() {
		return typeSession;
	}
	public void setTypeSession(TypeSession typeSession) {
		this.typeSession = typeSession;
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
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateStop() {
		return dateStop;
	}
	public void setDateStop(Date dateStop) {
		this.dateStop = dateStop;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Session() {
		super();
	}

	public Session(String libelle, String reference, Date dateStart, Date dateStop, TypeSession typeSession,
			int periode) {
		super();
		this.libelle = libelle;
		this.reference = reference;
		this.dateStart = dateStart;
		this.dateStop = dateStop;
		this.typeSession = typeSession;
		this.periode = periode;
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
		Session other = (Session) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", libelle=" + libelle + ", reference=" + reference + ", dateStart=" + dateStart
				+ ", dateStop=" + dateStop + ", typeSession=" + typeSession + ", periode=" + periode + "]";
	}
	
}
