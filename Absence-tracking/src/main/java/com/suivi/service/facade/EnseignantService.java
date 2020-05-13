package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Département;
import com.suivi.bean.Enseignant;

public interface EnseignantService {

	public List<Enseignant> findByFirstName(String firstName);
	public List<Enseignant> findByLastName(String lastName);
	public Enseignant findByNumeroSOM(int numeroSOM);
	public Enseignant findByCin(String cin);
	public List<Enseignant> findByDépartement(Département département);
	public Enseignant findByMail(String mail);
	public int deleteByNumeroSOM(int numeroSOM);
	public int deleteByCin(String cin);
	public List<Enseignant> findByRole(int role);
	public int save(Enseignant enseignant);
	public int update(Enseignant enseignant);
	public List<Enseignant> findAll();
}
