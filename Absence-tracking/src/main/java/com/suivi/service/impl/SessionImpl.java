package com.suivi.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Semestre;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;
import com.suivi.dao.SessionDao;
import com.suivi.service.facade.SessionService;

@Service
public class SessionImpl implements SessionService {
	@Autowired
	private SessionDao sessionDao;

	@Override
	public Session findByLibelle(String libelle) {
		return sessionDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return sessionDao.deleteByReference(reference);
	}

	@Override
	public Session save(Session session) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(session.getDateStart());
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + session.getPeriode());
		session.setDateStop(calendar.getTime());
		System.out.println(session.getDateStart());
		System.out.println("hana binathum");
		System.out.println(session.getDateStop());
		String reference =  session.getTypeSession().getReference()+" " + session.getDateStart().toString();
		Session séanceFounded = findByReference(session.getReference());
		if(séanceFounded == null) { 
			session.setReference(reference);
			sessionDao.save(session);
			return session;
		}
		else return null;
	}

	@Override
	public List<Session> findAll() {
		return sessionDao.findAll();
	}

	@Override
	public Session update(Session session) {
		if (session.getDateStop() == null) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(session.getDateStart());
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + session.getPeriode());
		session.setDateStop(calendar.getTime());
		}
		session.getDateStop().setTime(session.getDateStart().getTime() + session.getPeriode()*60000);
		String libelle = session.getTypeSession().getLibelle()+" "+ session.getTypeSession().getSubject().getLibelle();
		String reference = libelle + session.getDateStart().toString();
		Session séanceFounded = findByReference(session.getReference());
		if(séanceFounded!= null) {
			séanceFounded.setReference(reference);
			séanceFounded.setLibelle(session.getLibelle());
			séanceFounded.setDateStart(session.getDateStart());
			séanceFounded.setDateStop(session.getDateStop());
			séanceFounded.setPeriode(session.getPeriode());
			sessionDao.save(séanceFounded);
			return séanceFounded;
		}
		else return null;
	}

	@Override
	public List<Session> findByDateStart(Date date) {
		return sessionDao.findByDateStart(date);
	}

	@Override
	public List<Session> findByDateStop(Date hourStart) {
		return sessionDao.findByDateStop(hourStart);
	}
	@Override
	public List<Session> findByTypeSession(TypeSession typeSession) {
		return sessionDao.findByTypeSession(typeSession);
	}

	@Override
	public Session findByReference(String reference) {
		return sessionDao.findByReference(reference);
	}

	@Override
	public Session findByDateStartAndTypeSessionEnseignant(Date dateStart, Enseignant enseignant) {
		return sessionDao.findByDateStartAndTypeSessionEnseignant(dateStart, enseignant);
	}

	@Override
	public Session findByDateStartAndTypeSessionModuleSemestre(Date dateStart, Semestre semestre) {
		return sessionDao.findByDateStartAndTypeSessionModuleSemestre(dateStart, semestre);
	}

	@Override
	public List<Session> findByTypeSessionModuleSemestre(Semestre semestre) {
		return sessionDao.findByTypeSessionModuleSemestre(semestre);
	}

	@Override
	public List<Session> findByTypeSessionEnseignant(Enseignant enseignant) {
		return sessionDao.findByTypeSessionEnseignant(enseignant);
	}
}

