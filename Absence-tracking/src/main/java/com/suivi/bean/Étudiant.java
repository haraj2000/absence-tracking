package com.suivi.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Étudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
