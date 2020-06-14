package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Years;

public interface YearsService {
	public Years findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Years years);
	public List<Years> findAll();
}
