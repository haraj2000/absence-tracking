package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Cycle;

public interface CycleService {

	public Cycle findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Cycle cycle);
	public int update(Cycle cycle);
	public List<Cycle> findAll();
}
