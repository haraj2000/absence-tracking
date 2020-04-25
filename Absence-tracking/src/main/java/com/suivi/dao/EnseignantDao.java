package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Département;
import com.suivi.bean.Enseignant;

@Repository
public interface EnseignantDao extends JpaRepository<Enseignant, Long>{

	public List<Enseignant> findByFirstName(String firstName);
	public List<Enseignant> findByLastName(String lastName);
	public Enseignant findByMatricule(String matricule);
	public Enseignant findByCin(String cin);
	public List<Enseignant> findByDépartement(Département département);
	public Enseignant findByCompteMail(String mail);
	public int deleteByMatricule(String matricule);
	public int deleteByCin(String cin);
}
