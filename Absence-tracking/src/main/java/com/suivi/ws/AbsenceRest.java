package com.suivi.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Absence;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Séance;
import com.suivi.service.facade.AbsenceService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/absence")
public class AbsenceRest {
	@Autowired
	private AbsenceService absenceService;

	@GetMapping("/date/{date}")
	public Absence findByDate(@PathVariable Date date) {
		return absenceService.findByDate(date);
	}

	@GetMapping("/")
	public Absence findByEtudiant(@RequestBody Etudiant etudiant) {
		return absenceService.findByEtudiant(etudiant);
	}

	@GetMapping("/")
	public Absence findBySéance(@RequestBody Séance séance) {
		return absenceService.findBySéance(séance);
	}

	@DeleteMapping("/date/{date}")
	public int deleteByDate(@PathVariable Date date) {
		return absenceService.deleteByDate(date);
	}

	@PostMapping("/")
	public int save(@RequestBody Absence absence) {
		return absenceService.save(absence);
	}

	@PutMapping("/")
	public int update(@RequestBody Absence absence) {
		return absenceService.update(absence);
	}

	@GetMapping("/")
	public List<Absence> findAll() {
		return absenceService.findAll();
	}
	
	

}
