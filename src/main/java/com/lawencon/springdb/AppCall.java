package com.lawencon.springdb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lawencon.springdb.model.Mahasiswa;
import com.lawencon.springdb.model.Universitas;
import com.lawencon.springdb.service.MahasiswaService;

/**
 * @author lawencon05
 */
@Component
public class AppCall {

	@Autowired
	private MahasiswaService mhsService;

	public void call() {
		try {
			Mahasiswa m = new Mahasiswa();
			m.setNama("Iqbal");
			m.setNim("111");
			m.setWaktuMasuk(LocalDate.now());

			Universitas univ = new Universitas();
			univ.setId(1L);
			m.setUniversitas(univ);

			// mhsService.insert(m); // insert

			// m = mhsService.getMhsById(2L); // get by id
			if (m != null) {
				// m.setNama("Iqbal2");
				// mhsService.updateCustom(m); // update

				// mhsService.delete(m); // delete
			}

			List<Mahasiswa> listMhs = mhsService.getAllMhs();
			if (listMhs != null) {
				listMhs.forEach(val -> {
					System.out.println(val.getNama());
					System.out.println(val.getUniversitas().getNama());
					System.out.println(val.getWaktuMasuk());
				});
			}

			List<Mahasiswa> listMhsCustom = mhsService.getAllMhsCustom();
			if (listMhsCustom != null) {
				listMhsCustom.forEach(val -> {
					System.out.println(val.getNama());
					System.out.println(val.getUniversitas().getNama());
					System.out.println(val.getWaktuMasuk());
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
