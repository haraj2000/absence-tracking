package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Filière;
import com.suivi.bean.Groupe;

public interface EtudiantService {
	
	public List<Etudiant> findByFirstName(String firstName);
	public List<Etudiant> findByLastName(String lastName);
	public List<Etudiant> findByGroupe(Groupe groupe);
	public List<Etudiant> findByFiliere(Filière filière);
	public Etudiant findByCin(String cin);
	public Etudiant findByMail(String mail);
	public Etudiant findBynCne(String cne);
	public Etudiant findByAbsence(Absence absence);
	public Etudiant findByCodeApogee(String codeApogee);
	public int deleteByCne(String cne);
	public int deleteByCin(String cin);
	public int save(Etudiant etudiant);
	public int update(Etudiant etudiant);
	public List<Etudiant> findAll();

}
