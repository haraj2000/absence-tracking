package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Sector;
import com.suivi.bean.SectorManager;
import com.suivi.dao.SectorManagerDao;
import com.suivi.service.facade.EnseignantService;
import com.suivi.service.facade.SectorService;
import com.suivi.service.facade.SectorManagerService;

@Service
public class SectorManagerImpl implements SectorManagerService{

	@Autowired
	private SectorManagerDao sectorManagerDao;
	@Autowired
	private EnseignantService enseignantService;
	@Autowired
	private SectorService sectorService;
	
	@Override
	public SectorManager findBySector(Sector sector) {
		return sectorManagerDao.findBySector(sector);
	}

	@Override
	public SectorManager findByEnseignant(Enseignant enseignant) {
		return sectorManagerDao.findByEnseignant(enseignant);
	}

	@Override
	@Transactional
	public int deleteBySector(Sector sector) {
		return sectorManagerDao.deleteBySector(sector);
	}

	@Override
	public int save(SectorManager sectorManager, String libelle) {
		Sector sector = sectorService.findByLibelle(libelle);
		SectorManager sectorManagerFounded = findBySector(sector);
		if(sectorManagerFounded == null) {
			sectorManager.getEnseignant().setRole(2);
			sectorManager.setSector(sector);
			enseignantService.update(sectorManager.getEnseignant());
			sectorManagerDao.save(sectorManager);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(SectorManager sectorManager, String libelle) {
		Sector sector = sectorService.findByLibelle(libelle);
		SectorManager sectorManagerFounded = findBySector(sector);
		if(sectorManagerFounded != null) {
			sectorManagerFounded.getEnseignant().setRole(3);
			enseignantService.update(sectorManagerFounded.getEnseignant());
			sectorManager.getEnseignant().setRole(2);
			enseignantService.update(sectorManager.getEnseignant());
			sectorManagerFounded.setEnseignant(sectorManager.getEnseignant());
			sectorManagerDao.save(sectorManagerFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<SectorManager> findAll() {
		return sectorManagerDao.findAll();
	}

}
