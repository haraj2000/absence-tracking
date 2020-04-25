package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Filière;
import com.suivi.bean.Groupe;

public interface EtudiantDao extends JpaRepository<Etudiant, Long>{
	
	public List<Etudiant> findByFirstName(String firstName);
	public List<Etudiant> findByLastName(String lastName);
	public List<Etudiant> findByGroupe(Groupe groupe);
	public List<Etudiant> findByFiliere(Filière filière);
	public Etudiant findByCin(String cin);
	public Etudiant findByAbsence(Absence absence);
	public Etudiant findByCne(String cne);
	public Etudiant findByCodeApogee(String codeApogee);
	public Etudiant findByMail(String mail);
	public int deleteByCin(String cin);
	public int deleteByCne(String cne);

}
