package com.suivi.service.facade;

import java.util.Date;
import java.util.List;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Séance;

public interface AbsenceService {
	public Absence findByDate(Date date);
	public Absence findByEtudiant(Etudiant etudiant);
	public Absence findBySéance(Séance séance);
	public int deleteByDate(Date date);
	public int save(Absence absence);
	public int update(Absence absence);
	public List<Absence> findAll();

}
