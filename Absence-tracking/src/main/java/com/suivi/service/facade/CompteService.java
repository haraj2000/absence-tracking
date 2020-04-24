package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Compte;

public interface CompteService {
	
	public Compte findByMail(String mail);
	public int deleteByMail(String mail);
	public int save(Compte compte);
	public List<Compte> findAll();

}
