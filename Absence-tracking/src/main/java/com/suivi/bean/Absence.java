package com.suivi.bean;

import java.util.Date;

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
	private String justification;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Module module;
	@ManyToOne
	private Séance séance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Séance getSéance() {
		return séance;
	}
	public void setSéance(Séance séance) {
		this.séance = séance;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}


	public Absence(Long id, String ref, String justification, Etudiant etudiant, Module module, Séance séance) {
		super();
		this.id = id;
		this.ref = ref;
		this.justification = justification;
		this.etudiant = etudiant;
		this.module = module;
		this.séance = séance;
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
		return "Absence [id=" + id + ", ref=" + ref + ", justification=" + justification + ", etudiant=" + etudiant
				+ ", module=" + module + ", séance=" + séance + "]";
	}


	
	
	
	
}
