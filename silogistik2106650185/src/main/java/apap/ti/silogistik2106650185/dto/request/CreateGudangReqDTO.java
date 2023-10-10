package apap.ti.silogistik2106650185.dto.request;

import java.util.List;
import lombok.Data;
import apap.ti.silogistik2106650185.model.GudangBarang;

import jakarta.validation.constraints.Size;

@Data
public class CreateGudangReqDTO {

    // private Long idGudang;

    @Size(max = 255)
    private String nama;

    @Size(max = 255)
    private String alamatGudang;

    public CreateGudangReqDTO() {
    }

    // public Long getIdGudang() {
    //     return idGudang;
    // }

    // public void setIdGudang(Long idGudang) {
    //     this.idGudang = idGudang;
    // }

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

    private List<GudangBarang> listGudangBarang;



    public List<GudangBarang> getListGudangBarang() {
        return listGudangBarang;
    }

    public void setListGudangBarang(List<GudangBarang> listGudangBarang) {
        this.listGudangBarang = listGudangBarang;
    }

    public CreateGudangReqDTO(Long idGudang, @Size(max = 255) String nama, @Size(max = 255) String alamatGudang,
            List<GudangBarang> listGudangBarang) {
        this.nama = nama;
        this.alamatGudang = alamatGudang;
        this.listGudangBarang = listGudangBarang;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreateGudangReqDTO other = (CreateGudangReqDTO) obj;
        if (nama == null) {
            if (other.nama != null)
                return false;
        } else if (!nama.equals(other.nama))
            return false;
        if (alamatGudang == null) {
            if (other.alamatGudang != null)
                return false;
        } else if (!alamatGudang.equals(other.alamatGudang))
            return false;
        if (listGudangBarang == null) {
            if (other.listGudangBarang != null)
                return false;
        } else if (!listGudangBarang.equals(other.listGudangBarang))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nama == null) ? 0 : nama.hashCode());
        result = prime * result + ((alamatGudang == null) ? 0 : alamatGudang.hashCode());
        result = prime * result + ((listGudangBarang == null) ? 0 : listGudangBarang.hashCode());
        return result;
    }


    

    
    

}
