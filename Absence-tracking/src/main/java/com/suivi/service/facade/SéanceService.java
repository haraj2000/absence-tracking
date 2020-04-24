package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Groupe;
import com.suivi.bean.Séance;

public interface SéanceService {

	public Séance findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Séance séance);
	public List<Séance> findAll();
}
