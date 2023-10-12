package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.PermintaanPengiriman;

public interface PermintaanPengirimanService {

    List<PermintaanPengiriman> getAllPermintaanPengiriman();

    Long getCountJumlahPP();

    PermintaanPengiriman getPPById(Long id);

    void save(PermintaanPengiriman permintaanPengiriman);

    void generateNomor(PermintaanPengiriman ppFromDto);
    
}
