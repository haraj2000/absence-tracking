package com.suivi.ws;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Département;
import com.suivi.bean.Enseignant;
import com.suivi.service.facade.EnseignantService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/enseignant")
public class EnseignantRest {
	
	@Autowired
	private EnseignantService enseignantService;
	
	@GetMapping("role/{role}")
	public List<Enseignant> findByRole(int role) {
		return enseignantService.findByRole(role);
	}
	@GetMapping("firstName/{firstName}")
	public List<Enseignant> findByFirstName(@PathVariable String firstName) {
		return enseignantService.findByFirstName(firstName);
	}
	@GetMapping("/lastName/{lastName}")
	public List<Enseignant> findByLastName(@PathVariable String lastName) {
		return enseignantService.findByLastName(lastName);
	}
	@GetMapping("/numeroSOM/{numeroSOM}")
	public Enseignant findByNumeroSOM(@PathVariable int numeroSOM) {
		return enseignantService.findByNumeroSOM(numeroSOM);
	}
	@GetMapping("/cin/{cin}")
	public Enseignant findByCin(@PathVariable String cin) {
		return enseignantService.findByCin(cin);
	}
	@GetMapping("/departement")
	public List<Enseignant> findByDépartement(@RequestBody Département département) {
		return enseignantService.findByDépartement(département);
	}
	@GetMapping("/mail/{mail}")
	public Enseignant findByMail(@PathVariable String mail) {
		return enseignantService.findByMail(mail);
	}
	@DeleteMapping("/numeroSOM/{numeroSOM}")
	public int deleteByNumeroSOM(@PathVariable int numeroSOM) {
		return enseignantService.deleteByNumeroSOM(numeroSOM);
	}
	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return enseignantService.deleteByCin(cin);
	}
	@PostMapping("/")
	public int save(@RequestBody Enseignant enseignant) {
		return enseignantService.save(enseignant);
	}
	@PostMapping("/update")
	public int update(@RequestBody Enseignant enseignant) {
		return enseignantService.update(enseignant);
	}
	@GetMapping("/")
	public List<Enseignant> findAll() {
		return enseignantService.findAll();
	}
	@PostMapping("/upload/{numeroSOM}")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file, @PathVariable int numeroSOM) throws IOException {
		return enseignantService.uplaodImage(file, numeroSOM);
	}
	@GetMapping("/get/{cin}")
	public Enseignant getImage(@PathVariable String cin) throws IOException {
		return enseignantService.getImage(cin);
	}

}
