package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.PermintaanPengiriman;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;

public interface PPBarangService {
    void save(PermintaanPengirimanBarang permintaanPengirimanBarang);

    boolean cekStok(List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang);

    List<PermintaanPengirimanBarang> filter(String sku, String startDate, String endDate);

    List<PermintaanPengirimanBarang> getAllPermintaanPengirimanBarang();
}
