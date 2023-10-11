package apap.ti.silogistik2106650185.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="gudang_barang")
public class GudangBarang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGudangBarang;

    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="sku_barang", referencedColumnName="sku")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Barang barang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_gudang", referencedColumnName="idGudang")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gudang gudang;

    @NotNull
    @Column(name="stok", nullable = false)
    private int stok;

    public Long getIdGudangBarang() {
        return idGudangBarang;
    }

    public void setIdGudangBarang(Long idGudangBarang) {
        this.idGudangBarang = idGudangBarang;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Gudang getGudang() {
        return gudang;
    }

    public void setGudang(Gudang gudang) {
        this.gudang = gudang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idGudangBarang == null) ? 0 : idGudangBarang.hashCode());
        result = prime * result + ((barang == null) ? 0 : barang.hashCode());
        result = prime * result + ((gudang == null) ? 0 : gudang.hashCode());
        result = prime * result + stok;
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
        GudangBarang other = (GudangBarang) obj;
        if (idGudangBarang == null) {
            if (other.idGudangBarang != null)
                return false;
        } else if (!idGudangBarang.equals(other.idGudangBarang))
            return false;
        if (barang == null) {
            if (other.barang != null)
                return false;
        } else if (!barang.equals(other.barang))
            return false;
        if (gudang == null) {
            if (other.gudang != null)
                return false;
        } else if (!gudang.equals(other.gudang))
            return false;
        if (stok != other.stok)
            return false;
        return true;
    }

    public GudangBarang(Long idGudangBarang, Barang barang, Gudang gudang, @NotNull int stok) {
        this.idGudangBarang = idGudangBarang;
        this.barang = barang;
        this.gudang = gudang;
        this.stok = stok;
    }

    public GudangBarang() {
    }

    


}
