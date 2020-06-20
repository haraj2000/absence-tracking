package com.suivi.service.facade;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.bean.Groupe;

public interface EtudiantService {
	
	public List<Etudiant> findByFirstName(String firstName);
	public List<Etudiant> findByLastName(String lastName);
	public List<Etudiant> findByGroupe(Groupe groupe);
	public List<Etudiant> findBySector(Sector sector);
	public Etudiant findByCin(String cin);
	public Etudiant findByCne(String cne);
	public List<Etudiant> findByNbrAbsence(int nbrAbsence);
	public Etudiant findByCodeApogee(int codeApogee);
	public Etudiant findByMail(String mail);
	public int deleteByCin(String cin);
	public int deleteByCne(String cne);
	public int deleteByCodeApogee(int codeApogee);
	public List<Etudiant> findByRole(int role);
	public Etudiant save(Etudiant etudiant);
	public Etudiant update(Etudiant etudiant);
	public List<Etudiant> findAll();
	public int uplaodImage(MultipartFile file, String cne) throws IOException;
	public Etudiant getImage(String cin) throws IOException;
	public List<Etudiant> findByGroupeSemestre(Semestre semestre);
	public Etudiant password(Etudiant etudiant);
}
