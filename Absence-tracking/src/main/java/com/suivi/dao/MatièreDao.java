package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Matière;

@Repository
public interface MatièreDao extends JpaRepository<Matière, Long>{

	public Matière findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
