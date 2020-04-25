package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Filière;
import com.suivi.bean.Groupe;
import com.suivi.dao.EtudiantDao;
import com.suivi.service.facade.EtudiantService;

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
	@Transactional
	public int deleteByCin(String cin) {
		return etudiantDao.deleteByCin(cin);
	}

	@Override
	public int save(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCin(etudiant.getCin());
		if(etudiantFounded == null) {
			etudiantDao.save(etudiant);
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

	@Override
	public Etudiant findByCne(String cne) {
		return etudiantDao.findByCne(cne);
	}

	@Override
	public int deleteByCne(String cne) {
		return etudiantDao.deleteByCne(cne);
	}

	@Override
	public List<Etudiant> findByFiliere(Filière filière) {
		return etudiantDao.findByFiliere(filière);
	}

	@Override
	public Etudiant findByAbsence(Absence absence) {
		return etudiantDao.findByAbsence(absence);
	}

	@Override
	public Etudiant findByCodeApogee(String codeApogee) {
		return etudiantDao.findByCodeApogee(codeApogee);
	}

	@Override
	public Etudiant findBynCne(String cne) {
		return etudiantDao.findByCne(cne);
	}

}
