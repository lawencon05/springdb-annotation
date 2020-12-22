package com.lawencon.springdb.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.springdb.model.Mahasiswa;
import com.lawencon.springdb.model.Universitas;

@Repository(value = "hibernateHQL")
public class MahasiswaDaoHibernateImpl extends BaseDaoImpl implements MahasiswaDao {

	@Override
	public void insert(Mahasiswa data) throws Exception {
		em.persist(data);
	}

	@Override
	public void insertReturnId(Mahasiswa data) throws Exception {
		em.persist(data);
	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		em.merge(data);
	}

	@Override
	public void updateCustom(Mahasiswa data) throws Exception {
		em.createQuery(" UPDATE Mahasiswa set nama = ?1 where id = ?2 ").setParameter(1, data.getNama())
				.setParameter(2, data.getId()).executeUpdate();
	}

	@Override
	public void delete(Mahasiswa data) throws Exception {
		em.remove(data);
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		List<Mahasiswa> listResult = em.createQuery("from Mahasiswa where id = ?1 ", Mahasiswa.class)
				.setParameter(1, id).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		List<Mahasiswa> listResult = em.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();

		return listResult;
	}

	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		List<Mahasiswa> listMhs = new ArrayList<>();
		List<Object[]> listObj = em.createQuery("SELECT m.id, m.nim, m.nama, u.id, u.nama, m.waktuMasuk "
				+ " FROM Mahasiswa as m" + " INNER JOIN m.universitas as u", Object[].class).getResultList();
		listObj.forEach(objArr -> {
			Mahasiswa mhs = new Mahasiswa();
			mhs.setId((Long) objArr[0]);
			mhs.setNim((String) objArr[1]);
			mhs.setNama((String) objArr[2]);

			Universitas univ = new Universitas();
			univ.setId((Long) objArr[3]);
			univ.setNama((String) objArr[4]);
			mhs.setUniversitas(univ);

			mhs.setWaktuMasuk((LocalDate) objArr[5]);
			listMhs.add(mhs);
		});

		return listMhs;
	}

}
