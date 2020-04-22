package com.suivi.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Département;

@Repository
public interface DépartementDao extends JpaRepository<Département, Long>{

	public Département findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
