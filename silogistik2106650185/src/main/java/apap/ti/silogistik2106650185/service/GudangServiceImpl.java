package apap.ti.silogistik2106650185.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106650185.dto.request.RestockGudangReqDTO;
import apap.ti.silogistik2106650185.model.Gudang;
import apap.ti.silogistik2106650185.model.GudangBarang;
import apap.ti.silogistik2106650185.repository.GudangDb;

@Service
public class GudangServiceImpl implements GudangService {

    @Autowired
    GudangDb gudangdb;

    @Autowired
    private GudangBarangService gudangBarangService;

    @Override
    public List<Gudang> getAllGudang() {
        return gudangdb.findAll();
    }

    @Override
    public void saveGudang(Gudang gudang) {
        gudangdb.save(gudang);
    }

    @Override
    public Gudang getGudangById(Long id) {
        for (Gudang gudang: getAllGudang()) {
            if (gudang.getIdGudang().equals(id)) {
                return gudang;
            }
        }
        return null;
    }

    @Override
    public Gudang restock(Gudang gudangDTO, RestockGudangReqDTO gudangReqDTO) {
        Gudang gudang = getGudangById(gudangDTO.getIdGudang());
        
        gudang.setListGudangBarang(gudangReqDTO.getListGudangBarang());
        for (GudangBarang gb : gudang.getListGudangBarang()) {
            gb.setGudang(gudang);
        }
        gudangdb.save(gudang);
        for (GudangBarang gb : gudang.getListGudangBarang()) {
            for (GudangBarang gb1 : gudangBarangService.getAllGudangBarang()) {
                if (gb.getBarang() == gb1.getBarang() && gb1.getGudang() == gudang) {
                    gudangBarangService.deleteGudangBarang(gb1);
                }
            }
        }
        return gudang;

    }

    @Override
    public Long getCountGudang() {
        return gudangdb.count();
    }
    
}
