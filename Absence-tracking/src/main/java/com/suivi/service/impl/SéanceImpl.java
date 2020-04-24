package com.suivi.service.impl;

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

}
