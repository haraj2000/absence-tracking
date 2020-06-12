package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;

public interface SessionService {

	public Session findByLibelle(String libelle);
	public Session findByReference(String reference);
	public List<Session> findByDateStart(Date date);
	public List<Session> findByDateStop(Date date);
	public List<Session> findByTypeSession(TypeSession typeSession);
	public int deleteByReference(String reference);
	public Session save(Session session);
	public Session update(Session session);
	public List<Session> findAll();
}
