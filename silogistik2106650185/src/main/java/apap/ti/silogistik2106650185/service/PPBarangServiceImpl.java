package apap.ti.silogistik2106650185.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106650185.repository.PPBarangDb;

@Service
public class PPBarangServiceImpl implements PPBarangService {
    @Autowired
    PPBarangDb ppBarangDb;

    @Override
    public void save(PermintaanPengirimanBarang permintaanPengirimanBarang) {
        ppBarangDb.save(permintaanPengirimanBarang); 
    }
    
}
