package com.suivi.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Séance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStart;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStop;
	@ManyToOne
	private TypeSéance typeSéance;
	@ManyToOne
	private Module module;
	@ManyToOne
	private Enseignant enseignant;
	@OneToMany
	private List<Groupe> groupes;
	
	
	public TypeSéance getTypeSéance() {
		return typeSéance;
	}
	public void setTypeSéance(TypeSéance typeSéance) {
		this.typeSéance = typeSéance;
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
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateStop() {
		return dateStop;
	}
	public void setDateStop(Date dateStop) {
		this.dateStop = dateStop;
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
	public List<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Séance() {
		super();
	}
	public Séance(String libelle, Date dateStart, Date dateStop, TypeSéance typeSéance, Module module,
			Enseignant enseignant, List<Groupe> groupes) {
		super();
		this.libelle = libelle;
		this.dateStart = dateStart;
		this.dateStop = dateStop;
		this.typeSéance = typeSéance;
		this.module = module;
		this.enseignant = enseignant;
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
		Séance other = (Séance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Séance [id=" + id + ", libelle=" + libelle + ", dateStart=" + dateStart + ", dateStop=" + dateStop
				+ ", typeSéance=" + typeSéance + ", module=" + module + ", enseignant=" + enseignant + ", groupes="
				+ groupes + "]";
	}
}
