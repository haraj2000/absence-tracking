package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Departement;

public interface DepartementService {

	public Departement findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Departement departement);
	public List<Departement> findAll();
}
