package com.suivi.service.util;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Session;

public class SessionEtudiant {

	private Session session;
	private Etudiant etudiant;
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	@Override
	public String toString() {
		return "SessionEtudiant [session=" + session + ", etudiant=" + etudiant + "]";
	}
	public SessionEtudiant(Session session, Etudiant etudiant) {
		super();
		this.session = session;
		this.etudiant = etudiant;
	}
	public SessionEtudiant() {
		super();
	}
	
	
}
