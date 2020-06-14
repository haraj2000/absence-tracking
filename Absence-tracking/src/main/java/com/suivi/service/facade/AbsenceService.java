package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;

public interface AbsenceService {
	public Absence findByRef(String ref);
	public List<Absence> findByEtudiant(Etudiant etudiant);
	public List<Absence> findBySession(Session session);
	public int deleteByRef(String ref);
	public Absence save(Absence absence);
	public int update(Absence absence);
	public List<Absence> findAll();
	public List<Absence> findBySessionTypeSessionModule(Module module);
	public List<Absence> findBySessionTypeSession(TypeSession typeSession); 
}
