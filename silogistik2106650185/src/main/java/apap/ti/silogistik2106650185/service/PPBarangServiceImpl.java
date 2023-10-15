package apap.ti.silogistik2106650185.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    @Override
    public List<PermintaanPengirimanBarang> getAllPermintaanPengirimanBarang() {
        return ppBarangDb.findAll();
    }

    @Override
    public List<PermintaanPengirimanBarang> filter(String sku, String startDate, String endDate) {
        List<PermintaanPengirimanBarang> listPP = new ArrayList<>();

        for (PermintaanPengirimanBarang ppBarang : getAllPermintaanPengirimanBarang()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LocalDateTime theDate = ppBarang.getPermintaanPengiriman().getWaktuPermintaan();

            LocalDate parsedStartDate;
            LocalDate parsedEndDate;

            if (endDate != null && startDate != null) {

                parsedStartDate = LocalDate.parse(startDate, formatter);
                parsedEndDate = LocalDate.parse(endDate, formatter);

                if (ppBarang.getBarang().getSku().equals(sku) && theDate.toLocalDate().isBefore(parsedEndDate) && theDate.toLocalDate().isAfter(parsedStartDate)) {
                    listPP.add(ppBarang);
                }
            
            } else if (endDate == null && startDate == null) {

                if (ppBarang.getBarang().getSku().equals(sku)) {
                    listPP.add(ppBarang);
                }

            } else if (endDate == null && startDate != null) {

                parsedStartDate = LocalDate.parse(startDate, formatter);

                if (ppBarang.getBarang().getSku().equals(sku) && theDate.toLocalDate().isAfter(parsedStartDate)) {
                    listPP.add(ppBarang);
                }

            } else if (endDate != null && startDate == null) {

                parsedEndDate = LocalDate.parse(endDate, formatter);

                if (ppBarang.getBarang().getSku().equals(sku) && theDate.toLocalDate().isBefore(parsedEndDate)) {
                    listPP.add(ppBarang);
                }

            }
        }

        return listPP;
    }
    
}
