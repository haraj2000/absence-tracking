package com.suivi.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Séance;
import com.suivi.bean.TypeSéance;

public interface SéanceDao extends JpaRepository<Séance, Long> {
	
	public Séance findByLibelle(String libelle);
	public List<Séance> findByDate(Date date);
	public List<Séance> findByHourStart(Date hourStart);
	public List<Séance> findByHourStop(Date hourStop);
	public List<Séance> findByTypeSéance(TypeSéance typeSéance);
	public int deleteByLibelle(String libelle);

}
