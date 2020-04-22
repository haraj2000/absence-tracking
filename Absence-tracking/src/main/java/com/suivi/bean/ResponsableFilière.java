package com.suivi.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class ResponsableFilière extends Enseignant{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "responsableFilière")
	private Filière filière;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Filière getFilière() {
		return filière;
	}
	public void setFilière(Filière filière) {
		this.filière = filière;
	}
	public ResponsableFilière(Filière filière) {
		super();
		this.filière = filière;
	}
	public ResponsableFilière() {
		super();
	}
	
}
