package apap.ti.silogistik2106650185.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.model.GudangBarang;
import apap.ti.silogistik2106650185.repository.BarangDb;

@Service
public class BarangServiceImpl implements BarangService {

    @Autowired
    BarangDb barangDb;

    @Override
    public List<Barang> getAllBarang() {
        return barangDb.findAll();
    }

    @Override
    public Long getCountBarang() {
        return barangDb.count();
    }

    @Override
    public void saveBarang(Barang barang) {
        barangDb.save(barang);
    }

    @Override
    public void generateSKU(Barang barang) {
        int idIncrement;
        if (getAllBarang().size() == 0 || getAllBarang() == null) {
            idIncrement = 1;
        } else {
            idIncrement = getAllBarang().size() + 1;
        }

        String tipeBarang = "";
        switch(barang.getTipeBarang()) {
            case 1:
                tipeBarang = "ELEC";
                break;
            case 2:
                tipeBarang = "CLOT";
                break;
            case 3:
                tipeBarang = "FOOD";
                break;
            case 4:
                tipeBarang = "COSM";
                break;
            case 5:
                tipeBarang = "TOOL";
                break;
        }

        DecimalFormat decimalFormat = new DecimalFormat("000");
        String formatted_number = decimalFormat.format(idIncrement);

        String sku = tipeBarang + formatted_number;

        barang.setSku(sku);
    }

    @Override
    public void resetGudangBarang(Barang barang) {
        barang.setListGudangBarang(new ArrayList<>());
    }

    @Override
    public void resetPermintaanPengirimanBarang(Barang barang) {

        barang.setListPermintaanPengirimanBarang(new ArrayList<>());
    }

    @Override
    public Barang getBarangBySKU(String sku) {
        for (Barang barang : getAllBarang()) {
            if (barang.getSku().equals(sku)) {
                return barang;
            }
        }
        return null;
    }

    @Override
    public Object updateBarang(Barang baranFromDTO) {
        Barang barang = getBarangBySKU(baranFromDTO.getSku());
        if (barang != null) {
            barang.setTipeBarang(baranFromDTO.getTipeBarang());
            barang.setMerk(baranFromDTO.getMerk());
            barang.setHargaBarang(baranFromDTO.getHargaBarang());
            //kalo dia update tipe barang, update sku juga.
            // barang.setSku(baranFromDTO.getSku());
            barangDb.save(barang);
        }
        return barang;
    }

    @Override
    public Barang restock(Barang barang) {
        Barang barangasli = getBarangBySKU(barang.getSku());
        barangasli.setListGudangBarang(barang.getListGudangBarang());
        barangDb.save(barangasli);
        return barangasli;
    }

    @Override
    public int calculateStock(Barang barang) {
        int stok = 0;
        for (GudangBarang gudangBarang : barang.getListGudangBarang()) {
            stok += gudangBarang.getStok();
        }
        return stok;
    }
    
}
