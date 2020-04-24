package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Séance;

public interface SéanceDao extends JpaRepository<Séance, Long> {
	
	public Séance findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);

}
