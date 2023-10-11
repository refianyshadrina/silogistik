package apap.ti.silogistik2106650185.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import apap.ti.silogistik2106650185.service.BarangService;
import apap.ti.silogistik2106650185.service.GudangService;
import apap.ti.silogistik2106650185.service.KaryawanService;
import apap.ti.silogistik2106650185.service.PermintaanPengirimanService;

@Controller
public class BaseController {
    @Autowired
    GudangService gudangService;

    @Autowired
    BarangService barangService;

    @Autowired
    PermintaanPengirimanService permintaanPengirimanService;

    @Autowired
    KaryawanService karyawanService;


    @GetMapping("/")
    private String Home(Model model) {
        model.addAttribute("jumlahGudang", gudangService.getCountGudang());
        model.addAttribute("jumlahBarang", barangService.getCountBarang());
        model.addAttribute("jumlahKaryawan", karyawanService.getCountKaryawan());
        return "home";
    }
}
