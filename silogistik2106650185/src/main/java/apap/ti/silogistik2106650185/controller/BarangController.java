package apap.ti.silogistik2106650185.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.service.BarangService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("")
    public String viewAllBarang(Model model) {
        List<Barang> listBarang = barangService.getAllBarang();
        model.addAttribute("listBarang", listBarang);
        model.addAttribute("page", "barang");
        return "viewall-barang";
    }

    @GetMapping("/{sku}")
    public String detailGudang(@PathVariable("sku") String sku, Model model) {
        var barang = barangService.getBarangBySKU(sku);
        // var barangDTO = barangMapper.ba;\
        var tipeBarang = "";
        switch(barang.getTipeBarang()) {
            case 1: 
                tipeBarang = "Elektronik";
                break;
            case 2:
                tipeBarang = "Pakaian";
                break;
            case 3:
                tipeBarang = "Makanan";
                break;
            case 4:
                tipeBarang = "Cosmetik";
                break;
            case 5:
                tipeBarang = "Alat";
                break;
        }

        model.addAttribute("barang", barang);
        model.addAttribute("tipeBarang", tipeBarang);

        model.addAttribute("page", "barang");
        return "detail-barang";
    }


}
