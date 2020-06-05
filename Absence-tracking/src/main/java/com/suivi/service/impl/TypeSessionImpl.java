package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSession;
import com.suivi.dao.TypeSessionDao;
import com.suivi.service.facade.TypeSessionService;

@Service
public class TypeSessionImpl implements TypeSessionService{

	@Autowired
	private TypeSessionDao typeSessionDao;
	
	@Override
	public TypeSession findByLibelle(String libelle) {
		return typeSessionDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return typeSessionDao.deleteByReference(reference);
	}

	@Override
	public int save(TypeSession typeSession) {
		TypeSession typeSéanceFounded = findByReference(typeSession.getReference());
		if(typeSéanceFounded == null) {
			typeSessionDao.save(typeSession);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<TypeSession> findAll() {
		return typeSessionDao.findAll();
	}

	@Override
	public List<TypeSession> findByEnseignant(Enseignant enseignant) {
		return typeSessionDao.findByEnseignant(enseignant);
	}
	@Override
	public List<TypeSession> findByModule(Module module) {
		return typeSessionDao.findByModule(module);
	}

	@Override
	public TypeSession findByReference(String reference) {
		return typeSessionDao.findByReference(reference);
	}

	@Override
	public int update(TypeSession typeSession) {
		TypeSession typeSéanceFounded = findByReference(typeSession.getReference());
		if(typeSéanceFounded!= null) {
			typeSéanceFounded.setLibelle(typeSession.getLibelle());
			typeSéanceFounded.setEnseignant(typeSession.getEnseignant());
			typeSéanceFounded.setModule(typeSession.getModule());
			typeSessionDao.save(typeSéanceFounded);
			return 1;
		}
		else return -1;
	}
}
