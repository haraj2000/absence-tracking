package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;

public interface SemestreService {

	public Semestre findByLibelle(String libelle);
	public Semestre findByReference(String reference);
	public List<Semestre> findByAnneeUniversitaire(String anneeUniversitaire);
	public List<Semestre> findByFiliere(Sector filiere);
	public List<Semestre> findByNumber(int number);
	public int deleteByReference(String reference);
	public int save(Semestre semestre, String filiere);
	public int update(Semestre semestre);
	public List<Semestre> findAll();
}
