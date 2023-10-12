package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.PermintaanPengiriman;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;

public interface PermintaanPengirimanService {

    List<PermintaanPengiriman> getAllPermintaanPengiriman();

    Long getCountJumlahPP();

    PermintaanPengiriman getPPById(Long id);

    void save(PermintaanPengiriman permintaanPengiriman);

    void generateNomor(PermintaanPengiriman ppFromDto);

    PermintaanPengiriman getPPByNomor(String id);

    void delete(PermintaanPengiriman permintaan);

    void create(PermintaanPengiriman ppFromDto,  List<PermintaanPengirimanBarang> permintaanPengirimanBarangs);

    Long calculateTotal(PermintaanPengirimanBarang ppBarang);
    
}
