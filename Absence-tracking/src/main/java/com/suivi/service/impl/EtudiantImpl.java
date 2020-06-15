package com.suivi.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Etudiant;
import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.bean.Groupe;
import com.suivi.dao.EtudiantDao;
import com.suivi.service.facade.EtudiantService;

@Service
public class EtudiantImpl implements EtudiantService {
	
	@Autowired
	private EtudiantDao etudiantDao;

	@Override
	public List<Etudiant> findByFirstName(String firstName) {
		return etudiantDao.findByFirstName(firstName);
	}

	@Override
	public List<Etudiant> findByLastName(String lastName) {
		return etudiantDao.findByLastName(lastName);
	}

	@Override
	public List<Etudiant> findByGroupe(Groupe groupe) {
		return etudiantDao.findByGroupe(groupe);
	}

	@Override
	public Etudiant findByCin(String cin) {
		return etudiantDao.findByCin(cin);
	}


	@Override
	@Transactional
	public int deleteByCin(String cin) {
		return etudiantDao.deleteByCin(cin);
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCne(etudiant.getCne());
		if(etudiantFounded == null) {
			String mail = etudiant.getFirstName()+"."+etudiant.getLastName()+"@edu.uca.ma";
			String password = etudiant.getCne();
			etudiant.setMail(mail);
			etudiant.setPassword(password);
			etudiant.setRole(4);
			etudiantDao.save(etudiant);
			return etudiant;
		}
		else return null;
	}

	@Override
	public Etudiant update(Etudiant etudiant) {
		Etudiant etudiantFounded = findByCin(etudiant.getCin());
		String mail2 = etudiant.getFirstName()+"."+etudiant.getLastName()+"@edu.uca.ma";
		if(etudiantFounded != null) {
			etudiantFounded.setTel(etudiant.getTel());
			etudiantFounded.setFirstName(etudiant.getFirstName());
			etudiantFounded.setLastName(etudiant.getLastName());
			etudiantFounded.setPassword(etudiant.getPassword());
			etudiantFounded.setBirthDay(etudiant.getBirthDay());
			etudiantFounded.setGroupe(etudiant.getGroupe());
			etudiantFounded.setSector(etudiant.getSector());
			etudiantFounded.setImage(etudiant.getImage());
			etudiantFounded.setSex(etudiant.getSex());
			etudiantFounded.setVille(etudiant.getVille());
			String mail = etudiantFounded.getFirstName()+"."+etudiantFounded.getLastName()+"@edu.uca.ma";
			if (etudiantFounded.getMail() != mail2) {
				etudiantFounded.setMail(mail);
			} else { etudiantFounded.setMail(etudiant.getMail());}
			etudiantDao.save(etudiantFounded);
			return etudiantFounded;
		}
		else return null;
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}

	@Override
	public Etudiant findByCne(String cne) {
		return etudiantDao.findByCne(cne);
	}

	@Override
	@Transactional
	public int deleteByCne(String cne) {
		return etudiantDao.deleteByCne(cne);
	}

	@Override
	public List<Etudiant> findBySector(Sector sector) {
		return etudiantDao.findBySector(sector);
	}


	@Override
	public Etudiant findByCodeApogee(int codeApogee) {
		return etudiantDao.findByCodeApogee(codeApogee);
	}

	@Override
	public List<Etudiant> findByNbrAbsence(int nbrAbsence) {
		return etudiantDao.findByNbrAbsence(nbrAbsence);
	}

	@Override
	public Etudiant findByMail(String mail) {
		return etudiantDao.findByMail(mail);
	}

	@Override
	@Transactional
	public int deleteByCodeApogee(int codeApogee) {
		return etudiantDao.deleteByCodeApogee(codeApogee);
	}

	@Override
	public List<Etudiant> findByRole(int role) {
		return etudiantDao.findByRole(role);
	}
	@Override
	public int uplaodImage(MultipartFile file, String cne) throws IOException {
		Etudiant etudiant = etudiantDao.findByCne(cne);
				etudiant.setImage(compressBytes(file.getBytes()));
		etudiantDao.save(etudiant);
		return 1;
	}
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}

		@Override
		public Etudiant getImage(String cin) throws IOException {
			final Etudiant image= etudiantDao.findByCin(cin);
			image.setImage(decompressBytes(image.getImage()));
			return image;
		}

		@Override
		public List<Etudiant> findByGroupeSemestre(Semestre semestre) {
			return etudiantDao.findByGroupeSemestre(semestre);
		}

}
