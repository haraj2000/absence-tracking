package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Département;
import com.suivi.dao.DépartementDao;
import com.suivi.service.facade.DépartementService;

@Service
public class DépartementImpl implements DépartementService{

	@Autowired
	private DépartementDao départementDao;
	
	@Override
	public Département findByLibelle(String libelle) {
		return départementDao.findByLibelle(libelle);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return départementDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Département département) {
		Département départementFounded = findByLibelle(département.getLibelle());
		if(départementFounded == null) {
			départementDao.save(département);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Département> findAll() {
		return départementDao.findAll();
	}

}
