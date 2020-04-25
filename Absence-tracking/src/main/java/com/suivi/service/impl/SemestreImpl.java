package com.suivi.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.suivi.bean.Filière;
import com.suivi.bean.Semestre;
import com.suivi.dao.SemestreDao;
import com.suivi.service.facade.SemestreService;

public class SemestreImpl implements SemestreService{

	@Autowired
	private SemestreDao semestreDao;
	
	@Override
	public Semestre findByLibelle(String libelle) {
		return semestreDao.findByLibelle(libelle);
	}

	@Override
	public List<Semestre> findByAnnéeUniversitaire(Date annéeUniversitaire) {
		return semestreDao.findByAnnéeUniversitaire(annéeUniversitaire);
	}

	@Override
	public List<Semestre> findByFilière(Filière filière) {
		return semestreDao.findByFilière(filière);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return semestreDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Semestre semestre) {
		Semestre semestreFounded = findByLibelle(semestre.getLibelle());
		if(semestreFounded == null) {
			semestreDao.save(semestre);
			return 1;
		}
		else return -1;
	}


	@Override
	public List<Semestre> findAll() {
		return semestreDao.findAll();
	}

	@Override
	public int update(Semestre semestre) {
		Semestre semestreFounded = findByLibelle(semestre.getLibelle());
		if(semestreFounded != null) {	
			semestreFounded.setGroupes(semestre.getGroupes());
			semestreFounded.setModules(semestre.getModules());
			return 1;
		}else return -1;
	}

}
