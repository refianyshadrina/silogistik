package apap.ti.silogistik2106650185.dto.request;

import java.util.List;

import apap.ti.silogistik2106650185.model.GudangBarang;
import apap.ti.silogistik2106650185.model.PermintaanPengirimanBarang;
import jakarta.validation.constraints.Size;

public class UpdateBarangReqDTO extends CreateBarangReqDTO{
    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    

    public UpdateBarangReqDTO(@Size(max = 5) int tipeBarang, String merk, Long hargaBarang,
            List<GudangBarang> listGudangBarang, List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang,
            String sku) {
        super(tipeBarang, merk, hargaBarang, listGudangBarang, listPermintaanPengirimanBarang);
        this.sku = sku;
    }

    public UpdateBarangReqDTO(String sku) {
        this.sku = sku;
    }

    public UpdateBarangReqDTO() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UpdateBarangReqDTO other = (UpdateBarangReqDTO) obj;
        if (sku == null) {
            if (other.sku != null)
                return false;
        } else if (!sku.equals(other.sku))
            return false;
        return true;
    }

    
}
