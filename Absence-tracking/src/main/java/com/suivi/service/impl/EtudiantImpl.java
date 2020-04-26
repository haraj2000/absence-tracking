package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Transactional
	public int deleteByCin(String cin) {
		return etudiantDao.deleteByCin(cin);
	}

	@Override
	public int save(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCin(etudiant.getCin());
		if(etudiantFounded == null) {
			String mail = etudiant.getFirstName()+"."+etudiant.getLastName()+"@edu.uca.ma";
			String password = etudiant.getCin();
			etudiant.setMail(mail);
			etudiant.setPassword(password);
			etudiant.setRole(4);
			etudiantDao.save(etudiant);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCin(etudiant.getCin());
		if(etudiantFounded != null) {
			etudiantFounded.setTel(etudiant.getTel());
			etudiantFounded.setFirstName(etudiant.getFirstName());
			etudiantFounded.setLastName(etudiant.getLastName());
			etudiantFounded.setPassword(etudiant.getPassword());
			etudiantDao.save(etudiantFounded);
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
	@Transactional
	public int deleteByCne(String cne) {
		return etudiantDao.deleteByCne(cne);
	}

	@Override
	public List<Etudiant> findByFilière(Filière filière) {
		return etudiantDao.findByFilière(filière);
	}


	@Override
	public Etudiant findByCodeApogee(int codeApogee) {
		return etudiantDao.findByCodeApogee(codeApogee);
	}

	@Override
	public List<Etudiant> findByNbrAbsence(int nbrAbsence) {
		return etudiantDao.findByNbrAbsence(nbrAbsence);
	}

	@Override
	public Etudiant findByMail(String mail) {
		return etudiantDao.findByMail(mail);
	}

	@Override
	@Transactional
	public int deleteByCodeApogee(int codeApogee) {
		return etudiantDao.deleteByCodeApogee(codeApogee);
	}

	@Override
	public List<Etudiant> findByRole(int role) {
		return etudiantDao.findByRole(role);
	}


}
