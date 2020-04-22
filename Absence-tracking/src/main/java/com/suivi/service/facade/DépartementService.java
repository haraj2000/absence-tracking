package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Département;

public interface DépartementService {

	public Département findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Département département);
	public int update(Département département);
	public List<Département> findAll();
}
