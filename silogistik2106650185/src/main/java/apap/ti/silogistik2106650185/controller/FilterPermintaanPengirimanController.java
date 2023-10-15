package apap.ti.silogistik2106650185.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106650185.service.BarangService;
import apap.ti.silogistik2106650185.service.PPBarangService;
import apap.ti.silogistik2106650185.service.PermintaanPengirimanService;

@Controller
public class FilterPermintaanPengirimanController {
    @Autowired
    private PPBarangService ppBarangService;

    @Autowired
    BarangService barangService;

    @Autowired
    PermintaanPengirimanService ppService;

    @GetMapping("/filter-permintaan-pengiriman")
    public String filterPP(@RequestParam(value = "startDate", required = false) String startDate, 
                        @RequestParam(value = "endDate", required = false) String endDate,
                        @RequestParam(value = "sku", required = false) String sku, Model model) {

        List<Barang> listBarangExisting = new ArrayList<>();

        List<PermintaanPengirimanBarang> listPPBarang = new ArrayList<>();

        if (barangService.getAllBarang() != null || barangService.getAllBarang().size() != 0) {
            listBarangExisting = barangService.getAllBarang();
        }

        if (sku != null) {

            // listPPBarang = ppBarangService.filter(sku, startDate, endDate);

            if (!endDate.equals("") && !startDate.equals("")) {
                listPPBarang = ppBarangService.filter(sku, startDate, endDate);
            } else if (endDate.equals("") && startDate.equals("")) {
                listPPBarang = ppBarangService.filter(sku, null, null);
            } else if (endDate.equals("") && !startDate.equals("")) {
                listPPBarang = ppBarangService.filter(sku, startDate, null);
            } else if (!endDate.equals("") && startDate.equals("")) {
                listPPBarang = ppBarangService.filter(sku, null, endDate);
            }

            // if (listPPBarang == null || listPPBarang.size() == 0) {

            // }

            model.addAttribute("search", true);
        } else {
            // listPPBarang = ppBarangService.getAllPermintaanPengirimanBarang();
            model.addAttribute("search", false);
        }

        model.addAttribute("listBarangExisting", listBarangExisting);
        model.addAttribute("listPermintaanPengirimanAll", ppService.getAllPermintaanPengiriman());
        model.addAttribute("listPPFiltered", listPPBarang);
        model.addAttribute("page", "permintaanpengiriman");
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("barangCari", barangService.getBarangBySKU(sku));
        

        return "filter-pp";
        
    }

}
