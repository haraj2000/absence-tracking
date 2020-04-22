package com.suivi.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Filière {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@ManyToOne
	private Cycle cycle;
	@OneToOne(mappedBy = "filière")
	private ResponsableFilière responsableFilière;
	
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
	public Cycle getCycle() {
		return cycle;
	}
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	public ResponsableFilière getResponsableFilière() {
		return responsableFilière;
	}
	public void setResponsableFilière(ResponsableFilière responsableFilière) {
		this.responsableFilière = responsableFilière;
	}
	public Filière() {
		super();
	}
	public Filière(String libelle, Cycle cycle, ResponsableFilière responsableFilière) {
		super();
		this.libelle = libelle;
		this.cycle = cycle;
		this.responsableFilière = responsableFilière;
	}
		
}
