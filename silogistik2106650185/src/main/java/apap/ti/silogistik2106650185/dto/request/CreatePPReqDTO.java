package apap.ti.silogistik2106650185.dto.request;

import java.time.LocalDateTime;

import java.util.List;

import apap.ti.silogistik2106650185.model.Karyawan;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import lombok.Data;

@Data
public class CreatePPReqDTO {

    private String nomorPengiriman;

    private boolean isCancelled;

    private String namaPenerima;

    private String alamatPenerima;

    private String tanggalKirim;

    private int biayaPengiriman;

    private int jenisLayanan;

    private LocalDateTime waktuPermintaan;

    private Karyawan karyawan;

    private List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang;

    public String getNomorPengiriman() {
        return nomorPengiriman;
    }

    public void setNomorPengiriman(String nomorPengiriman) {
        this.nomorPengiriman = nomorPengiriman;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public String gettanggalKirim() {
        return tanggalKirim;
    }

    public void settanggalKirim(String tanggalKirim) {
        this.tanggalKirim = tanggalKirim;
    }

    public int getBiayaPengiriman() {
        return biayaPengiriman;
    }

    public void setBiayaPengiriman(int biayaPengiriman) {
        this.biayaPengiriman = biayaPengiriman;
    }

    public int getJenisLayanan() {
        return jenisLayanan;
    }

    public void setJenisLayanan(int jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public LocalDateTime getWaktuPermintaan() {
        return waktuPermintaan;
    }

    public void setWaktuPermintaan(LocalDateTime waktuPermintaan) {
        this.waktuPermintaan = waktuPermintaan;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public List<PermintaanPengirimanBarang> getListPermintaanPengirimanBarang() {
        return listPermintaanPengirimanBarang;
    }

    public void setListPermintaanPengirimanBarang(List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang) {
        this.listPermintaanPengirimanBarang = listPermintaanPengirimanBarang;
    }

    public CreatePPReqDTO(String nomorPengiriman, boolean isCancelled, String namaPenerima, String alamatPenerima,
            String tanggalKirim, int biayaPengiriman, int jenisLayanan, LocalDateTime waktuPermintaan,
            Karyawan karyawan, List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang) {
        this.nomorPengiriman = nomorPengiriman;
        this.isCancelled = isCancelled;
        this.namaPenerima = namaPenerima;
        this.alamatPenerima = alamatPenerima;
        this.tanggalKirim = tanggalKirim;
        this.biayaPengiriman = biayaPengiriman;
        this.jenisLayanan = jenisLayanan;
        this.waktuPermintaan = waktuPermintaan;
        this.karyawan = karyawan;
        this.listPermintaanPengirimanBarang = listPermintaanPengirimanBarang;
    }

    public CreatePPReqDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreatePPReqDTO other = (CreatePPReqDTO) obj;
        if (nomorPengiriman == null) {
            if (other.nomorPengiriman != null)
                return false;
        } else if (!nomorPengiriman.equals(other.nomorPengiriman))
            return false;
        if (isCancelled != other.isCancelled)
            return false;
        if (namaPenerima == null) {
            if (other.namaPenerima != null)
                return false;
        } else if (!namaPenerima.equals(other.namaPenerima))
            return false;
        if (alamatPenerima == null) {
            if (other.alamatPenerima != null)
                return false;
        } else if (!alamatPenerima.equals(other.alamatPenerima))
            return false;
        if (biayaPengiriman != other.biayaPengiriman)
            return false;
        if (jenisLayanan != other.jenisLayanan)
            return false;
        if (waktuPermintaan == null) {
            if (other.waktuPermintaan != null)
                return false;
        } else if (!waktuPermintaan.equals(other.waktuPermintaan))
            return false;
        if (karyawan == null) {
            if (other.karyawan != null)
                return false;
        } else if (!karyawan.equals(other.karyawan))
            return false;
        if (listPermintaanPengirimanBarang == null) {
            if (other.listPermintaanPengirimanBarang != null)
                return false;
        } else if (!listPermintaanPengirimanBarang.equals(other.listPermintaanPengirimanBarang))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomorPengiriman == null) ? 0 : nomorPengiriman.hashCode());
        result = prime * result + (isCancelled ? 1231 : 1237);
        result = prime * result + ((namaPenerima == null) ? 0 : namaPenerima.hashCode());
        result = prime * result + ((alamatPenerima == null) ? 0 : alamatPenerima.hashCode());
        result = prime * result + biayaPengiriman;
        result = prime * result + jenisLayanan;
        result = prime * result + ((waktuPermintaan == null) ? 0 : waktuPermintaan.hashCode());
        result = prime * result + ((karyawan == null) ? 0 : karyawan.hashCode());
        result = prime * result
                + ((listPermintaanPengirimanBarang == null) ? 0 : listPermintaanPengirimanBarang.hashCode());
        return result;
    }



    
}
