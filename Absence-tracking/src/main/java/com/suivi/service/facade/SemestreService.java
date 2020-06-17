package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;

public interface SemestreService {

	public List<Semestre> findByLibelle(String libelle);
	public Semestre findByReference(String reference);
	public List<Semestre> findByAnneeUniversitaire(String anneeUniversitaire);
	public List<Semestre> findBySector(Sector sector);
	public List<Semestre> findByNumber(int number);
	public int deleteByReference(String reference);
	public int save(Semestre semestre, String filiere);
	public List<Semestre> findAll();
	public List<Semestre> findBySectorAndAnneeUniversitaire(Sector sector, String anneeUniversitaire);
}
