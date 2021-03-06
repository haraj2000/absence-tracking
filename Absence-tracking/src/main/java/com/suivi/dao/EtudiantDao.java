package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.bean.Groupe;

public interface EtudiantDao extends JpaRepository<Etudiant, Long>{
	
	public List<Etudiant> findByFirstName(String firstName);
	public List<Etudiant> findByLastName(String lastName);
	public List<Etudiant> findByGroupe(Groupe groupe);
	public List<Etudiant> findBySector(Sector sector);
	public Etudiant findByCin(String cin);
	public List<Etudiant> findByNbrAbsence(int nbrAbsence);
	public Etudiant findByCne(String cne);
	public Etudiant findByCodeApogee(int codeApogee);
	public Etudiant findByMail(String mail);
	public int deleteByCin(String cin);
	public int deleteByCne(String cne);
	public int deleteByCodeApogee(int codeApogee);
	public List<Etudiant> findByRole(int role);
	public List<Etudiant> findByGroupeSemestre(Semestre semestre);
}
