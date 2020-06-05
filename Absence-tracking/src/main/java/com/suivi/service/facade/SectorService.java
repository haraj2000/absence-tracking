package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Cycle;
import com.suivi.bean.Sector;

public interface SectorService {

	public Sector findByLibelle(String libelle);
	public List<Sector> findByCycle(Cycle cycle);
	public int deleteByLibelle(String libelle);
	public int save(Sector sector);
	public int update(Sector sector);
	public List<Sector> findAll();
}
