package com.suivi.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Séance;

public interface SéanceDao extends JpaRepository<Séance, Long> {
	
	public Séance findByLibelle(String libelle);
	public Séance findByDate(Date date);
	public Séance findByHourStart(Date hourStart);
	public Séance findByHourStop(Date hourStop);
	public int deleteByLibelle(String libelle);

}
