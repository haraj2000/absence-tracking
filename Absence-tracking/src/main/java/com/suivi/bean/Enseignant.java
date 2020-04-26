package com.suivi.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Enseignant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricule;
	private String cin;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	private int tel;
	private String mail;
	private String password;
	private int role;
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
	public Enseignant() {
		super();
	}
	
	public Enseignant(String matricule, String cin, String firstName, String lastName, Date birthDay, int tel,
			Département département, Matière matière) {
		super();
		this.matricule = matricule;
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.tel = tel;
		this.département = département;
		this.matière = matière;
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
		Enseignant other = (Enseignant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", matricule=" + matricule + ", cin=" + cin + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDay=" + birthDay + ", tel=" + tel
				+ ", département=" + département + ", matière=" + matière + "]";
	}
	
	
}
