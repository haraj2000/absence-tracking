package com.suivi.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Compte;

public interface CompteDao extends JpaRepository<Compte, Long> {

	public Compte findByMail(String mail);
	public List<Compte> findByRole(int role);
	public int deleteByMail(String mail);
}
