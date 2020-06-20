package com.suivi.ws;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.suivi.bean.Departement;
import com.suivi.bean.Enseignant;
import com.suivi.service.facade.EnseignantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les enseignants")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/enseignant")
public class EnseignantRest {
	
	@Autowired
	private EnseignantService enseignantService;
	
	@ApiOperation("Rechercher des enseignants par role")
	@GetMapping("role/{role}")
	public List<Enseignant> findByRole(@PathVariable int role) {
		return enseignantService.findByRole(role);
	}
	@ApiOperation("Rechercher des enseignants par prénom")
	@GetMapping("firstName/{firstName}")
	public List<Enseignant> findByFirstName(@PathVariable String firstName) {
		return enseignantService.findByFirstName(firstName);
	}
	@ApiOperation("Rechercher des enseignants par nom")
	@GetMapping("/lastName/{lastName}")
	public List<Enseignant> findByLastName(@PathVariable String lastName) {
		return enseignantService.findByLastName(lastName);
	}
	@ApiOperation("Rechercher un enseignant par N°SOM")
	@GetMapping("/numeroSOM/{numeroSOM}")
	public Enseignant findByNumeroSOM(@PathVariable int numeroSOM) {
		return enseignantService.findByNumeroSOM(numeroSOM);
	}
	@ApiOperation("Rechercher un enseignant par cin")
	@GetMapping("/cin/{cin}")
	public Enseignant findByCin(@PathVariable String cin) {
		return enseignantService.findByCin(cin);
	}
	@ApiOperation("Rechercher des enseignants par département")
	@GetMapping("/departement")
	public List<Enseignant> findByDepartement(@RequestBody Departement departement) {
		return enseignantService.findByDepartement(departement);
	}
	@ApiOperation("Rechercher un enseignant par email")
	@GetMapping("/mail/{mail}")
	public Enseignant findByMail(@PathVariable String mail) {
		return enseignantService.findByMail(mail);
	}
	@ApiOperation("Supprimer un enseignant par N°SOM")
	@DeleteMapping("/numeroSOM/{numeroSOM}")
	public int deleteByNumeroSOM(@PathVariable int numeroSOM) {
		return enseignantService.deleteByNumeroSOM(numeroSOM);
	}
	@ApiOperation("Supprimer un enseignants par cin")
	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return enseignantService.deleteByCin(cin);
	}
	@ApiOperation("Enregistrer un enseignant")
	@PostMapping("/")
	public Enseignant save(@RequestBody Enseignant enseignant) {
		return enseignantService.save(enseignant);
	}
	@ApiOperation("Modifier enseignant")
	@PostMapping("/update")
	public Enseignant update(@RequestBody Enseignant enseignant) {
		return enseignantService.update(enseignant);
	}
	@ApiOperation("Rechercher tous les enseignants enregitrés")
	@GetMapping("/")
	public List<Enseignant> findAll() {
		return enseignantService.findAll();
	}
	@ApiOperation("Enregister l'image d'un enseignant")
	@PostMapping("/upload/{numeroSOM}")
	public int uplaodImage(@RequestParam("imageFile") MultipartFile file, @PathVariable int numeroSOM) throws IOException {
		return enseignantService.uplaodImage(file, numeroSOM);
	}
	@ApiOperation("Rechercher l'image d'un enseignant")
	@GetMapping("/get/{cin}")
	public Enseignant getImage(@PathVariable String cin) throws IOException {
		return enseignantService.getImage(cin);
	}
	@ApiOperation("Modifier le mot de passe d'un enseignant")
	@PostMapping("/password")
	public Enseignant password(@RequestBody Enseignant enseignant) {
		return enseignantService.password(enseignant);
	}

}
