package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.GudangBarang;

public interface GudangBarangService {
    void saveGudangBarang(GudangBarang gudangBarang);

    List<GudangBarang> getAllGudangBarang();

    void deleteGudangBarang(GudangBarang gb);

    GudangBarang getGudangBarangById(Long id);
}
