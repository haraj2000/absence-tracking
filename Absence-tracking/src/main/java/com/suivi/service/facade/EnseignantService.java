package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;

public interface EnseignantService {

	public List<Enseignant> findByFirstName(String firstName);
	public List<Enseignant> findByFirstLast(String firstLast);
	public Enseignant findByMatricule(String matricule);
	public Enseignant findByCin(String cin);
	public Enseignant findByMail(String mail);
	public int deleteByMatricule(String matricule);
	public int deleteByCin(String cin);
	public int save(Enseignant enseignant);
	public int update(Enseignant enseignant);
	public List<Enseignant> findAll();
}
