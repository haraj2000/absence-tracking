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
	private String libelle;
	@Temporal(TemporalType.DATE)
	private Date annéeUniversitaire;
	@ManyToOne
	private Filière filière;
	@OneToMany
	private List<Module> modules;
	@OneToMany
	private List<Groupe> groupes;
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
	public Semestre() {
		super();
	}
	public Semestre(String libelle, Date annéeUniversitaire, Filière filière) {
		super();
		this.libelle = libelle;
		this.annéeUniversitaire = annéeUniversitaire;
		this.filière = filière;
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
		return "Semestre [id=" + id + ", libelle=" + libelle + ", annéeUniversitaire=" + annéeUniversitaire
				+ ", filière=" + filière + ", modules=" + modules + ", groupes=" + groupes + "]";
	}
	
	
}
