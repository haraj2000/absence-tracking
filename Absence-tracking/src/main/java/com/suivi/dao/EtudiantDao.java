package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Groupe;

public interface EtudiantDao extends JpaRepository<Etudiant, Long>{
	
	public List<Etudiant> findByFirstName(String firstName);
	public List<Etudiant> findByLastName(String lastName);
	public List<Etudiant> findByGroupe(Groupe groupe);
	public Etudiant findByCin(String cin);
	public Etudiant findByCne(String cne);
	public Etudiant findByMail(String mail);
	public int deleteByCin(String cin);
	public int deleteByCne(String cne);

}
