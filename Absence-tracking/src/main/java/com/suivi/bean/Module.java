package com.suivi.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private String abreveation;
	@ManyToOne
	private Semestre semestre;
	@ManyToMany
	private List<Subject> subjects;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public Semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAbreveation() {
		return abreveation;
	}
	public void setAbreveation(String abreveation) {
		this.abreveation = abreveation;
	}
	public Module(String libelle, String abreveation, Semestre semestre, List<Subject> subjects) {
		super();
		this.libelle = libelle;
		this.abreveation = abreveation;
		this.semestre = semestre;
		this.subjects = subjects;
	}
	public Module() {
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
		Module other = (Module) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", libelle=" + libelle + ", abreveation=" + abreveation + ", semestre=" + semestre
				+ ", subjects=" + subjects + "]";
	}
	
	
	
	
}
