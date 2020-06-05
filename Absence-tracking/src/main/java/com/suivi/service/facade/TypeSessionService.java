package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSession;

public interface TypeSessionService {

	public TypeSession  findByLibelle(String libelle);
	public TypeSession findByReference(String reference);
	public List<TypeSession> findByEnseignant(Enseignant enseignant);
	public List<TypeSession> findByModule(Module module);
	public int deleteByReference(String reference);		
	public int update(TypeSession typeSession);
	public int save(TypeSession typeSession);
	public List<TypeSession> findAll();
}
