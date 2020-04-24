package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Groupe;
import com.suivi.dao.GroupeDao;
import com.suivi.service.facade.GroupeService;

@Service
public class GroupeImpl implements GroupeService {
	@Autowired
	private GroupeDao groupeDao;

	@Override
	public Groupe findByLibelle(String libelle) {
		return groupeDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return groupeDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Groupe groupe) {
		Groupe groupeFouded = findByLibelle(groupe.getLibelle());
		if(groupeFouded == null) {
			groupeDao.save(groupe);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Groupe> findAll() {
		return groupeDao.findAll();
	}

}
