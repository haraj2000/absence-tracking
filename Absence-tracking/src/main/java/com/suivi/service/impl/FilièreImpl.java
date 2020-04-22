package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Cycle;
import com.suivi.bean.Filière;
import com.suivi.dao.FilièreDao;
import com.suivi.service.facade.FilièreService;

@Service
public class FilièreImpl implements FilièreService{

	@Autowired
	private FilièreDao filièreDao;
	
	@Override
	public Filière findByLibelle(String libelle) {
		return filièreDao.findByLibelle(libelle);
	}

	@Override
	public List<Filière> findByCycle(Cycle cycle) {
		return filièreDao.findByCycle(cycle);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return filièreDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Filière filière) {
		return 0;
	}

	@Override
	public int update(Filière filière) {
		return 0;
	}

	@Override
	public List<Filière> findAll() {
		return filièreDao.findAll();
	}

}
