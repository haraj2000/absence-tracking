package com.suivi.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Semestre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reference;
	private String libelle;
	private int number;
	@Temporal(TemporalType.DATE)
	private Date annéeUniversitaire;
	@ManyToOne
	private Filière filière;
	@OneToMany
	private List<Module> modules;
	@OneToMany
	private List<Groupe> groupes;
	
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
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
	public Date getAnnéeUniversitaire() {
		return annéeUniversitaire;
	}
	public void setAnnéeUniversitaire(Date annéeUniversitaire) {
		this.annéeUniversitaire = annéeUniversitaire;
	}
	public Filière getFilière() {
		return filière;
	}
	public void setFilière(Filière filière) {
		this.filière = filière;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public List<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Semestre() {
		super();
	}
	
	public Semestre(String reference, String libelle, int number, Date annéeUniversitaire, Filière filière,
			List<Module> modules, List<Groupe> groupes) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.number = number;
		this.annéeUniversitaire = annéeUniversitaire;
		this.filière = filière;
		this.modules = modules;
		this.groupes = groupes;
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
		Semestre other = (Semestre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Semestre [id=" + id + ", reference=" + reference + ", libelle=" + libelle + ", number=" + number
				+ ", annéeUniversitaire=" + annéeUniversitaire + ", filière=" + filière + ", modules=" + modules
				+ ", groupes=" + groupes + "]";
	}
	
	
}
