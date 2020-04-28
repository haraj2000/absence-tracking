package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Filière;
import com.suivi.bean.Semestre;

public interface SemestreService {

	public Semestre findByLibelle(String libelle);
	public List<Semestre> findByAnnéeUniversitaire(Date annéeUniversitaire);
	public List<Semestre> findByFilière(Filière filière);
	public List<Semestre> findByNumber(int number);
	public int deleteByLibelle(String libelle);
	public int save(Semestre semestre);
	public int update(Semestre semestre);
	public List<Semestre> findAll();
}
