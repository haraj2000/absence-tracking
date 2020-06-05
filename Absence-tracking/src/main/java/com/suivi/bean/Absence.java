package com.suivi.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ref;
	private boolean absent;
	private String justification;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Session session;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAbsent() {
		return absent;
	}
	public void setAbsent(boolean absent) {
		this.absent = absent;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Session getSéance() {
		return session;
	}
	public void setSéance(Session session) {
		this.session = session;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Absence(String ref, boolean absent, String justification, Etudiant etudiant, Session session) {
	super();
	this.ref = ref;
	this.absent = absent;
	this.justification = justification;
	this.etudiant = etudiant;
	this.session = session;
}
	public Absence() {
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
		Absence other = (Absence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Absence [id=" + id + ", ref=" + ref + ", absent=" + absent + ", justification=" + justification
				+ ", etudiant=" + etudiant + ", session=" + session + "]";
	}
	

	
	
	
	
}
