package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.Barang;

public interface BarangService {

    List<Barang> getAllBarang();

    void saveBarang(Barang barang);

    Barang getBarangBySKU(String sku);
    
}
