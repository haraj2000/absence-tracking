package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.TypeSéance;

public interface TypeSéanceService {

	public TypeSéance  findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);		
	public int save(TypeSéance typeSéance);
	public List<TypeSéance> findAll();
}
