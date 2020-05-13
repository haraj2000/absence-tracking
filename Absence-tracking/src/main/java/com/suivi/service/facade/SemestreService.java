package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Filière;
import com.suivi.bean.Semestre;

public interface SemestreService {

	public Semestre findByLibelle(String libelle);
	public Semestre findByReference(String reference);
	public List<Semestre> findByAnnéeUniversitaire(Date annéeUniversitaire);
	public List<Semestre> findByFilière(Filière filière);
	public List<Semestre> findByNumber(int number);
	public int deleteByReference(String reference);
	public int save(Semestre semestre);
	public int update(Semestre semestre);
	public List<Semestre> findAll();
}
