package apap.ti.silogistik2106650185.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="karyawan")
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKaryawan;
    
    @NotNull
    @Column(name="nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name="jenis_kelamin", nullable = false)
    private int jenisKelamin;

    @NotNull
    @Column(name="tanggal_lahir", nullable = false)
    private Date tanggalLahir;

    @OneToMany(mappedBy = "karyawan", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PermintaanPengiriman> listPermintaanPengiriman;

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

    public Karyawan(Long idKaryawan, @NotNull String nama, @NotNull @Size(max = 2) int jenisKelamin,
            @NotNull Date tanggalLahir, List<PermintaanPengiriman> listPermintaanPengiriman) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.listPermintaanPengiriman = listPermintaanPengiriman;
    }

    public Karyawan() {
    }

    
}
