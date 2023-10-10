package apap.ti.silogistik2106650185.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="barang")
public class Barang {
    @Id
    @Size(min=7, max=7)
    private String sku;

    @NotNull
    // @Size(max=5)
    @Column(name="tipe_barang", nullable = false)
    private int tipeBarang;

    @NotNull
    @Column(name="merk", nullable = false)
    private String merk;

    @NotNull
    @Column(name="harga_barang", nullable = false)
    private Long hargaBarang;

    @OneToMany(mappedBy = "barang", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GudangBarang> listGudangBarang;
    
    @OneToMany(mappedBy = "barang", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getTipeBarang() {
        return tipeBarang;
    }

    public void setTipeBarang(int tipeBarang) {
        this.tipeBarang = tipeBarang;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Long getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Long hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public List<GudangBarang> getListGudangBarang() {
        return listGudangBarang;
    }

    public void setListGudangBarang(List<GudangBarang> listGudangBarang) {
        this.listGudangBarang = listGudangBarang;
    }

    public List<PermintaanPengirimanBarang> getListPermintaanPengirimanBarang() {
        return listPermintaanPengirimanBarang;
    }

    public void setListPermintaanPengirimanBarang(List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang) {
        this.listPermintaanPengirimanBarang = listPermintaanPengirimanBarang;
    }

    public Barang() {
    }

    public Barang(String sku, @NotNull @Size(max = 5) int tipeBarang, @NotNull String merk, @NotNull Long hargaBarang,
            List<GudangBarang> listGudangBarang, List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang) {
        this.sku = sku;
        this.tipeBarang = tipeBarang;
        this.merk = merk;
        this.hargaBarang = hargaBarang;
        this.listGudangBarang = listGudangBarang;
        this.listPermintaanPengirimanBarang = listPermintaanPengirimanBarang;
    }

    
}
