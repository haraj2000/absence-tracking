package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Groupe;
import com.suivi.dao.EtudiantDao;
import com.suivi.service.facade.EtudiantService;
import com.sun.xml.bind.v2.util.EditDistance;

@Service
public class EtudiantImpl implements EtudiantService {
	
	@Autowired
	private EtudiantDao etudiantDao;

	@Override
	public List<Etudiant> findByFirstName(String firstName) {
		return etudiantDao.findByFirstName(firstName);
	}

	@Override
	public List<Etudiant> findByLastName(String lastName) {
		return etudiantDao.findByLastName(lastName);
	}

	@Override
	public List<Etudiant> findByGroupe(Groupe groupe) {
		return etudiantDao.findByGroupe(groupe);
	}

	@Override
	public Etudiant findByCin(String cin) {
		return etudiantDao.findByCin(cin);
	}

	@Override
	public Etudiant findByMail(String mail) {
		return etudiantDao.findByMail(mail);
	}

	@Override
	public int deleteByCin(String cin) {
		return etudiantDao.deleteByCin(cin);
	}

	@Override
	public int save(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCin(etudiant.getCin());
		if(etudiantFounded == null) {
			etudiantDao.save(etudiantFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCin(etudiant.getCin());
		if(etudiantFounded != null) {
			etudiantFounded.setMail(etudiant.getMail());
			etudiantFounded.setTel(etudiant.getTel());
			etudiantFounded.setFirstName(etudiant.getFirstName());
			etudiantFounded.setLastName(etudiant.getLastName());
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}

}