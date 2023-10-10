package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.Karyawan;

public interface KaryawanService {
    List<Karyawan> getAllKaryawan();

    void saveKaryawan(Karyawan karyawan);

    Karyawan getKaryawanById(Long id);
}
