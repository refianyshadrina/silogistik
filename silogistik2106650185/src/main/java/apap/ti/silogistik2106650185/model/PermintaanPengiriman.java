package apap.ti.silogistik2106650185.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="permintaan_pengiriman")
@SQLDelete(sql = "UPDATE permintaan_pengiriman SET is_cancelled = true WHERE id_permintaan_pengiriman=?")
@Where(clause = "is_cancelled=false")
public class PermintaanPengiriman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermintaanPengiriman;

    @NotNull
    @Column(name="nomor_pengiriman", nullable = false)
    private String nomorPengiriman;

    @NotNull
    @Column(name="is_cancelled", nullable = false)
    private boolean isCancelled;

    @NotNull
    @Column(name="nama_pnerima", nullable = false)
    private String namaPenerima;

    @NotNull
    @Column(name="alamat_penerima", nullable = false)
    private String alamatPenerima;

    @NotNull
    @Column(name="tanggal_pengiriman", nullable = false)
    private Date tanggalPengiriman;

    @NotNull
    @Column(name="biaya_pengiriman", nullable = false)
    private int biayaPengiriman;

    @NotNull
    @Column(name="jenis_layanan", nullable = false)
    private int jenisLayanan;

    @NotNull
    @Column(name="waktu_permintaan", nullable = false)
    @DateTimeFormat(pattern = "dd-mm-yyy, hh:mm")
    private LocalDateTime waktuPermintaan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="id_karyawan", referencedColumnName = "idKaryawan")
    private Karyawan karyawan;

    @OneToMany(mappedBy = "permintaanPengiriman", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang;

    public PermintaanPengiriman(Long idPermintaanPengiriman, @NotNull @Size(max = 16, min = 16) String nomorPengiriman,
            @NotNull boolean isCancelled, @NotNull String namaPenerima, @NotNull String alamatPenerima,
            @NotNull Date tanggalPengiriman, @NotNull int biayaPengiriman, @NotNull @Size(max = 4) int jenisLayanan,
            @NotNull LocalDateTime waktuPermintaan, Karyawan karyawan,
            List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang) {
        this.idPermintaanPengiriman = idPermintaanPengiriman;
        this.nomorPengiriman = nomorPengiriman;
        this.isCancelled = isCancelled;
        this.namaPenerima = namaPenerima;
        this.alamatPenerima = alamatPenerima;
        this.tanggalPengiriman = tanggalPengiriman;
        this.biayaPengiriman = biayaPengiriman;
        this.jenisLayanan = jenisLayanan;
        this.waktuPermintaan = waktuPermintaan;
        this.karyawan = karyawan;
        this.listPermintaanPengirimanBarang = listPermintaanPengirimanBarang;
    }

    public PermintaanPengiriman() {
    }

    public Long getIdPermintaanPengiriman() {
        return idPermintaanPengiriman;
    }

    public void setIdPermintaanPengiriman(Long idPermintaanPengiriman) {
        this.idPermintaanPengiriman = idPermintaanPengiriman;
    }

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

    public Date getTanggalPengiriman() {
        return tanggalPengiriman;
    }

    public void setTanggalPengiriman(Date tanggalPengiriman) {
        this.tanggalPengiriman = tanggalPengiriman;
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

    
}
