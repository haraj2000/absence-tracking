package com.suivi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Séance;
import com.suivi.dao.SéanceDao;
import com.suivi.service.facade.SéanceService;

@Service
public class SéanceImpl implements SéanceService {
	@Autowired
	private SéanceDao séanceDao;

	@Override
	public Séance findByLibelle(String libelle) {
		return séanceDao.findByLibelle(libelle);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return séanceDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Séance séance) {
		Séance séanceFounded = findByLibelle(séance.getLibelle());
		if(séanceFounded == null) {
			séanceDao.save(séanceFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Séance> findAll() {
		return séanceDao.findAll();
	}

	@Override
	public Séance findByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Séance findByHourStart(Date hourStart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Séance findByHourStop(Date hourStop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Séance séance) {
		Séance séanceFounded = findByLibelle(séance.getLibelle());
		if(séanceFounded!= null) {
			séanceFounded.setLibelle(séance.getLibelle());
			séanceFounded.setTypeFormation(séance.getTypeFormation());
			séanceFounded.setDate(séance.getDate());
			séanceFounded.setHourStart(séance.getHourStart());
			séanceFounded.setHourStop(séance.getHourStop());
			return 1;
		}
		else return -1;
	}

}
