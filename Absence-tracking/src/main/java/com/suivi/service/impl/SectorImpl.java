package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Cycle;
import com.suivi.bean.Sector;
import com.suivi.dao.SectorDao;
import com.suivi.service.facade.SectorService;

@Service
public class SectorImpl implements SectorService{

	@Autowired
	private SectorDao sectorDao;
	
	@Override
	public Sector findByLibelle(String libelle) {
		return sectorDao.findByLibelle(libelle);
	}

	@Override
	public List<Sector> findByCycle(Cycle cycle) {
		return sectorDao.findByCycle(cycle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return sectorDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Sector sector) {
		Sector filiereFounded = findByLibelle(sector.getLibelle());
		if(filiereFounded == null) {
			sectorDao.save(sector);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Sector sector) {
		Sector filiereFounded = findByLibelle(sector.getLibelle());
		if(filiereFounded != null) {
			filiereFounded.setCycle(sector.getCycle());
			sectorDao.save(filiereFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Sector> findAll() {
		return sectorDao.findAll();
	}

}
