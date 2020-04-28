package com.suivi.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.TypeSéance;

@Repository
public interface TypeSéanceDao extends JpaRepository<TypeSéance, Long>{

	public TypeSéance  findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);			
}
