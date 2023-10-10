package apap.ti.silogistik2106650185.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="gudang")
public class Gudang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGudang;

    @NotNull
    @Size(max = 255)
    @Column(name="nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name="alamat_gudang", nullable = false)
    private String alamatGudang;

    @OneToMany(mappedBy = "gudang", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GudangBarang> listGudangBarang;

    public Gudang(Long idGudang, @NotNull @Size(max = 255) String nama, @NotNull @Size(max = 255) String alamatGudang,
            List<GudangBarang> listGudangBarang) {
        this.idGudang = idGudang;
        this.nama = nama;
        this.alamatGudang = alamatGudang;
        this.listGudangBarang = listGudangBarang;
    }

    public Gudang() {
    }

    public Long getIdGudang() {
        return idGudang;
    }

    public void setIdGudang(Long idGudang) {
        this.idGudang = idGudang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamatGudang() {
        return alamatGudang;
    }

    public void setAlamatGudang(String alamatGudang) {
        this.alamatGudang = alamatGudang;
    }

    public List<GudangBarang> getListGudangBarang() {
        return listGudangBarang;
    }

    public void setListGudangBarang(List<GudangBarang> listGudangBarang) {
        this.listGudangBarang = listGudangBarang;
    }

    

}
