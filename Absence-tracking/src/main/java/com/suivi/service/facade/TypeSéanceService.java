package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;

public interface TypeSéanceService {

	public TypeSéance  findByLibelle(String libelle);
	public TypeSéance findByReference(String reference);
	public List<TypeSéance> findByEnseignant(Enseignant enseignant);
	public List<TypeSéance> findByModule(Module module);
	public int deleteByReference(String reference);		
	public int update(TypeSéance typeSéance);
	public int save(TypeSéance typeSéance);
	public List<TypeSéance> findAll();
}
