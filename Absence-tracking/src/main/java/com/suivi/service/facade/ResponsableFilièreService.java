package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Filière;
import com.suivi.bean.ResponsableFilière;

public interface ResponsableFilièreService {

	public ResponsableFilière findByFilière(Filière filière);
	public ResponsableFilière findByEnseignant(Enseignant enseignant);
	public int deleteByFilière(Filière filière);
	public int save(ResponsableFilière responsableFilière, String libelle);
	public int update(ResponsableFilière responsableFilière);
	public List<ResponsableFilière> findAll();
}
