package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.Séance;
import com.suivi.bean.TypeSéance;

public interface SéanceService {

	public Séance findByLibelle(String libelle);
	public List<Séance> findByDateStart(Date date);
	public List<Séance> findByDateStop(Date date);
	public List<Séance> findByTypeSéance(TypeSéance typeSéance);
	public List<Séance> findByEnseignant(Enseignant enseignant);
	public List<Séance> findByModule(Module module);
	public int deleteByLibelle(String libelle);
	public int save(Séance séance);
	public int update(Séance séance);
	public List<Séance> findAll();
}
