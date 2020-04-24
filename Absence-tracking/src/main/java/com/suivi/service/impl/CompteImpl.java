package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Compte;
import com.suivi.dao.CompteDao;
import com.suivi.service.facade.CompteService;

@Service
public class CompteImpl implements CompteService {
	
	@Autowired
	private CompteDao compteDao;

	@Override
	public Compte findByMail(String mail) {
		return compteDao.findByMail(mail);
	}

	@Override
	@Transactional
	public int deleteByMail(String mail) {
		return compteDao.deleteByMail(mail);
	}

	@Override
	public int save(Compte compte) {
		Compte compteFouded = findByMail(compte.getMail());
		if(compteFouded == null) {
			compteDao.save(compte);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Compte> findAll() {
		return compteDao.findAll();
	}

}
