package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public int deleteByLibelle(String libelle) {
		return matièreDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Matière matière) {
		Matière matièreFounded = findByLibelle(matière.getLibelle());
		if(matièreFounded == null) {
			matièreDao.save(matière);
			return 1;
		}
		else return -1;
	}


	@Override
	public List<Matière> findAll() {
		return matièreDao.findAll();
	}

	
}
