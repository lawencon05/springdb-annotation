package com.lawencon.springdb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mahasiswa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nim;
	private String nama;

	@ManyToOne
	@JoinColumn(name = "univ_id")
	private Universitas universitas;

	@Column(name = "waktu_masuk")
	private LocalDate waktuMasuk;

	public LocalDate getWaktuMasuk() {
		return waktuMasuk;
	}

	public void setWaktuMasuk(LocalDate waktuMasuk) {
		this.waktuMasuk = waktuMasuk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Universitas getUniversitas() {
		return universitas;
	}

	public void setUniversitas(Universitas universitas) {
		this.universitas = universitas;
	}
}
