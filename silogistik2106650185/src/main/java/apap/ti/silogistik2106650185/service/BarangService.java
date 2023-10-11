package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.Barang;

public interface BarangService {

    List<Barang> getAllBarang();

    void saveBarang(Barang barang);

    Barang getBarangBySKU(String sku);

    Object updateBarang(Barang baranFromDTO);
    void generateSKU(Barang barang);
    

    void resetGudangBarang(Barang barang);

    void resetPermintaanPengirimanBarang(Barang barang);

    Barang restock(Barang barang);
}
