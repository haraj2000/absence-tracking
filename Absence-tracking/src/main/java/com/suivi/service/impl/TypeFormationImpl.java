package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeFormation;
import com.suivi.dao.TypeFormationDao;
import com.suivi.service.facade.TypeFormationService;

@Service
public class TypeFormationImpl implements TypeFormationService{

	@Autowired
	private TypeFormationDao typeFormationDao;
	
	@Override
	public TypeFormation findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeFormation> findByEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeFormation> findByMatière(Matière matière) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeFormation> findByModule(Module module) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(TypeFormation typeFormation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TypeFormation typeFormation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TypeFormation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
