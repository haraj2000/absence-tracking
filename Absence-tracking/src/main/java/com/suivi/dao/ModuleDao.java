package com.suivi.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Module;

public interface ModuleDao extends JpaRepository<Module, Long> {
	

	public Module findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);

	

}
