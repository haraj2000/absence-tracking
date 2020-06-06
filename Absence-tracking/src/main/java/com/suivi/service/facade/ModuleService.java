package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Module;
import com.suivi.bean.Semestre;

public interface ModuleService {

	public Module findByLibelle(String libelle);
	public List<Module> findByAbreveation(String abreveation);
	public List<Module> findBySemestre(Semestre semestre);
	public int deleteByLibelle(String libelle);
	public int save(Module module);
	public List<Module> findAll();
}
