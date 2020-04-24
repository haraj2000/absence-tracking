package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Groupe;

public interface EtudiantService {
	
	public List<Etudiant> findByFirstName(String firstName);
	public List<Etudiant> findByLastName(String lastName);
	public List<Etudiant> findByGroupe(Groupe groupe);
	public Etudiant findByCin(String cin);
	public Etudiant findByMail(String mail);
	public Etudiant findByCne(String cne);
	public int deleteByCne(String cne);
	public int deleteByCin(String cin);
	public int save(Etudiant etudiant);
	public int update(Etudiant etudiant);
	public List<Etudiant> findAll();

}
