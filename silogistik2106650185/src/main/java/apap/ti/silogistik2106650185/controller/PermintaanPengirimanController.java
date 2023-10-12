package apap.ti.silogistik2106650185.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
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
import org.springframework.validation.ObjectError;
import java.util.Date;
import apap.ti.silogistik2106650185.dto.PPMapper;
import apap.ti.silogistik2106650185.dto.request.CreatePPReqDTO;
import apap.ti.silogistik2106650185.model.PermintaanPengiriman;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106650185.service.BarangService;
import apap.ti.silogistik2106650185.service.KaryawanService;
import apap.ti.silogistik2106650185.service.PPBarangService;
import apap.ti.silogistik2106650185.service.PermintaanPengirimanService;

@Controller
@RequestMapping("/permintaan-pengiriman")
public class PermintaanPengirimanController {
    @Autowired
    private PermintaanPengirimanService permintaanPengirimanService;

    @Autowired
    private BarangService barangService;

    @Autowired
    private PPMapper ppMapper;

    @Autowired
    private PPBarangService ppBarangService;

    @Autowired
    private KaryawanService karyawanService;
    

    @GetMapping("")
    public String viewAllPermintaanPengiriman(Model model) {
        List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
        model.addAttribute("listPP", listPP);
        model.addAttribute("page", "permintaanpengiriman");
        return "viewall-permintaanpengiriman";
    }

    @GetMapping("/tambah")
    public String formAddPP(Model model) {
        var ppDTO = new CreatePPReqDTO();

        model.addAttribute("ppDTO", ppDTO);

        var listBarangExisting = barangService.getAllBarang();

        List<PermintaanPengirimanBarang> listPPBarang = new ArrayList<>();

        var ppBarang = new PermintaanPengirimanBarang();
        ppBarang.setKuantitasPengiriman(1);

        ppDTO.setListPermintaanPengirimanBarang(listPPBarang);
        ppDTO.getListPermintaanPengirimanBarang().add(ppBarang);

        model.addAttribute("ppDTO", ppDTO);
        model.addAttribute("listBarang", listBarangExisting);
        model.addAttribute("listKaryawan", karyawanService.getAllKaryawan());
        model.addAttribute("page", "permintaanpengiriman");
        return "form-add-permintaanpengiriman";
    }

    @PostMapping(value = "/tambah", params = {"addRow"})
    public String addRow(@ModelAttribute CreatePPReqDTO ppDTO, Model model) {
        if (ppDTO.getListPermintaanPengirimanBarang() == null || ppDTO.getListPermintaanPengirimanBarang().size() == 0) {
            ppDTO.setListPermintaanPengirimanBarang(new ArrayList<>());
        }

        PermintaanPengirimanBarang ppBarang = new PermintaanPengirimanBarang();
        ppBarang.setKuantitasPengiriman(1);
        
        ppDTO.getListPermintaanPengirimanBarang().add(ppBarang);

        model.addAttribute("ppDTO", ppDTO);
        model.addAttribute("listBarang", barangService.getAllBarang());
        model.addAttribute("listKaryawan", karyawanService.getAllKaryawan());
        model.addAttribute("page", "permintaanpengiriman");
        return "form-add-permintaanpengiriman";
        
    }

    @PostMapping(value = "/tambah")
    public String postCreate(@ModelAttribute CreatePPReqDTO ppDTO, Model model) {
        var ppFromDto = ppMapper.createPPReqDTOToPermintaanPengiriman(ppDTO);

        Date parsedDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parsedDate = dateFormat.parse(ppDTO.gettanggalKirim());
            ppFromDto.setTanggalPengiriman(parsedDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ppFromDto.setListPermintaanPengirimanBarang(new ArrayList<>());
        LocalDateTime currentDateTime = LocalDateTime.now();
        ppFromDto.setNomorPengiriman("temp");
        ppFromDto.setWaktuPermintaan(currentDateTime);
        permintaanPengirimanService.save(ppFromDto);
        
        for (PermintaanPengirimanBarang ppBarang : ppDTO.getListPermintaanPengirimanBarang()) {
            ppBarang.setPermintaanPengiriman(permintaanPengirimanService.getPPById(ppFromDto.getIdPermintaanPengiriman()));
            // ppBarang.setPermintaanPengiriman(ppFromDto);
            ppBarangService.save(ppBarang);
        }
        
        ppFromDto.setListPermintaanPengirimanBarang(ppDTO.getListPermintaanPengirimanBarang());

        permintaanPengirimanService.generateNomor(ppFromDto);
        permintaanPengirimanService.save(ppFromDto);

        //         if (bindingResult.hasErrors()) {
        //     List<ObjectError> errors = bindingResult.getAllErrors();
        //     List<String> errorMessage = new ArrayList<>();
        //     for (ObjectError error : errors) {
        //         errorMessage.add(error.getDefaultMessage());
        //     }
        //     model.addAttribute("errorMessage",errorMessage);
        //     return "error-view";
        // }

        // if (bukuService.isJudulExist(bukuDTO.getJudul())) {
        //     var errorMessage = "Maaf, judul buku sudah ada";
        //     model.addAttribute("errorMessage", errorMessage);
        //     return "error-view";
        // }

        List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
        model.addAttribute("listPP", listPP);
        model.addAttribute("page", "permintaan pengiriman");
        model.addAttribute("page", "permintaanpengiriman");
        return "viewall-permintaanpengiriman";

    }

    @GetMapping("/{id}/cancel")
    public String deleteBuku(@PathVariable("id") Long id, Model model) {
        var permintaan = permintaanPengirimanService.getPPById(id);

        if (permintaan != null) {

            LocalDateTime waktuPembuatan = permintaan.getWaktuPermintaan();
            LocalDateTime waktuSekarang = LocalDateTime.now();
            
            Duration selisih = Duration.between(waktuPembuatan, waktuSekarang);
            
            String nomor = permintaan.getNomorPengiriman();
            model.addAttribute("nomor", nomor);
            if (selisih.toHours() <= 24) {
                permintaanPengirimanService.delete(permintaan);
                model.addAttribute("page", "permintaanpengiriman");
                return "success-delete-pp";
            } else {
                
                return "error-view"; 
            }
        } else {
            return "error-view";
        }
    }
    
}
