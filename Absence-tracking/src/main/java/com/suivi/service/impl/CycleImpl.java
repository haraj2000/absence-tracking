package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Cycle;
import com.suivi.dao.CycleDao;
import com.suivi.service.facade.CycleService;

@Service
public class CycleImpl implements CycleService{

	@Autowired
	private CycleDao cycleDao;
	
	@Override
	public Cycle findByLibelle(String libelle) {
		return cycleDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return cycleDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Cycle cycle) {
		Cycle cycleFounded = findByLibelle(cycle.getLibelle());
				if(cycleFounded == null) {
					cycleDao.save(cycle);
					return 1;
				}
				else return -1;
	}


	@Override
	public List<Cycle> findAll() {
		return cycleDao.findAll();
	}

	
}
