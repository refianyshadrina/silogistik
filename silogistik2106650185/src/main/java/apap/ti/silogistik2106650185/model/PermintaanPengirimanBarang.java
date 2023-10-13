package apap.ti.silogistik2106650185.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="permintaan_pengiriman_barang")
public class PermintaanPengirimanBarang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerintaanPengirimanBarang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sku_barang", referencedColumnName="sku")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Barang barang;

    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="id_permintaan_pengiriman", referencedColumnName="idPermintaanPengiriman")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PermintaanPengiriman permintaanPengiriman;

    @NotNull
    @Column(name="kuantitas_pengiriman", nullable = false)
    private int kuantitasPengiriman;

    public Long getIdPerintaanPengirimanBarang() {
        return idPerintaanPengirimanBarang;
    }

    public void setIdPerintaanPengirimanBarang(Long idPerintaanPengirimanBarang) {
        this.idPerintaanPengirimanBarang = idPerintaanPengirimanBarang;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public PermintaanPengiriman getPermintaanPengiriman() {
        return permintaanPengiriman;
    }

    public void setPermintaanPengiriman(PermintaanPengiriman permintaanPengiriman) {
        this.permintaanPengiriman = permintaanPengiriman;
    }

    public int getKuantitasPengiriman() {
        return kuantitasPengiriman;
    }

    public void setKuantitasPengiriman(int kuantitasPengiriman) {
        this.kuantitasPengiriman = kuantitasPengiriman;
    }

    public PermintaanPengirimanBarang(Long idPerintaanPengirimanBarang, Barang barang,
            PermintaanPengiriman permintaanPengiriman, @NotNull int kuantitasPengiriman) {
        this.idPerintaanPengirimanBarang = idPerintaanPengirimanBarang;
        this.barang = barang;
        this.permintaanPengiriman = permintaanPengiriman;
        this.kuantitasPengiriman = kuantitasPengiriman;
    }

    public PermintaanPengirimanBarang() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPerintaanPengirimanBarang == null) ? 0 : idPerintaanPengirimanBarang.hashCode());
        result = prime * result + ((barang == null) ? 0 : barang.hashCode());
        result = prime * result + ((permintaanPengiriman == null) ? 0 : permintaanPengiriman.hashCode());
        result = prime * result + kuantitasPengiriman;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PermintaanPengirimanBarang other = (PermintaanPengirimanBarang) obj;
        if (idPerintaanPengirimanBarang == null) {
            if (other.idPerintaanPengirimanBarang != null)
                return false;
        } else if (!idPerintaanPengirimanBarang.equals(other.idPerintaanPengirimanBarang))
            return false;
        if (barang == null) {
            if (other.barang != null)
                return false;
        } else if (!barang.equals(other.barang))
            return false;
        if (permintaanPengiriman == null) {
            if (other.permintaanPengiriman != null)
                return false;
        } else if (!permintaanPengiriman.equals(other.permintaanPengiriman))
            return false;
        if (kuantitasPengiriman != other.kuantitasPengiriman)
            return false;
        return true;
    }

    
}
