package com.suivi.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Séance;

public interface AbsenceDao extends JpaRepository<Absence, Long> {

	public Absence findByDate(Date date);
	public Absence findByEtudiant(Etudiant etudiant);
	public Absence findBySéance(Séance séance);
	public int deleteByDate(Date date);
	
}
