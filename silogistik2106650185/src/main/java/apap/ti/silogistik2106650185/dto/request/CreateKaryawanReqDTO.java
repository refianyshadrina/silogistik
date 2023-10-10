package apap.ti.silogistik2106650185.dto.request;

import java.util.Date;
import java.util.List;

import apap.ti.silogistik2106650185.model.PermintaanPengiriman;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateKaryawanReqDTO {
    private Long idKaryawan;
    
    private String nama;

    @Size(max=2)
    private int jenisKelamin;

    private Date tanggalLahir;

    private List<PermintaanPengiriman> listPermintaanPengiriman;


    public CreateKaryawanReqDTO(Long idKaryawan, String nama, @Size(max = 2) int jenisKelamin, Date tanggalLahir, List<PermintaanPengiriman> listPermintaanPengiriman) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.listPermintaanPengiriman = listPermintaanPengiriman;
    }

    public CreateKaryawanReqDTO() {
    }

    public Long getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(Long idKaryawan) {
        this.idKaryawan = idKaryawan;
    }



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(int jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }





    public List<PermintaanPengiriman> getListPermintaanPengiriman() {
        return listPermintaanPengiriman;
    }

    public void setListPermintaanPengiriman(List<PermintaanPengiriman> listPermintaanPengiriman) {
        this.listPermintaanPengiriman = listPermintaanPengiriman;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreateKaryawanReqDTO other = (CreateKaryawanReqDTO) obj;
        if (idKaryawan == null) {
            if (other.idKaryawan != null)
                return false;
        } else if (!idKaryawan.equals(other.idKaryawan))
            return false;
        if (nama == null) {
            if (other.nama != null)
                return false;
        } else if (!nama.equals(other.nama))
            return false;
        if (jenisKelamin != other.jenisKelamin)
            return false;
        if (tanggalLahir == null) {
            if (other.tanggalLahir != null)
                return false;
        } else if (!tanggalLahir.equals(other.tanggalLahir))
            return false;
        if (listPermintaanPengiriman == null) {
            if (other.listPermintaanPengiriman != null)
                return false;
        } else if (!listPermintaanPengiriman.equals(other.listPermintaanPengiriman))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idKaryawan == null) ? 0 : idKaryawan.hashCode());
        result = prime * result + ((nama == null) ? 0 : nama.hashCode());
        result = prime * result + jenisKelamin;
        result = prime * result + ((tanggalLahir == null) ? 0 : tanggalLahir.hashCode());
        result = prime * result + ((listPermintaanPengiriman == null) ? 0 : listPermintaanPengiriman.hashCode());
        return result;
    }

    

    
}
