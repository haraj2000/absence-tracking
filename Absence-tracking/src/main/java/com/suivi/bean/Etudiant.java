package com.suivi.bean;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	private int tel;
	private int nbrAbsence;
	private String mail;
	private String password;
	private int role;
	@Column(name = "picByte", length = 400000000)
	private byte[] image;
	@ManyToOne
	private Filière filiere;
	@ManyToOne
	private Groupe groupe;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public Filière getFilière() {
		return filiere;
	}
	public void setFilière(Filière filière) {
		this.filiere = filière;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Filière getFiliere() {
		return filiere;
	}
	public void setFiliere(Filière filiere) {
		this.filiere = filiere;
	}
	public Etudiant(String cin, String cne, int codeApogee, String firstName, String lastName, Date birthDay, int tel,
			int nbrAbsence, String mail, String password, int role, byte[] image, Filière filiere, Groupe groupe) {
		super();
		this.cin = cin;
		this.cne = cne;
		this.codeApogee = codeApogee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.tel = tel;
		this.nbrAbsence = nbrAbsence;
		this.mail = mail;
		this.password = password;
		this.role = role;
		this.image = image;
		this.filiere = filiere;
		this.groupe = groupe;
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
				+ firstName + ", lastName=" + lastName + ", birthDay=" + birthDay + ", tel=" + tel + ", nbrAbsence="
				+ nbrAbsence + ", mail=" + mail + ", password=" + password + ", role=" + role + ", image="
				+ Arrays.toString(image) + ", filiere=" + filiere + ", groupe=" + groupe + "]";
	}

	
	
	

}
