package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Matière;

public interface MatièreService {
	
	public Matière findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Matière matière);
	public List<Matière> findAll();
}
