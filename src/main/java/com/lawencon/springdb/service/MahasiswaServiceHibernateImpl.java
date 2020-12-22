package com.lawencon.springdb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.springdb.dao.MahasiswaDao;
import com.lawencon.springdb.model.Mahasiswa;

@Transactional
@Service
public class MahasiswaServiceHibernateImpl implements MahasiswaService {

	@Autowired
	@Qualifier(value = "hibernateNQ")
	private MahasiswaDao mahasiswaDao;

	@Override
	public void insert(Mahasiswa data) throws Exception {
		mahasiswaDao.insert(data);
	}

	@Override
	public void insertReturnId(Mahasiswa data) throws Exception {
		mahasiswaDao.insertReturnId(data);
	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		mahasiswaDao.update(data);
	}

	@Override
	public void updateCustom(Mahasiswa data) throws Exception {
		mahasiswaDao.updateCustom(data);
	}

	@Override
	public void delete(Mahasiswa data) throws Exception {
		mahasiswaDao.delete(data);
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		return mahasiswaDao.getMhsById(id);
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		return mahasiswaDao.getAllMhs();
	}

	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		return mahasiswaDao.getAllMhsCustom();
	}

}
