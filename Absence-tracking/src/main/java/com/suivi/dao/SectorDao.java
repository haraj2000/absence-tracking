package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Cycle;
import com.suivi.bean.Sector;

@Repository
public interface SectorDao extends JpaRepository<Sector, Long>{

	public Sector findByLibelle(String libelle);
	public List<Sector> findByCycle(Cycle cycle);
	public int deleteByLibelle(String libelle);
}
