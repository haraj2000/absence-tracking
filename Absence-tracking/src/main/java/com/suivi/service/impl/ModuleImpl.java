package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Module;
import com.suivi.bean.Semestre;
import com.suivi.dao.ModuleDao;
import com.suivi.service.facade.ModuleService;

@Service
public class ModuleImpl implements ModuleService{
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public Module findByLibelle(String libelle) {
		return moduleDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return moduleDao.deleteByLibelle(libelle);
	}

	@Override
	public Module save(Module module) {
		Module moduleFounded = findByLibelle(module.getLibelle());
		if(moduleFounded == null) {
			moduleDao.save(module);
			return module;
		}
		else return null;
	}

	@Override
	public List<Module> findAll() {
		return moduleDao.findAll();
	}

	@Override
	public List<Module> findByAbreveation(String abreveation) {
		return moduleDao.findByAbreveation(abreveation);
	}

	@Override
	public List<Module> findBySemestre(Semestre semestre) {
		return moduleDao.findBySemestre(semestre);
	}
	

}
