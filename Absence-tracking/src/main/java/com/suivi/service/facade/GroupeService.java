package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Groupe;
import com.suivi.bean.Semestre;

public interface GroupeService {
	
	public Groupe findByLibelle(String libelle);
	public Groupe findByReference(String reference);
	public List<Groupe> findBySemestre(Semestre semestre);
	public int deleteByReference(String reference);
	public int save(Groupe groupe);
	public List<Groupe> findAll();
	public int update(Groupe groupe);
}
