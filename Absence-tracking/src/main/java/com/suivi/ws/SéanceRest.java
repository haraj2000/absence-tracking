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

import com.suivi.bean.Séance;
import com.suivi.bean.TypeSéance;
import com.suivi.service.facade.SéanceService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/seance")
public class SéanceRest {
	@Autowired
	private SéanceService séanceService;

	@GetMapping("/date/{date}")
	public List<Séance> findByDate(@PathVariable Date date) {
		return séanceService.findByDate(date);
	}
	@GetMapping("hourStart/{hourStart}")
	public List<Séance> findByHourStart(@PathVariable Date hourStart) {
		return séanceService.findByHourStart(hourStart);
	}
	@GetMapping("hourStop/{hourStop}")
	public List<Séance> findByHourStop(@PathVariable Date hourStop) {
		return séanceService.findByHourStop(hourStop);
	}
	@GetMapping("/typeSeance")
	public List<Séance> findByTypeSéance(@RequestBody TypeSéance typeSéance) {
		return séanceService.findByTypeSéance(typeSéance);
	}

	@GetMapping("/libelle/{libelle}")
	public Séance findByLibelle(@PathVariable String libelle) {
		return séanceService.findByLibelle(libelle);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return séanceService.deleteByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody Séance séance) {
		return séanceService.save(séance);
	}

	@GetMapping("/")
	public List<Séance> findAll() {
		return séanceService.findAll();
	}


	@PutMapping("/")
	public int update(@RequestBody Séance séance) {
		return séanceService.update(séance);
	}
	

}
