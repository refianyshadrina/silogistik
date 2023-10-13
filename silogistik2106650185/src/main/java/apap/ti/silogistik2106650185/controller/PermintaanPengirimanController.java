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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Date;
import apap.ti.silogistik2106650185.dto.PPMapper;
import apap.ti.silogistik2106650185.dto.request.CreatePPReqDTO;
import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.model.PermintaanPengiriman;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106650185.service.BarangService;
import apap.ti.silogistik2106650185.service.KaryawanService;
import apap.ti.silogistik2106650185.service.PPBarangService;
import apap.ti.silogistik2106650185.service.PermintaanPengirimanService;
import jakarta.validation.Valid;

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
    public String addRow(@Valid @ModelAttribute CreatePPReqDTO ppDTO, BindingResult bindingResult, Model model) {
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
    public String postCreate(@Valid @ModelAttribute CreatePPReqDTO ppDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            List<String> errorMessage = new ArrayList<>();
            for (ObjectError error : errors) {
                errorMessage.add(error.getDefaultMessage());
            }
            model.addAttribute("errorMessage",errorMessage);
            List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
            model.addAttribute("listPP", listPP);
            model.addAttribute("page", "permintaanpengiriman");
            return "error-view";
        }

        if (ppBarangService.cekStok(ppDTO.getListPermintaanPengirimanBarang())) {
            String errorMessage = "Stok barang yang anda masukkan tidak cukup, mohon cek stok di daftar barang";
            model.addAttribute("errorMessage",errorMessage);
            List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
            model.addAttribute("listPP", listPP);
            List<Barang> listBarang = barangService.getAllBarang();
            model.addAttribute("listBarang", listBarang);
            return "error-view";
        }

        var ppFromDto = ppMapper.createPPReqDTOToPermintaanPengiriman(ppDTO);

        Date parsedDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parsedDate = dateFormat.parse(ppDTO.gettanggalKirim());
            ppFromDto.setTanggalPengiriman(parsedDate);
        } catch (ParseException e) {
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
        permintaanPengirimanService.create(ppFromDto, ppDTO.getListPermintaanPengirimanBarang());

        List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
        model.addAttribute("listPP", listPP);
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
                List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
                model.addAttribute("listPP", listPP);
                model.addAttribute("page", "permintaanpengiriman");
                return "success-delete-pp";
            } else {
                model.addAttribute("errorMessage", "Permintaan pengiriman yang sudah lebih dari 24 jam tidak dapat dibatalkan");
                List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
                model.addAttribute("listPP", listPP);
                model.addAttribute("page", "permintaanpengiriman");
                return "error-view"; 
            }
        } else {
            model.addAttribute("errorMessage", "Tidak ditemukan permintaan pengiriman dengan id tersebut");
            List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
            model.addAttribute("listPP", listPP);
            model.addAttribute("page", "permintaanpengiriman");
            return "error-view";
        }
    }

    @GetMapping("/{id}") 
    public String detailPP(@PathVariable("id") Long id, Model model) {
        var permintaan = permintaanPengirimanService.getPPById(id);

        if (permintaan!=null) {
            model.addAttribute("pp", permintaan);

            String jenisLayanan = "";
            switch(permintaan.getJenisLayanan()) {
                case 1:
                    jenisLayanan = "Same day";
                    break;
                case 2:
                    jenisLayanan = "Kilat";
                    break;
                case 3:
                    jenisLayanan = "Reguler";
                    break;
                case 4:
                    jenisLayanan = "Hemat";
                    break;
            }
            model.addAttribute("jenisLayanan", jenisLayanan);
            model.addAttribute("ppService", permintaanPengirimanService);
            model.addAttribute("page", "permintaanpengiriman");
            return "detail-permintaanpengiriman";
        } else {
            model.addAttribute("errorMessage", "Tidak ditemukan permintaan pengiriman dengan id tersebut");
            model.addAttribute("page", "permintaanpengiriman");
            List<PermintaanPengiriman> listPP = permintaanPengirimanService.getAllPermintaanPengiriman();
            model.addAttribute("listPP", listPP);
            return "error-view";
        }
    }
    
}
