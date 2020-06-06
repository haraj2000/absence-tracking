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
public class Enseignant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numeroSOM;
	private String cin;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	private int tel;
	private String mail;
	private String password;
	private int role;
	@Column(name = "picByte", length = 400000000)
	private byte[] image;
	@ManyToOne
	private Departement departement;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getNumeroSOM() {
		return numeroSOM;
	}
	public void setNumeroSOM(int numeroSOM) {
		this.numeroSOM = numeroSOM;
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
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
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
	
	
	public Enseignant(String cin, byte[] image) {
		super();
		this.cin = cin;
		this.image = image;
	}
	public Enseignant(byte[] image) {
		super();
		this.image = image;
	}
	
	public Enseignant(int numeroSOM, String cin, String firstName, String lastName, Date birthDay, int tel, String mail,
			String password, int role, byte[] image, Departement departement) {
		super();
		this.numeroSOM = numeroSOM;
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.tel = tel;
		this.mail = mail;
		this.password = password;
		this.role = role;
		this.image = image;
		this.departement = departement;
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
		return "Enseignant [id=" + id + ", numeroSOM=" + numeroSOM + ", cin=" + cin + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDay=" + birthDay + ", tel=" + tel + ", mail=" + mail
				+ ", password=" + password + ", role=" + role + ", image=" + Arrays.toString(image) + ", departement=" + departement + "]";
	}
	
	
	
}
