package apap.ti.silogistik2106650185.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import apap.ti.silogistik2106650185.dto.GudangMapper;
import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.model.Gudang;
import apap.ti.silogistik2106650185.model.GudangBarang;
import apap.ti.silogistik2106650185.service.BarangService;
import apap.ti.silogistik2106650185.service.GudangService;

@Controller
@RequestMapping("/gudang")
public class GudangController {
    @Autowired
    private GudangService gudangService;

    @Autowired
    private BarangService barangService;

    @Autowired
    private GudangMapper gudangMapper;

    @GetMapping("")
    public String viewAllGudang(Model model) {
        List<Gudang> listGudang = gudangService.getAllGudang();
        model.addAttribute("listGudang", listGudang);
        model.addAttribute("page", "gudang");
        return "viewall-gudang";
    }

    @GetMapping("/{id}")
    public String detailGudang(@PathVariable("id") Long id, Model model) {
        var gudang = gudangService.getGudangById(id);
        // var gudangDTO = gudangMapper.gudangToReadGudangResponseDTO(gudang);

        model.addAttribute("gudang", gudang);

        model.addAttribute("page", "gudang");
        return "detail-gudang";
    }

    @GetMapping("{idGudang}/restock-barang")
    public String restock(@PathVariable("idGudang") Long idGudang, Model model) {
        var gudang = gudangService.getGudangById(idGudang);

        var gudangBarangDTO = new GudangBarang();

        var listBarangExisting = barangService.getAllBarang();

        gudang.setListGudangBarang(new ArrayList<>());

        gudang.getListGudangBarang().add(gudangBarangDTO);

        model.addAttribute("gudang", gudang);
        model.addAttribute("gudangBarangDTO", gudangBarangDTO);
        model.addAttribute("listBarang", listBarangExisting);

        return "form-restock-gudang";

    }

    @PostMapping("{idGudang}/restock-barang")
    public String postRestock(@PathVariable("idGudang") Long idGudang, Model model) {
        
        return "viewall-gudang";
    }

}
