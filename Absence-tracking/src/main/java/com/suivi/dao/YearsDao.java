package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Years;

@Repository
public interface YearsDao extends JpaRepository<Years, Long>{
	public Years findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);

}
