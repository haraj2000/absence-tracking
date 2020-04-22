package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Matière;
import com.suivi.dao.MatièreDao;
import com.suivi.service.facade.MatièreService;

@Service
public class MatièreImpl implements MatièreService{

	@Autowired
	private MatièreDao matièreDao;
	
	@Override
	public Matière findByLibelle(String libelle) {
		return matièreDao.findByLibelle(libelle);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return matièreDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Matière matière) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Matière matière) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Matière> findAll() {
		return matièreDao.findAll();
	}

	
}
