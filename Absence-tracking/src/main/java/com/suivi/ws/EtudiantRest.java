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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Filière;
import com.suivi.bean.Groupe;
import com.suivi.service.facade.EtudiantService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/etudiant")
public class EtudiantRest {
	@Autowired
	private EtudiantService etudiantService;

	@GetMapping("/role/{role}")
	public List<Etudiant> findByRole(@PathVariable int role) {
		return etudiantService.findByRole(role);
	}

	@GetMapping("/firstName/{firstName}")
	public List<Etudiant> findByFirstName(@PathVariable String firstName) {
		return etudiantService.findByFirstName(firstName);
	}

	@GetMapping("/lastName/{lastName}")
	public List<Etudiant> findByLastName(@PathVariable String lastName) {
		return etudiantService.findByLastName(lastName);
	}

	@GetMapping("/groupe")
	public List<Etudiant> findByGroupe(@RequestBody Groupe groupe) {
		return etudiantService.findByGroupe(groupe);
	}

	@GetMapping("/cin/{cin}")
	public Etudiant findByCin(@PathVariable String cin) {
		return etudiantService.findByCin(cin);
	}

	@GetMapping("/nbrAbsence/{nbrAbsence}")
	public List<Etudiant> findByNbrAbsence(@PathVariable int nbrAbsence) {
		return etudiantService.findByNbrAbsence(nbrAbsence);
	}

	@GetMapping("/mail/{mail}")
	public Etudiant findByMail(@PathVariable String mail) {
		return etudiantService.findByMail(mail);
	}

	@DeleteMapping("/codeApogee/{codeApogee}")
	public int deleteByCodeApogee(@PathVariable int codeApogee) {
		return etudiantService.deleteByCodeApogee(codeApogee);
	}

	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return etudiantService.deleteByCin(cin);
	}

	@PostMapping("/")
	public int save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}

	@PutMapping("/")
	public int update(@RequestBody Etudiant etudiant) {
		return etudiantService.update(etudiant);
	}

	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@GetMapping("/cne/{cne}")
	public Etudiant findByCne(@PathVariable String cne) {
		return etudiantService.findByCne(cne);
	}

	@DeleteMapping("/cne/{cne}")
	public int deleteByCne(@PathVariable String cne) {
		return etudiantService.deleteByCne(cne);
	}

	@GetMapping("/filiere")
	public List<Etudiant> findByFiliere(@RequestBody Filière filiere) {
		return etudiantService.findByFiliere(filiere);
	}


	@GetMapping("/codeApogee/{codeApogee}")
	public Etudiant findByCodeApogee(@PathVariable int codeApogee) {
		return etudiantService.findByCodeApogee(codeApogee);
	}
	@PostMapping("/upload/{cne}")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file, @PathVariable String cne) throws IOException {
		return etudiantService.uplaodImage(file, cne);
	}
	@GetMapping("/get/{cin}")
	public Etudiant getImage(@PathVariable String cin) throws IOException {
		return etudiantService.getImage(cin);
	}

}
