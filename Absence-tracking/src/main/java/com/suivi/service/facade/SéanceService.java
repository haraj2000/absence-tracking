package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Séance;

public interface SéanceService {

	public Séance findByLibelle(String libelle);
	public Séance findByDate(Date date);
	public Séance findByHourStart(Date hourStart);
	public Séance findByHourStop(Date hourStop);
	public int deleteByLibelle(String libelle);
	public int save(Séance séance);
	public int update(Séance séance);
	public List<Séance> findAll();
}
