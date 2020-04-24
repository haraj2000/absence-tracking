package com.suivi.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String cne;
	private int codeApogee;
	private String firstName;
	private String lastName;
	private String mail;
	private Date birthDay;
	private int tel;
	private int nbrAbsence;
	@OneToOne
	private Compte compte;
	@ManyToOne
	private Groupe groupe;
	@ManyToOne
	private Filière filière;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public Filière getFilière() {
		return filière;
	}
	public void setFilière(Filière filière) {
		this.filière = filière;
	}
	
	
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public int getCodeApogee() {
		return codeApogee;
	}
	public void setCodeApogee(int codeApogee) {
		this.codeApogee = codeApogee;
	}
	public int getNbrAbsence() {
		return nbrAbsence;
	}
	public void setNbrAbsence(int nbrAbsence) {
		this.nbrAbsence = nbrAbsence;
	}

	public Etudiant(Long id, String cin, String cne, int codeApogee, String firstName, String lastName, String mail,
			Date birthDay, int tel, int nbrAbsence, Compte compte, Groupe groupe, Filière filière) {
		super();
		this.id = id;
		this.cin = cin;
		this.cne = cne;
		this.codeApogee = codeApogee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.birthDay = birthDay;
		this.tel = tel;
		this.nbrAbsence = nbrAbsence;
		this.compte = compte;
		this.groupe = groupe;
		this.filière = filière;
	}
	public Etudiant() {
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
		Etudiant other = (Etudiant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", cin=" + cin + ", cne=" + cne + ", codeApogee=" + codeApogee + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mail=" + mail + ", birthDay=" + birthDay + ", tel=" + tel
				+ ", nbrAbsence=" + nbrAbsence + ", compte=" + compte + ", groupe=" + groupe + ", filière=" + filière
				+ "]";
	}

	
	
	

}
