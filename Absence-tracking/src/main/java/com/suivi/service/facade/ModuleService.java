package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Module;

public interface ModuleService {

	public Module findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Module module);
	public List<Module> findAll();
}
