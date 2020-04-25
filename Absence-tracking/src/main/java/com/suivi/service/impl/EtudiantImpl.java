package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Compte;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Filière;
import com.suivi.bean.Groupe;
import com.suivi.dao.EtudiantDao;
import com.suivi.service.facade.CompteService;
import com.suivi.service.facade.EtudiantService;
import com.suivi.service.facade.GroupeService;

@Service
public class EtudiantImpl implements EtudiantService {
	
	@Autowired
	private EtudiantDao etudiantDao;
	private CompteService compteService;
	private GroupeService groupeService;

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
			Compte compte = new Compte(mail, etudiant.getCin(), 4);
			compteService.save(compte);
			etudiant.setCompte(compte);
			etudiant.getGroupe().getEtudiants().add(etudiant);
			groupeService.update(etudiant.getGroupe());
			etudiantDao.save(etudiant);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCin(etudiant.getCin());
		if(etudiantFounded != null) {
			int r = compteService.update(etudiant.getCompte());
			if (r==1) {
				etudiantFounded.setCompte(etudiant.getCompte());
			}
			etudiantFounded.setTel(etudiant.getTel());
			etudiantFounded.setFirstName(etudiant.getFirstName());
			etudiantFounded.setLastName(etudiant.getLastName());
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
	public int deleteByCne(String cne) {
		return etudiantDao.deleteByCne(cne);
	}

	@Override
	public List<Etudiant> findByFilière(Filière filière) {
		return etudiantDao.findByFilière(filière);
	}


	@Override
	public Etudiant findByCodeApogee(String codeApogee) {
		return etudiantDao.findByCodeApogee(codeApogee);
	}

	@Override
	public List<Etudiant> findByNbrAbsence(int nbrAbsence) {
		return etudiantDao.findByNbrAbsence(nbrAbsence);
	}

	@Override
	public Etudiant findByCompteMail(String mail) {
		return etudiantDao.findByCompteMail(mail);
	}

	@Override
	public int deleteByCodeApogee(int codeApogee) {
		return etudiantDao.deleteByCodeApogee(codeApogee);
	}


}
