package com.suivi.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Enseignant extends Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Département département;
	@ManyToOne
	private Matière matière;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Département getDépartement() {
		return département;
	}
	public Matière getMatière() {
		return matière;
	}
	public void setMatière(Matière matière) {
		this.matière = matière;
	}
	public void setDépartement(Département département) {
		this.département = département;
	}
	public Enseignant() {
		super();
	}
	public Enseignant(Département département, Matière matière) {
		super();
		this.département = département;
		this.matière = matière;
	}
	
	
}
