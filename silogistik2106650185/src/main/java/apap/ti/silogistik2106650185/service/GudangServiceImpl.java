package apap.ti.silogistik2106650185.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106650185.model.Gudang;
import apap.ti.silogistik2106650185.repository.GudangDb;

@Service
public class GudangServiceImpl implements GudangService {

    @Autowired
    GudangDb gudangdb;

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
    
}
