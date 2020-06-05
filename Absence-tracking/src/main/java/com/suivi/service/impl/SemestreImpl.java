package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.dao.SemestreDao;
import com.suivi.service.facade.SectorService;
import com.suivi.service.facade.SemestreService;

@Service
public class SemestreImpl implements SemestreService{

	@Autowired
	private SemestreDao semestreDao;
	@Autowired
	private SectorService filiereService;
	
	@Override
	public Semestre findByReference(String reference) {
		return semestreDao.findByReference(reference);
	}
	
	@Override
	public Semestre findByLibelle(String libelle) {
		return semestreDao.findByLibelle(libelle);
	}

	@Override
	public List<Semestre> findByAnneeUniversitaire(String anneeUniversitaire) {
		return semestreDao.findByAnneeUniversitaire(anneeUniversitaire);
	}

	@Override
	public List<Semestre> findBySector(Sector filiere) {
		return semestreDao.findBySector(filiere);
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return semestreDao.deleteByReference(reference);
	}

	@Override
	public int save(Semestre semestre, String filiere) {
		Sector sector = filiereService.findByLibelle(filiere);
		String reference = "S "+semestre.getNumber()+" "+ sector.getLibelle() + " " + semestre.getAnneeUniversitaire();
		String libelle = "S "+semestre.getNumber();
		Semestre semestreFounded = findByReference(reference);
		if(semestreFounded == null) {
			semestre.setReference(reference);
			semestre.setFiliere(sector);
			semestre.setLibelle(libelle);
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
		String reference = "S "+semestre.getNumber()+" "+semestre.getFiliere() + " " + semestre.getAnneeUniversitaire();
		Semestre semestreFounded = findByReference(reference);
		if(semestreFounded != null) {	
			semestreFounded.setGroupes(semestre.getGroupes());
			semestreFounded.setModules(semestre.getModules());
			semestreDao.save(semestreFounded);
			return 1;
		}else return -1;
	}

	@Override
	public List<Semestre> findByNumber(int number) {
		return semestreDao.findByNumber(number);
	}

}
