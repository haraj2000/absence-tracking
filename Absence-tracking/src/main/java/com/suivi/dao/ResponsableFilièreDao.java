package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Filière;
import com.suivi.bean.ResponsableFilière;

@Repository
public interface ResponsableFilièreDao extends JpaRepository<ResponsableFilière, Long>{

	public ResponsableFilière findByFilière(Filière filière);
	public ResponsableFilière findByEnseignant(Enseignant enseignant);
	public int deletebYFilière(Filière filière);
	
}
