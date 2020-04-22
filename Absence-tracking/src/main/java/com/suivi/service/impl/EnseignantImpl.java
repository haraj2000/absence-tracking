package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.dao.EnseignantDao;
import com.suivi.service.facade.EnseignantService;

@Service
public class EnseignantImpl implements EnseignantService{

	@Autowired
	private EnseignantDao enseignantDao;
	
	@Override
	public List<Enseignant> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findByCin(String cin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByCin(String cin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Enseignant enseignant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Enseignant enseignant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
