package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Departement;
import com.suivi.bean.Enseignant;

@Repository
public interface EnseignantDao extends JpaRepository<Enseignant, Long>{

	public List<Enseignant> findByFirstName(String firstName);
	public List<Enseignant> findByLastName(String lastName);
	public Enseignant findByNumeroSOM(int numeroSOM);
	public Enseignant findByCin(String cin);
	public List<Enseignant> findByDepartement(Departement departement);
	public Enseignant findByMail(String mail);
	public int deleteByNumeroSOM(int numeroSOM);
	public int deleteByCin(String cin);
	public List<Enseignant> findByRole(int role);
}
