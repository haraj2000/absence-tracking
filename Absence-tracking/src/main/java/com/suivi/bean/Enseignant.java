package com.suivi.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Enseignant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricule;
	private String cin;
	private String firstName;
	private String lastName;
	private String mail;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date birthDay;
	private int tel;
	@ManyToOne
	private Compte compte;
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
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
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
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Enseignant() {
		super();
	}
	public Enseignant(String matricule, String cin, String firstName, String lastName, String mail, Date birthDay,
			int tel, Département département, Matière matière) {
		super();
		this.matricule = matricule;
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.birthDay = birthDay;
		this.tel = tel;
		this.département = département;
		this.matière = matière;
	}
	
	
}
