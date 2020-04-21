package com.suivi.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cycle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
