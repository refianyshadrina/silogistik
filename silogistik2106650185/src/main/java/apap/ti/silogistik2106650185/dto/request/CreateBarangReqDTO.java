package apap.ti.silogistik2106650185.dto.request;

import java.math.BigDecimal;
import java.util.List;

import apap.ti.silogistik2106650185.model.GudangBarang;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBarangReqDTO {
    // @Size(min=7, max=7)
    // private String sku;

    // @Size(max=5)
    private int tipeBarang;

    @NotBlank(message = "Merk barang harus diisi")
    private String merk;

    @PositiveOrZero(message = "Mohon periksa kembali input harga Anda")
    private BigDecimal hargaBarang;

    private List<GudangBarang> listGudangBarang;
    
    private List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang;

    

    public CreateBarangReqDTO(@Size(max = 5) int tipeBarang, String merk, BigDecimal hargaBarang,
            List<GudangBarang> listGudangBarang, List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang) {

        this.tipeBarang = tipeBarang;
        this.merk = merk;
        this.hargaBarang = hargaBarang;
        this.listGudangBarang = listGudangBarang;
        this.listPermintaanPengirimanBarang = listPermintaanPengirimanBarang;
    }

    public CreateBarangReqDTO() {
    }

    // public String getSku() {
    //     return sku;
    // }

    // public void setSku(String sku) {
    //     this.sku = sku;
    // }

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

    public BigDecimal getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(BigDecimal hargaBarang) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreateBarangReqDTO other = (CreateBarangReqDTO) obj;
        if (tipeBarang != other.tipeBarang)
            return false;
        if (merk == null) {
            if (other.merk != null)
                return false;
        } else if (!merk.equals(other.merk))
            return false;
        if (hargaBarang == null) {
            if (other.hargaBarang != null)
                return false;
        } else if (!hargaBarang.equals(other.hargaBarang))
            return false;
        if (listGudangBarang == null) {
            if (other.listGudangBarang != null)
                return false;
        } else if (!listGudangBarang.equals(other.listGudangBarang))
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
        result = prime * result + tipeBarang;
        result = prime * result + ((merk == null) ? 0 : merk.hashCode());
        result = prime * result + ((hargaBarang == null) ? 0 : hargaBarang.hashCode());
        result = prime * result + ((listGudangBarang == null) ? 0 : listGudangBarang.hashCode());
        result = prime * result
                + ((listPermintaanPengirimanBarang == null) ? 0 : listPermintaanPengirimanBarang.hashCode());
        return result;
    }

  

    

}
