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

import apap.ti.silogistik2106650185.dto.BarangMapper;
import apap.ti.silogistik2106650185.dto.request.CreateBarangReqDTO;
import apap.ti.silogistik2106650185.dto.request.UpdateBarangReqDTO;
import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.service.BarangService;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Controller
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @Autowired
    private BarangMapper barangMapper;

    @GetMapping("")
    public String viewAllBarang(Model model) {
        List<Barang> listBarang = barangService.getAllBarang();
  
        model.addAttribute("listBarang", listBarang);
        model.addAttribute("barangService", barangService);
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
        model.addAttribute("stok", barangService.calculateStock(barang));

        model.addAttribute("page", "barang");
        return "detail-barang";
    }

    @GetMapping("/tambah")
    public String formAddBarang(Model model) {
        var barangDTO = new CreateBarangReqDTO();

        model.addAttribute("barangDTO", barangDTO);

        model.addAttribute("page", "barang");
        return "form-add-barang";
    }

    @PostMapping("/tambah")
    public String addBarang(@Valid @ModelAttribute CreateBarangReqDTO barangDTO,BindingResult bindingResult,  Model model) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            List<String> errorMessage = new ArrayList<>();
            for (ObjectError error : errors) {
                errorMessage.add(error.getDefaultMessage());
            }
            model.addAttribute("errorMessage",errorMessage);
            List<Barang> listBarang = barangService.getAllBarang();
            model.addAttribute("listBarang", listBarang);
            model.addAttribute("page", "barang");
            return "error-view";
        }

        if (barangService.isMerkExist(barangDTO.getMerk())) {
            var errorMessage = "Barang dengan merk tersebut sudah pernah ditambahkan.";
            model.addAttribute("errorMessage", errorMessage);
            List<Barang> listBarang = barangService.getAllBarang();
            model.addAttribute("listBarang", listBarang);
            model.addAttribute("page", "barang");
            return "error-view";
        }

        var barang = barangMapper.createBarangReqDTOToBarang(barangDTO);
        barangService.generateSKU(barang);
        barangService.resetGudangBarang(barang);
        barangService.resetPermintaanPengirimanBarang(barang);
        barangService.saveBarang(barang);

        List<Barang> listBarang = barangService.getAllBarang();
        model.addAttribute("listBarang", listBarang);
        model.addAttribute("merk", barang.getMerk());
        model.addAttribute("barangService", barangService);
        model.addAttribute("page", "barang");
        return "success-add";

    }

    @GetMapping("/{idBarang}/ubah")
    public String formUpdateBarang(@PathVariable("idBarang") String idBarang, Model model) {

        var barang = barangService.getBarangBySKU(idBarang);

        var barangDTO = barangMapper.barangToUpdateBarangReqDTO(barang);

        model.addAttribute("barangDTO", barangDTO);

        model.addAttribute("page", "barang");
        return "form-update-barang";
    }

    @PostMapping("/{idBarang}/ubah")
    public String updateBuku(@PathVariable("idBarang") String idBarang, @Valid @ModelAttribute UpdateBarangReqDTO barangDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            String errorMessage = "";
            for (ObjectError error : errors) {
                errorMessage += (error.getDefaultMessage()) + ("\n");
            }
            model.addAttribute("errorMessage", errorMessage.toString());
            model.addAttribute("page", "barang");
            List<Barang> listBarang = barangService.getAllBarang();
            model.addAttribute("listBarang", listBarang);
            return "error-view";
        }

        if (barangService.isMerkExist(barangDTO.getMerk(), barangDTO.getSku())) {
            var errorMessage = "Barang dengan merk tersebut sudah pernah ditambahkan.";
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("page", "barang");
            List<Barang> listBarang = barangService.getAllBarang();
            model.addAttribute("listBarang", listBarang);
            return "error-view";
        }
        
        var barangFromDTO = barangMapper.UpdateBarangReqDTOToBarang(barangDTO);

        barangService.updateBarang(barangFromDTO);

        List<Barang> listBarang = barangService.getAllBarang();
        model.addAttribute("listBarang", listBarang);
        model.addAttribute("barangService", barangService);
        model.addAttribute("page", "barang");

        return "viewall-barang";
    }


}
