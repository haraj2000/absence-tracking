package com.suivi.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Compte;

public interface CompteDao extends JpaRepository<Compte, Long> {

	public Compte findByMail(String mail);
	public Compte findByRole(String role);
	public int deleteByMail(String mail);
	
}
