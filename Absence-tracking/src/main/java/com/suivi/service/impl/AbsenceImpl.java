package com.suivi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Séance;
import com.suivi.dao.AbsenceDao;
import com.suivi.service.facade.AbsenceService;

@Service
public class AbsenceImpl implements AbsenceService{

	@Autowired
	private AbsenceDao absenceDao;
	
	@Override
	public Absence findByDate(Date date) {
		return absenceDao.findByDate(date);
	}

	@Override
	public Absence findByEtudiant(Etudiant etudiant) {
		return absenceDao.findByEtudiant(etudiant);
	}

	@Override
	public Absence findBySéance(Séance séance) {
		return absenceDao.findBySéance(séance);
	}

	@Override
	public int deleteByDate(Date date) {
		return absenceDao.deleteByDate(date);
	}

	@Override
	public int save(Absence absence) {
		Absence absenceFounded = findByEtudiant(absence.getEtudiant());
		if(absenceFounded == null) {
			absenceDao.save(absence);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Absence absence) {
		Absence absenceFounded = findByEtudiant(absence.getEtudiant());
		if(absenceFounded!= null) {
			absenceFounded.setDate(absence.getDate());
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Absence> findAll() {
		return absenceDao.findAll();
	}

}
