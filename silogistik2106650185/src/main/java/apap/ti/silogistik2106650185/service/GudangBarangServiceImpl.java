package apap.ti.silogistik2106650185.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106650185.model.GudangBarang;
import apap.ti.silogistik2106650185.repository.GudangBarangDb;

@Service
public class GudangBarangServiceImpl implements GudangBarangService{

    @Autowired
    GudangBarangDb gudangBarangDb;

    @Override
    public List<GudangBarang> getAllGudangBarang() {
        return gudangBarangDb.findAll();
    }

    @Override
    public void saveGudangBarang(GudangBarang gudangBarangFromDTO) {
        // if (getAllGudangBarang() == null || getAllGudangBarang().size() == 0) {
        //     gudangBarangDb.save(gudangBarang);
        // } else {

        //     for (GudangBarang gb : getAllGudangBarang()) {
        //         if (gudangBarang.getBarang().getSku().equals(gb.getBarang().getSku()) && gudangBarang.getGudang().getIdGudang().equals(gb.getGudang().getIdGudang())) {
        //             gb.setStok(gudangBarang.getStok());
        //         } else {
        //             gudangBarangDb.save(gudangBarang);
        //         }
        //     }
        // }
        gudangBarangDb.save(gudangBarangFromDTO);
    }

    @Override
    public void deleteGudangBarang(GudangBarang gb) {
        gudangBarangDb.delete(gb);

    }

    @Override
    public GudangBarang getGudangBarangById(Long id) {
        for (GudangBarang gb : getAllGudangBarang()) {
            if (gb.getIdGudangBarang().equals(id)) {
                return gb;
            }
        }
        return null;
    }


    
}
