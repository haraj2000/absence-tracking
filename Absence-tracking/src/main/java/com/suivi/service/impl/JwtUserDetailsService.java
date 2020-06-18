package com.suivi.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Etudiant;
import com.suivi.dao.EnseignantDao;
import com.suivi.dao.EtudiantDao;

@Service
public class JwtUserDetailsService  implements UserDetailsService{
	
	@Autowired
	private EtudiantDao etudiantDao;
	@Autowired
	private EnseignantDao enseignantDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String mail = null;
		String password = null;
		System.out.println("hana ji hna yallah hmri lia wjhi");
		Enseignant enseignant = enseignantDao.findByMail(username);
		System.out.println(enseignant);
		Etudiant etudiant = etudiantDao.findByMail(username);
		System.out.println(etudiant);
		System.out.println("yallah hana 3awtani ach ban lik");
		if (enseignant != null) {
			System.out.println("wayli sd9t enseignant");
			mail = enseignant.getMail();
			password = enseignant.getPassword();
		}
		if (etudiant != null) {
			System.out.println("laaah ana etudiant ");
			mail = etudiant.getMail();
			password = etudiant.getPassword();
		}
		if (mail == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		System.out.println("mail: " + mail);
		System.out.println("password: "+ password);
		return new org.springframework.security.core.userdetails.User(mail,password,new ArrayList<>());
	}

	
}
