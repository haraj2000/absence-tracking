package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Sector;
import com.suivi.bean.SectorManager;

public interface SectorManagerService {

	public SectorManager findByFilière(Sector sector);
	public SectorManager findByEnseignant(Enseignant enseignant);
	public int deleteByFilière(Sector sector);
	public int save(SectorManager sectorManager, String libelle);
	public int update(SectorManager sectorManager);
	public List<SectorManager> findAll();
}
