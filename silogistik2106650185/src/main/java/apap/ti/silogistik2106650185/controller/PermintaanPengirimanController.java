package apap.ti.silogistik2106650185.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import apap.ti.silogistik2106650185.model.PermintaanPengiriman;
import apap.ti.silogistik2106650185.service.PermintaanPengirimanService;

@Controller
@RequestMapping("/permintaan-pengiriman")
public class PermintaanPengirimanController {
    @Autowired
    private PermintaanPengirimanService permintaanPengirimanService;

    @GetMapping("")
    public String viewAllPermintaanPengiriman(Model model) {
        List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
        model.addAttribute("listPP", listPP);
        model.addAttribute("page", "permintaan pengiriman");
        return "viewall-permintaanpengiriman";
    }

    
}
