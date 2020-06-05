package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Departement;
import com.suivi.dao.DepartementDao;
import com.suivi.service.facade.DepartementService;

@Service
public class DepartementImpl implements DepartementService{

	@Autowired
	private DepartementDao departementDao;
	
	@Override
	public Departement findByLibelle(String libelle) {
		return departementDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return departementDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Departement departement) {
		Departement départementFounded = findByLibelle(departement.getLibelle());
		if(départementFounded == null) {
			departementDao.save(departement);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Departement> findAll() {
		return departementDao.findAll();
	}

}
