package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Groupe;

public interface GroupeService {
	
	public Groupe findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Groupe groupe);
	public List<Groupe> findAll();

}
