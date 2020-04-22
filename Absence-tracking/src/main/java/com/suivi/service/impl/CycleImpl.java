package com.suivi.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Cycle cycle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cycle cycle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cycle> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
