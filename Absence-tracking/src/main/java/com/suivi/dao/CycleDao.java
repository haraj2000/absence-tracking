package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Cycle;

@Repository
public interface CycleDao extends JpaRepository<Cycle, Long>{

	public Cycle findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
