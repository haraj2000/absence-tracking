package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Sector;
import com.suivi.bean.SectorManager;

public interface SectorManagerService {

	public SectorManager findBySector(Sector sector);
	public SectorManager findByEnseignant(Enseignant enseignant);
	public int deleteBySector(Sector sector);
	public int save(SectorManager sectorManager, String filiere);
	public int update(SectorManager sectorManager, String libelle);
	public List<SectorManager> findAll();
}
