package com.suivi.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class TypeSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reference;
	private String libelle;
	@ManyToOne
	private Subject subject ;
	@ManyToOne
	private Enseignant enseignant;
	@ManyToOne
	private Module module;
	@ManyToMany
	private List<Groupe> groupes;
	
	
	public List<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
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
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public TypeSession() {
		super();
	}
	public TypeSession(String reference, String libelle, Subject subject, Enseignant enseignant, Module module,
			List<Groupe> groupes) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.subject = subject;
		this.enseignant = enseignant;
		this.module = module;
		this.groupes = groupes;
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
		TypeSession other = (TypeSession) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
}
	@Override
	public String toString() {
		return "TypeSession [id=" + id + ", reference=" + reference + ", libelle=" + libelle + ", subject=" + subject
				+ ", enseignant=" + enseignant + ", module=" + module + ", groupes=" + groupes + "]";
	}
	
	
	
}