package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Séance;

public interface AbsenceService {
	public Absence findByRef(String ref);
	public List<Absence> findByEtudiant(Etudiant etudiant);
	public List<Absence> findBySéance(Séance séance);
	public int deleteByRef(String ref);
	public int save(Absence absence);
	public int update(Absence absence);
	public List<Absence> findAll();

}
