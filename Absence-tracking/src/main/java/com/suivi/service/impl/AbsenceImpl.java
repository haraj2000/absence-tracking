package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Séance;
import com.suivi.dao.AbsenceDao;
import com.suivi.service.facade.AbsenceService;
import com.suivi.service.facade.EtudiantService;

@Service
public class AbsenceImpl implements AbsenceService{

	@Autowired
	private AbsenceDao absenceDao;
	private EtudiantService etudiantService;


	@Override
	public List<Absence> findBySéance(Séance séance) {
		return absenceDao.findBySéance(séance);
	}

	@Override
	public int save(Absence absence) {
		String ref = absence.getEtudiant().getFirstName() +" "+ absence.getEtudiant().getLastName() + " pendant le "+absence.getSéance().getLibelle();
		absence.setRef(ref);
		Absence absenceFounded = findByRef(absence.getRef());
		Etudiant etudiantFounded = etudiantService.findByCne(absence.getEtudiant().getCne());
		if(absenceFounded == null) {
			etudiantFounded.setNbrAbsence(etudiantFounded.getNbrAbsence()+1);
			absenceDao.save(absence);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Absence absence) {
		String ref = absence.getEtudiant().getFirstName() +" "+ absence.getEtudiant().getLastName() + " pendant le "+absence.getSéance().getLibelle();
		absence.setRef(ref);
		Absence absenceFounded = findByRef(absence.getRef());
		if(absenceFounded!= null) {
			absenceFounded.setJustification(absence.getJustification());
			absenceDao.save(absenceFounded);
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
	@Transactional
	public int deleteByRef(String ref) {
		return absenceDao.deleteByRef(ref);
	}

	@Override
	public List<Absence> findByEtudiant(Etudiant etudiant) {
		return absenceDao.findByEtudiant(etudiant);
	}





}
