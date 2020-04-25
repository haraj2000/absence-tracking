package com.suivi.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Séance;

public interface AbsenceDao extends JpaRepository<Absence, Long> {

	public Absence findByRef(String ref);
	public Absence findByEtudiant(Etudiant etudiant);
	public List<Absence> findBySéance(Séance séance);
	public List<Absence> findByModule(Module module);
	public int deleteByRef(String ref);

}
