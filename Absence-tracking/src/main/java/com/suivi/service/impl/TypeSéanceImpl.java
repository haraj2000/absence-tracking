package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;
import com.suivi.dao.TypeSéanceDao;
import com.suivi.service.facade.TypeSéanceService;

@Service
public class TypeSéanceImpl implements TypeSéanceService{

	@Autowired
	private TypeSéanceDao typeSéanceDao;
	
	@Override
	public TypeSéance findByLibelle(String libelle) {
		return typeSéanceDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return typeSéanceDao.deleteByReference(reference);
	}

	@Override
	public int save(TypeSéance typeSéance) {
		TypeSéance typeSéanceFounded = findByReference(typeSéance.getReference());
		if(typeSéanceFounded == null) {
			typeSéanceDao.save(typeSéance);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<TypeSéance> findAll() {
		return typeSéanceDao.findAll();
	}

	@Override
	public List<TypeSéance> findByEnseignant(Enseignant enseignant) {
		return typeSéanceDao.findByEnseignant(enseignant);
	}
	@Override
	public List<TypeSéance> findByModule(Module module) {
		return typeSéanceDao.findByModule(module);
	}

	@Override
	public TypeSéance findByReference(String reference) {
		return typeSéanceDao.findByReference(reference);
	}

	@Override
	public int update(TypeSéance typeSéance) {
		TypeSéance typeSéanceFounded = findByReference(typeSéance.getReference());
		if(typeSéanceFounded!= null) {
			typeSéanceFounded.setLibelle(typeSéance.getLibelle());
			typeSéanceFounded.setEnseignant(typeSéance.getEnseignant());
			typeSéanceFounded.setModule(typeSéance.getModule());
			typeSéanceDao.save(typeSéanceFounded);
			return 1;
		}
		else return -1;
	}
}
