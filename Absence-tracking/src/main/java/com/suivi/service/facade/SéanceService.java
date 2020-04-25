package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Séance;
import com.suivi.bean.TypeSéance;

public interface SéanceService {

	public Séance findByLibelle(String libelle);
	public List<Séance> findByDate(Date date);
	public List<Séance> findByHourStart(Date hourStart);
	public List<Séance> findByHourStop(Date hourStop);
	public List<Séance> findByTypeSéance(TypeSéance typeSéance);
	public int deleteByLibelle(String libelle);
	public int save(Séance séance);
	public int update(Séance séance);
	public List<Séance> findAll();
}
