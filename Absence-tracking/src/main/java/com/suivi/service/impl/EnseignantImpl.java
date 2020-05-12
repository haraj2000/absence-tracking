package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Département;
import com.suivi.bean.Enseignant;
import com.suivi.dao.EnseignantDao;
import com.suivi.service.facade.EnseignantService;

@Service
public class EnseignantImpl implements EnseignantService{

	@Autowired
	private EnseignantDao enseignantDao;
	
	@Override
	public List<Enseignant> findByFirstName(String firstName) {
		return enseignantDao.findByFirstName(firstName);
	}

	@Override
	public List<Enseignant> findByLastName(String lastName) {
		return enseignantDao.findByLastName(lastName);
	}

	@Override
	public Enseignant findByMatricule(String matricule) {
		return enseignantDao.findByMatricule(matricule);
	}

	@Override
	public Enseignant findByCin(String cin) {
		return enseignantDao.findByCin(cin);
	}


	@Override
	@Transactional
	public int deleteByMatricule(String matricule) {
		return enseignantDao.deleteByMatricule(matricule);
	}

	@Override
	@Transactional
	public int deleteByCin(String cin) {
		return enseignantDao.deleteByCin(cin);
	}

	@Override
	public int save(Enseignant enseignant) {
		Enseignant enseignantFounded = findByMatricule(enseignant.getMatricule());
		if(enseignantFounded == null) {
			String mail = enseignant.getFirstName()+"."+enseignant.getLastName()+"@edu.uca.ma";
			String password = enseignant.getCin();
			enseignant.setMail(mail);
			enseignant.setPassword(password);
			enseignant.setRole(3);
			enseignantDao.save(enseignant);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Enseignant enseignant) {
		Enseignant enseignantFounded = findByMatricule(enseignant.getMatricule());
		if(enseignantFounded != null) {
			String mail = enseignant.getFirstName()+"."+enseignant.getLastName()+"@edu.uca.ma";
			enseignantFounded.setDépartement(enseignant.getDépartement());
			enseignantFounded.setTel(enseignant.getTel());
			enseignantFounded.setFirstName(enseignant.getFirstName());
			enseignantFounded.setLastName(enseignant.getLastName());
			enseignantFounded.setPassword(enseignant.getPassword());
			enseignantFounded.setMail(mail);
			enseignantDao.save(enseignantFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Enseignant> findAll() {
		return enseignantDao.findAll();
	}

	@Override
	public List<Enseignant> findByDépartement(Département département) {
		return enseignantDao.findByDépartement(département);
	}

	@Override
	public Enseignant findByMail(String mail) {
		return enseignantDao.findByMail(mail);
	}

	@Override
	public List<Enseignant> findByRole(int role) {
		return enseignantDao.findByRole(role);
	}

}
