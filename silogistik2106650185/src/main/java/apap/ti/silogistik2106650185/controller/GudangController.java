package apap.ti.silogistik2106650185.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import apap.ti.silogistik2106650185.dto.GudangBarangMapper;
import apap.ti.silogistik2106650185.dto.GudangMapper;
import apap.ti.silogistik2106650185.dto.request.RestockGudangReqDTO;
import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.model.Gudang;
import apap.ti.silogistik2106650185.model.GudangBarang;
import apap.ti.silogistik2106650185.service.BarangService;
import apap.ti.silogistik2106650185.service.GudangBarangService;
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

    @Autowired
    private GudangBarangService gudangBarangService;

    @Autowired
    private GudangBarangMapper gudangBarangMapper;

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

        if (gudang.getListGudangBarang().size() != 0) {
            List<Barang> listBarang = new ArrayList<>();
            for (GudangBarang gudangBarang : gudang.getListGudangBarang()) {
                listBarang.add(gudangBarang.getBarang());
            }
            model.addAttribute("listBarang", listBarang);
        }
        return "detail-gudang";
    }

    // @GetMapping("{idGudang}/restock-barang")
    // public String restock(@PathVariable("idGudang") Long idGudang, Model model) {
    //     var gudang = gudangService.getGudangById(idGudang);

    //     var gudangDTO = gudangMapper.gudangToRestockGudangReqDTO(gudang);

    //     var gudangBarangDTO = new CreateGudangBarangDTO();
    //     // var gudangBarangDTO = new GudangBarang();

    //     var listBarangExisting = barangService.getAllBarang();

    //     gudangDTO.setListCreateGudangBarangDTO(new ArrayList<>());

    //     gudangDTO.getListCreateGudangBarangDTO().add(gudangBarangDTO);

    //     model.addAttribute("gudangDTO", gudangDTO);
    //     model.addAttribute("gudangBarangDTO", gudangBarangDTO);
    //     model.addAttribute("listBarang", listBarangExisting);

    //     return "form-updatestock-gudang";

    // }

    
    // @PostMapping(value = "/restock-barang", params = {"addRow"})
    // private String addRowDosenMultiple(@ModelAttribute RestockGudangReqDTO gudangDTO, @ModelAttribute CreateGudangBarangDTO createGudangBarangDTO, Model model){
    //     if (gudangDTO.getListCreateGudangBarangDTO() == null || gudangDTO.getListCreateGudangBarangDTO().size() == 0){
    //         gudangDTO.setListCreateGudangBarangDTO(new ArrayList<>());
    //     }
    //     gudangDTO.getListCreateGudangBarangDTO().add(new CreateGudangBarangDTO());

    //     model.addAttribute("listBarang", barangService.getAllBarang());
    //     model.addAttribute("gudangDTO", gudangDTO);
    //     model.addAttribute("gudangBarangDTO", createGudangBarangDTO);

    //     return "form-restock-gudang";
    // }


    // @PostMapping("/restock-barang")
    // public String postRestock(@ModelAttribute RestockGudangReqDTO gudangDTO, @ModelAttribute CreateGudangBarangDTO createGudangBarangDTO, Model model) {
    //     var gudang = gudangMapper.restockGudangReqDTOToGudang(gudangDTO);
    //     var listGudangBarangDTO = gudangDTO.getListCreateGudangBarangDTO();
    //     List<GudangBarang> listGudangBarang = new ArrayList<>();
    //     for (CreateGudangBarangDTO gudangBarangDTO : listGudangBarangDTO) {
    //         // gudangbarangMapper
    //         listGudangBarang.add(gudangBarangMapper.createGudangBarangDTOToGudangBarang(gudangBarangDTO));
    //     }

    //     gudang.setListGudangBarang(listGudangBarang);

    //     List<Gudang> listGudang = gudangService.getAllGudang();

    //     model.addAttribute("listGudang", listGudang);
    //     model.addAttribute("page", "gudang");

    //     return "viewall-gudang";
    // }

    @GetMapping("{idGudang}/restock-barang")
    public String restock(@PathVariable("idGudang") Long idGudang, Model model) {
        var gudang = gudangService.getGudangById(idGudang);

        var gudangDTO = gudangMapper.gudangToRestockGudangReqDTO(gudang);

        var listBarangExisting = barangService.getAllBarang();

        List<GudangBarang> listGudangBarang = new ArrayList<>();

        var gudangBarang = new GudangBarang();
        gudangBarang.setStok(1);
        gudangDTO.setListGudangBarang(listGudangBarang);
        gudangDTO.getListGudangBarang().add(gudangBarang);

        model.addAttribute("gudangDTO", gudangDTO);
        model.addAttribute("listBarang", listBarangExisting);

        return "form-updatestock-gudang";

    }

    
    @PostMapping(value = "/restock-barang", params = {"addRow"})
    private String addRow(@ModelAttribute RestockGudangReqDTO gudangDTO, Model model){
        if (gudangDTO.getListGudangBarang() == null || gudangDTO.getListGudangBarang().size() == 0){
            gudangDTO.setListGudangBarang(new ArrayList<>());
        }

        GudangBarang gudangBarang = new GudangBarang();
        gudangBarang.setStok(1);
        gudangDTO.getListGudangBarang().add(gudangBarang);

        model.addAttribute("listBarang", barangService.getAllBarang());
        model.addAttribute("gudangDTO", gudangDTO);

        return "form-updatestock-gudang";
    }


    @PostMapping(value = "/restock-barang")
    public String postRestock(@ModelAttribute RestockGudangReqDTO gudangDTO, Model model) {
        var gudangFromDTO = gudangMapper.restockGudangReqDTOToGudang(gudangDTO);

        for (GudangBarang gudangBarang : gudangFromDTO.getListGudangBarang()) {
            gudangBarang.setGudang(gudangService.getGudangById(gudangFromDTO.getIdGudang()));
            gudangBarangService.saveGudangBarang(gudangBarang);

            // gudangBarang.getBarang().setListGudangBarang(gudangFromDTO.getListGudangBarang());
            // barangService.restock(gudangBarang.getBarang());
            
        }

        gudangService.restock(gudangFromDTO);

        List<Gudang> listGudang = gudangService.getAllGudang();

        model.addAttribute("listGudang", listGudang);
        model.addAttribute("page", "gudang");

        return "viewall-gudang";
    }

}
