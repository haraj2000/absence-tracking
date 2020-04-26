package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Filière;
import com.suivi.bean.Groupe;

public interface EtudiantService {
	
	public List<Etudiant> findByFirstName(String firstName);
	public List<Etudiant> findByLastName(String lastName);
	public List<Etudiant> findByGroupe(Groupe groupe);
	public List<Etudiant> findByFilière(Filière filière);
	public Etudiant findByCin(String cin);
	public Etudiant findByCne(String cne);
	public List<Etudiant> findByNbrAbsence(int nbrAbsence);
	public Etudiant findByCodeApogee(int codeApogee);
	public Etudiant findByCompteMail(String mail);
	public int deleteByCin(String cin);
	public int deleteByCne(String cne);
	public int deleteByCodeApogee(int codeApogee);
	public int save(Etudiant etudiant);
	public int update(Etudiant etudiant);
	public List<Etudiant> findAll();

}
