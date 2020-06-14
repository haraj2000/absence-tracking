package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;
import com.suivi.dao.AbsenceDao;
import com.suivi.service.facade.AbsenceService;
import com.suivi.service.facade.EtudiantService;
import com.suivi.service.facade.SessionService;

@Service
public class AbsenceImpl implements AbsenceService{

	@Autowired
	private AbsenceDao absenceDao;
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private SessionService sessionService;


	@Override
	public List<Absence> findBySession(Session session) {
		return absenceDao.findBySession(session);
	}

	@Override
	public Absence save(Absence absence) {
		String ref = absence.getEtudiant().getFirstName() +" "+ absence.getEtudiant().getLastName() + " pendant le "+absence.getSession().getLibelle();
		absence.setRef(ref);
		Absence absenceFounded = findByRef(absence.getRef());
		String reference =  absence.getSession().getTypeSession().getLibelle()+" "+ absence.getSession().getTypeSession().getSubject().getLibelle() + absence.getSession().getDateStart().toString();
		Session seance = sessionService.findByReference(reference);
		if(absenceFounded == null) {
			absence.setSession(seance);
			System.out.println(absence);
			absenceDao.save(absence);
			return absence;
		}
		else return null;
	}

	@Override
	public int update(Absence absence) {
		String ref = absence.getEtudiant().getFirstName() +" "+ absence.getEtudiant().getLastName() + " pendant le "+absence.getSession().getLibelle();
		absence.setRef(ref);
		Absence absenceFounded = findByRef(absence.getRef());
		Etudiant etudiant = etudiantService.findByCin(absence.getEtudiant().getCin());
		if(absenceFounded!= null) {
			if (absence.isAbsent() != absenceFounded.isAbsent()) {
				absenceFounded.setAbsent(absence.isAbsent());	
				if (absenceFounded.isAbsent() == true && absenceFounded.getJustification() == null) {
					etudiant.setNbrAbsence(etudiant.getNbrAbsence() + 1);
					}
				else if (absenceFounded.isAbsent() == false && absenceFounded.getJustification() == null ) etudiant.setNbrAbsence(etudiant.getNbrAbsence() - 1);
			}else if (absence.getJustification() != null && absenceFounded.getJustification() == null) etudiant.setNbrAbsence(etudiant.getNbrAbsence() - 1);
			absenceFounded.setJustification(absence.getJustification());
			absenceDao.save(absenceFounded);
			etudiantService.save(etudiant);
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

	@Override
	public List<Absence> findBySessionTypeSessionModule(Module module) {
		return absenceDao.findBySessionTypeSessionModule(module);
	}

	@Override
	public List<Absence> findBySessionTypeSession(TypeSession typeSession) {
		return absenceDao.findBySessionTypeSession(typeSession);
	}





}
