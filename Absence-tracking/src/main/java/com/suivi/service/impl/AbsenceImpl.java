package com.suivi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Séance;
import com.suivi.dao.AbsenceDao;
import com.suivi.service.facade.AbsenceService;

@Service
public class AbsenceImpl implements AbsenceService{

	@Autowired
	private AbsenceDao absenceDao;

	@Override
	public Absence findByEtudiant(Etudiant etudiant) {
		return absenceDao.findByEtudiant(etudiant);
	}


	@Override
	public int save(Absence absence) {
		Absence absenceFounded = findByEtudiant(absence.getEtudiant());
		if(absenceFounded == null) {
			absenceDao.save(absenceFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Absence absence) {
		Absence absenceFounded = findByEtudiant(absence.getEtudiant());
		if(absenceFounded!= null) {
			absenceFounded.setEtudiant(absence.getEtudiant());
			absenceFounded.setModule(absence.getModule());
			absenceFounded.setSéance(absence.getSéance());
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Absence> findAll() {
		return absenceDao.findAll();
	}

	@Override
	public Absence findByRef(String ref) {
		return absenceDao.findByRef(ref);
	}

	@Override
	public List<Absence> findByModule(Module module) {
		return absenceDao.findByModule(module);
	}

	@Override
	public int deleteByRef(String ref) {
		return absenceDao.deleteByRef(ref);
	}


	@Override
	public List<Absence> findBySéance(Séance séance) {
		return absenceDao.findBySéance(séance);
	}




}
