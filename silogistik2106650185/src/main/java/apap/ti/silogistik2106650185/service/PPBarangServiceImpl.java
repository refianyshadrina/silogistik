package apap.ti.silogistik2106650185.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106650185.repository.PPBarangDb;

@Service
public class PPBarangServiceImpl implements PPBarangService {
    @Autowired
    PPBarangDb ppBarangDb;

    @Autowired
    BarangService barangService;

    @Override
    public void save(PermintaanPengirimanBarang permintaanPengirimanBarang) {
        ppBarangDb.save(permintaanPengirimanBarang); 
    }

    @Override
    public boolean cekStok(List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang) {
        for (PermintaanPengirimanBarang ppBarang : listPermintaanPengirimanBarang) {
            if (ppBarang.getKuantitasPengiriman() >= barangService.calculateStock(ppBarang.getBarang())) {
                return true;
            }
        }
        return false;
    }
    
}
