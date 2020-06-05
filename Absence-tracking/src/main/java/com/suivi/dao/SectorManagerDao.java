package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Sector;
import com.suivi.bean.SectorManager;

@Repository
public interface SectorManagerDao extends JpaRepository<SectorManager, Long>{

	public SectorManager findBySector(Sector sector);
	public SectorManager findByEnseignant(Enseignant enseignant);
	public int deleteBySector(Sector sector);
	
}
