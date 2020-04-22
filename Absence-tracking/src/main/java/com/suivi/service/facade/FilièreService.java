package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Cycle;
import com.suivi.bean.Filière;

public interface FilièreService {

	public Filière findByLibelle(String libelle);
	public List<Filière> findByCycle(Cycle cycle);
	public int deleteByLibelle(String libelle);
	public int save(Filière filière);
	public int update(Filière filière);
	public List<Filière> findAll();
}
