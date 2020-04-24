package com.suivi.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TypeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@ManyToOne
	private Module module;
	@ManyToOne
	private Enseignant enseignant;
	@ManyToOne 
	private Matière matière;
	
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
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Matière getMatière() {
		return matière;
	}
	public void setMatière(Matière matière) {
		this.matière = matière;
	}
	public TypeFormation() {
		super();
	}
	public TypeFormation(String libelle, Module module, Enseignant enseignant, Matière matière) {
		super();
		this.libelle = libelle;
		this.module = module;
		this.enseignant = enseignant;
		this.matière = matière;
	}
	
}
