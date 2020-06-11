package com.suivi.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		String reference =  session.getTypeSession().getLibelle()+" "+ session.getTypeSession().getSubject().getLibelle() + session.getDateStart().toString();
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
	public int update(Session session) {
		String libelle = session.getTypeSession().getLibelle()+" "+ session.getTypeSession().getSubject().getLibelle();
		String reference = libelle + session.getDateStart();
		Session séanceFounded = findByReference(reference);
		if(séanceFounded!= null) {
			séanceFounded.setLibelle(libelle);
			séanceFounded.setDateStart(session.getDateStart());
			séanceFounded.setDateStop(session.getDateStop());
			sessionDao.save(séanceFounded);
			return 1;
		}
		else return -1;
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
}

