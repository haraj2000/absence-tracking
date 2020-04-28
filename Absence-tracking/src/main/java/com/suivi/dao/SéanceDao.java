package com.suivi.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.Séance;
import com.suivi.bean.TypeSéance;

public interface SéanceDao extends JpaRepository<Séance, Long> {
	
	public Séance findByLibelle(String libelle);
	public List<Séance> findByDateStart(Date date);
	public List<Séance> findByDateStop(Date date);
	public List<Séance> findByTypeSéance(TypeSéance typeSéance);
	public List<Séance> findByEnseignant(Enseignant enseignant);
	public List<Séance> findByModule(Module module);
	public int deleteByLibelle(String libelle);

}
