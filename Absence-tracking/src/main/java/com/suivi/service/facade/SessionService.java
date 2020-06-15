package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Semestre;
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
	public Session findByDateStartAndTypeSessionEnseignant(Date dateStart, Enseignant enseignant);
	public Session findByDateStartAndTypeSessionModuleSemestre(Date dateStart, Semestre semestre);
	public List<Session> findByTypeSessionModuleSemestre(Semestre semestre);
	public List<Session> findByTypeSessionEnseignant(Enseignant enseignant);
}
