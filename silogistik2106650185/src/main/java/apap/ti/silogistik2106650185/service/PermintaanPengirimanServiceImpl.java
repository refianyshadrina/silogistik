package apap.ti.silogistik2106650185.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106650185.model.PermintaanPengiriman;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106650185.repository.PermintaanPengirimanDb;

@Service
public class PermintaanPengirimanServiceImpl implements PermintaanPengirimanService {

    @Autowired
    PermintaanPengirimanDb permintaanPengirimanDb;

    @Override
    public List<PermintaanPengiriman> getAllPermintaanPengiriman() {
        return permintaanPengirimanDb.findAll();
    }

    @Override
    public Long getCountJumlahPP() {
        return permintaanPengirimanDb.count();
    }

    @Override
    public PermintaanPengiriman getPPById(Long id) {
        for (PermintaanPengiriman permintaanPengiriman : getAllPermintaanPengiriman()) {
            if (permintaanPengiriman.getIdPermintaanPengiriman().equals(id)) {
                return permintaanPengiriman;
            }
        }
        return null;
    }

    @Override
    public void save(PermintaanPengiriman permintaanPengiriman) {

        // LocalDateTime currentDateTime = LocalDateTime.now();
        
        // permintaanPengiriman.setNomorPengiriman("temp");
        // permintaanPengiriman.setWaktuPermintaan(currentDateTime);
        permintaanPengirimanDb.save(permintaanPengiriman);
    }

    @Override
    public void generateNomor(PermintaanPengiriman ppFromDto) {
        int jmlBarang = 0;
        for (PermintaanPengirimanBarang ppBarang : ppFromDto.getListPermintaanPengirimanBarang()) {
            jmlBarang += ppBarang.getKuantitasPengiriman();
        }
        
        String noPengiriman = "";
        if (jmlBarang > 99) {
            String jumlah = String.valueOf(jmlBarang);
            String format = jumlah.substring(jumlah.length() - 2);
            noPengiriman = "REQ" + format;
        } else if (jmlBarang < 10 ){
            noPengiriman = "REQ0" + jmlBarang;
        } else {
            noPengiriman = "REQ" + jmlBarang;
        }
        
        switch (ppFromDto.getJenisLayanan()) {
            case 1 :
                noPengiriman += "SAM";
                break;
            case 2 :
                noPengiriman += "KIL";
                break;
            case 3 :
                noPengiriman += "REG";
                break;
            case 4 :
                noPengiriman += "HEM";
                break;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        String formattedDateTime = ppFromDto.getWaktuPermintaan().format(formatter);

        noPengiriman += formattedDateTime;
        
        ppFromDto.setNomorPengiriman(noPengiriman.substring(0, Math.min(noPengiriman.length(), 16)));
    }

    @Override
    public PermintaanPengiriman getPPByNomor(String id) {
        for (PermintaanPengiriman permintaanPengiriman : getAllPermintaanPengiriman()) {
            if (permintaanPengiriman.getNomorPengiriman().equals(id)) {
                return permintaanPengiriman;
            }
        }
        return null;
    }

    @Override
    public void delete(PermintaanPengiriman permintaan) {
        permintaanPengirimanDb.deleteById(permintaan.getIdPermintaanPengiriman());
    }
    
}
