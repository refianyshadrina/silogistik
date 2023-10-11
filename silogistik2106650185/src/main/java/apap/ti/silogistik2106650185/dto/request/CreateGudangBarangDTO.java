package apap.ti.silogistik2106650185.dto.request;


import apap.ti.silogistik2106650185.model.Barang;
import apap.ti.silogistik2106650185.model.Gudang;
import lombok.Data;

@Data
public class CreateGudangBarangDTO {
    // private Long idGudangBarang;

    private Barang barang;

    private Gudang gudang;

    private int stok;

    public CreateGudangBarangDTO() {
    }

    public CreateGudangBarangDTO(Barang barang, Gudang gudang, int stok) {
        this.barang = barang;
        this.gudang = gudang;
        this.stok = stok;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreateGudangBarangDTO other = (CreateGudangBarangDTO) obj;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((barang == null) ? 0 : barang.hashCode());
        result = prime * result + ((gudang == null) ? 0 : gudang.hashCode());
        result = prime * result + stok;
        return result;
    }

    
}
