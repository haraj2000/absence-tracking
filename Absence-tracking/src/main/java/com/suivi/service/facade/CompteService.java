package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Compte;

public interface CompteService {
	
	public Compte findByMail(String mail);
	public List<Compte> findByRole(Integer role);
	public int deleteByMail(String mail);
	public int update(Compte compte);
	public int save(Compte compte);
	public List<Compte> findAll();

}
