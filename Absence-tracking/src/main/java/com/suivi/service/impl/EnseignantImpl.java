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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Departement;
import com.suivi.bean.Enseignant;
import com.suivi.dao.EnseignantDao;
import com.suivi.service.facade.EnseignantService;

@Service
public class EnseignantImpl implements EnseignantService{

	@Autowired
	private EnseignantDao enseignantDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public List<Enseignant> findByFirstName(String firstName) {
		return enseignantDao.findByFirstName(firstName);
	}

	@Override
	public List<Enseignant> findByLastName(String lastName) {
		return enseignantDao.findByLastName(lastName);
	}

	@Override
	public Enseignant findByNumeroSOM(int numeroSOM) {
		return enseignantDao.findByNumeroSOM(numeroSOM);
	}

	@Override
	public Enseignant findByCin(String cin) {
		return enseignantDao.findByCin(cin);
	}


	@Override
	@Transactional
	public int deleteByNumeroSOM(int numeroSOM) {
		return enseignantDao.deleteByNumeroSOM(numeroSOM);
	}

	@Override
	@Transactional
	public int deleteByCin(String cin) {
		return enseignantDao.deleteByCin(cin);
	}

	@Override
	public Enseignant save(Enseignant enseignant) {
		Enseignant enseignantFounded = findByNumeroSOM(enseignant.getNumeroSOM());
		if(enseignantFounded == null) {
			String mail = enseignant.getFirstName()+"."+enseignant.getLastName()+"@uca.ma";
			String password = enseignant.getCin();
			enseignant.setMail(mail);
			enseignant.setPassword(bcryptEncoder.encode(password));
			enseignant.setRole(3);
			enseignantDao.save(enseignant);
			return enseignant;
		}
		else return null;
	}

	@Override
	public Enseignant update(Enseignant enseignant) {
		Enseignant enseignantFounded = findByNumeroSOM(enseignant.getNumeroSOM());
		String mail2 = enseignant.getFirstName()+"."+enseignant.getLastName()+"@uca.ma";
		if(enseignantFounded != null) {
			enseignantFounded.setDepartement(enseignant.getDepartement());
			enseignantFounded.setTel(enseignant.getTel());
			enseignantFounded.setFirstName(enseignant.getFirstName());
			enseignantFounded.setLastName(enseignant.getLastName());
			enseignantFounded.setBirthDay(enseignant.getBirthDay());
			enseignantFounded.setLastName(enseignant.getLastName());
			enseignantFounded.setPassword(bcryptEncoder.encode(enseignant.getPassword()));
			enseignantFounded.setRole(enseignant.getRole());
			enseignantFounded.setSex(enseignant.getSex());
			enseignantFounded.setVille(enseignant.getVille());
			String mail = enseignantFounded.getFirstName()+"."+enseignantFounded.getLastName()+"@uca.ma";
			if (enseignantFounded.getMail() != mail2) {
				enseignantFounded.setMail(mail);
			} else { enseignantFounded.setMail(enseignant.getMail());}
			enseignantDao.save(enseignantFounded);
			return enseignantFounded;
		}
		else return null;
	}

	@Override
	public List<Enseignant> findAll() {
		return enseignantDao.findAll();
	}

	@Override
	public List<Enseignant> findByDepartement(Departement departement) {
		return enseignantDao.findByDepartement(departement);
	}

	@Override
	public Enseignant findByMail(String mail) {
		return enseignantDao.findByMail(mail);
	}

	@Override
	public List<Enseignant> findByRole(int role) {
		return enseignantDao.findByRole(role);
	}

	@Override
	public int uplaodImage(MultipartFile file, int numeroSOM) throws IOException {
		Enseignant enseignant = enseignantDao.findByNumeroSOM(numeroSOM);
		System.out.println(enseignant.getImage());
			//	new Enseignant(compressBytes(file.getBytes()));
				enseignant.setImage(compressBytes(file.getBytes()));
				System.out.println(enseignant.getImage());
		enseignantDao.save(enseignant);
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
		public Enseignant getImage(String cin) throws IOException {
			final Enseignant image= enseignantDao.findByCin(cin);
			//Enseignant img = new Enseignant(cin,decompressBytes(image.getImage()));
			image.setImage(decompressBytes(image.getImage()));
			return image;
		}
}
