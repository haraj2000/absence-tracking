package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;

@Repository
public interface AbsenceDao extends JpaRepository<Absence, Long> {

	public Absence findByRef(String ref);
	public List<Absence> findByEtudiant(Etudiant etudiant);
	public List<Absence> findBySession(Session session);
	public List<Absence> findBySessionTypeSessionModule(Module module); 
	public List<Absence> findBySessionTypeSession(TypeSession typeSession); 
	public int deleteByRef(String ref);

}
