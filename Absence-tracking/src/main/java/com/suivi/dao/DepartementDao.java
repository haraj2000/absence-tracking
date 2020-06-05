package com.suivi.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Departement;

@Repository
public interface DepartementDao extends JpaRepository<Departement, Long>{

	public Departement findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
