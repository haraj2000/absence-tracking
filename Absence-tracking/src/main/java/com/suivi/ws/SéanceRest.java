package com.suivi.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/dateStart/{dateStart}")
	public List<Séance> findByDateStart(@PathVariable Date date) {
		return séanceService.findByDateStart(date);
	}
	@GetMapping("dateStop/{dateStop}")
	public List<Séance> findByDateStop(@PathVariable Date hourStop) {
		return séanceService.findByDateStop(hourStop);
	}
	@GetMapping("/typeSeance")
	public List<Séance> findByTypeSéance(@RequestBody TypeSéance typeSéance) {
		return séanceService.findByTypeSéance(typeSéance);
	}
	@GetMapping("/libelle/{libelle}")
	public Séance findByLibelle(@PathVariable String libelle) {
		return séanceService.findByLibelle(libelle);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return séanceService.deleteByReference(reference);
	}
	@PostMapping("/")
	public int save(@RequestBody Séance séance) {
		return séanceService.save(séance);
	}
	@GetMapping("/")
	public List<Séance> findAll() {
		return séanceService.findAll();
	}
	@PostMapping("/update")
	public int update(@RequestBody Séance séance) {
		return séanceService.update(séance);
	}
	@GetMapping("/reference/{reference}")
	public Séance findByReference(@PathVariable String reference) {
		return séanceService.findByReference(reference);
	}
	
}
