package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Séance;
import com.suivi.bean.TypeSéance;

public interface SéanceService {

	public Séance findByLibelle(String libelle);
	public Séance findByReference(String reference);
	public List<Séance> findByDateStart(Date date);
	public List<Séance> findByDateStop(Date date);
	public List<Séance> findByTypeSéance(TypeSéance typeSéance);
	public int deleteByReference(String reference);
	public int save(Séance séance);
	public int update(Séance séance);
	public List<Séance> findAll();
}
