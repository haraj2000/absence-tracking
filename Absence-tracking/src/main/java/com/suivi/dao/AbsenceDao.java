package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Session;

public interface AbsenceDao extends JpaRepository<Absence, Long> {

	public Absence findByRef(String ref);
	public List<Absence> findByEtudiant(Etudiant etudiant);
	public List<Absence> findBySession(Session session);
	public int deleteByRef(String ref);

}
