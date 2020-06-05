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
	private SectorService filiereService;
	
	@Override
	public SectorManager findByFilière(Sector sector) {
		return sectorManagerDao.findByFilière(sector);
	}

	@Override
	public SectorManager findByEnseignant(Enseignant enseignant) {
		return sectorManagerDao.findByEnseignant(enseignant);
	}

	@Override
	@Transactional
	public int deleteByFilière(Sector sector) {
		return sectorManagerDao.deleteByFilière(sector);
	}

	@Override
	public int save(SectorManager sectorManager, String libelle) {
		Sector sector = filiereService.findByLibelle(libelle);
		SectorManager responsableFilièreFounded = findByFilière(sector);
		if(responsableFilièreFounded == null) {
			sectorManager.getEnseignant().setRole(2);
			sectorManager.setFilière(sector);
			enseignantService.update(sectorManager.getEnseignant());
			sectorManagerDao.save(sectorManager);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(SectorManager sectorManager) {
		SectorManager responsableFilièreFounded = findByFilière(sectorManager.getFilière());
		if(responsableFilièreFounded != null) {
			responsableFilièreFounded.getEnseignant().setRole(3);
			enseignantService.update(responsableFilièreFounded.getEnseignant());
			sectorManager.getEnseignant().setRole(2);
			enseignantService.update(sectorManager.getEnseignant());
			responsableFilièreFounded.setEnseignant(sectorManager.getEnseignant());
			sectorManagerDao.save(responsableFilièreFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<SectorManager> findAll() {
		return sectorManagerDao.findAll();
	}

}
