package apap.ti.silogistik2106650185.service;

import java.util.List;

import apap.ti.silogistik2106650185.model.Gudang;

public interface GudangService {
    List<Gudang> getAllGudang();

    void saveGudang(Gudang gudang);

    Gudang getGudangById(Long id);

    Gudang restock(Gudang gudang);

    Long getCountGudang();
}
