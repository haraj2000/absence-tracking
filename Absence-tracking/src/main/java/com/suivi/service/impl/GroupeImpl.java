package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Groupe;
import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.dao.GroupeDao;
import com.suivi.service.facade.GroupeService;

@Service
public class GroupeImpl implements GroupeService {
	@Autowired
	private GroupeDao groupeDao;
	
	
	@Override
	public Groupe findByReference(String reference) {
		return groupeDao.findByReference(reference);
	}
	@Override
	public Groupe findByLibelle(String libelle) {
		return groupeDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return groupeDao.deleteByReference(reference);
	}

	@Override
	public Groupe save(Groupe groupe) {
		String ref = groupe.getSemestre().getReference() + " " + groupe.getLibelle();
		groupe.setReference(ref);
		Groupe groupeFouded = findByReference(groupe.getReference());
		if(groupeFouded == null) {
			groupeDao.save(groupe);
			return groupe;
		}
		else return null;
	}

	@Override
	public List<Groupe> findAll() {
		return groupeDao.findAll();
	}

	@Override
	public int update(Groupe groupe) {
		String ref = groupe.getSemestre().getLibelle() + " " + groupe.getLibelle();
		groupe.setReference(ref);
		Groupe groupeFouded = findByReference(groupe.getReference());
		if(groupeFouded != null) {
			groupeFouded.setSemestre(groupe.getSemestre());
			groupeDao.save(groupeFouded);
			return 1;
		}
		else return -1;
	}
	@Override
	public List<Groupe> findBySemestre(Semestre semestre) {
		return groupeDao.findBySemestre(semestre);
	}
	@Override
	public List<Groupe> findBySemestreSector(Sector sector) {
		return groupeDao.findBySemestreSector(sector);
	}

}
