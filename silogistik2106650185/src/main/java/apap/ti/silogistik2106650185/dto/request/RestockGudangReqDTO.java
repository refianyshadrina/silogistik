package apap.ti.silogistik2106650185.dto.request;

import java.util.List;

// import apap.ti.silogistik2106650185.model.CreateGudangBarangDTO;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestockGudangReqDTO {
    @Size(max = 255)
    private String nama;

    @Size(max = 255)
    private String alamatGudang;

    private List<CreateGudangBarangDTO> listCreateGudangBarangDTO;

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

    public List<CreateGudangBarangDTO> getListCreateGudangBarangDTO() {
        return listCreateGudangBarangDTO;
    }

    public void setListCreateGudangBarangDTO(List<CreateGudangBarangDTO> listCreateGudangBarangDTO) {
        this.listCreateGudangBarangDTO = listCreateGudangBarangDTO;
    }

    public RestockGudangReqDTO() {
    }

    public RestockGudangReqDTO(@Size(max = 255) String nama, @Size(max = 255) String alamatGudang,
            List<CreateGudangBarangDTO> listCreateGudangBarangDTO) {
        this.nama = nama;
        this.alamatGudang = alamatGudang;
        this.listCreateGudangBarangDTO = listCreateGudangBarangDTO;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nama == null) ? 0 : nama.hashCode());
        result = prime * result + ((alamatGudang == null) ? 0 : alamatGudang.hashCode());
        result = prime * result + ((listCreateGudangBarangDTO == null) ? 0 : listCreateGudangBarangDTO.hashCode());
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
        RestockGudangReqDTO other = (RestockGudangReqDTO) obj;
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
        if (listCreateGudangBarangDTO == null) {
            if (other.listCreateGudangBarangDTO != null)
                return false;
        } else if (!listCreateGudangBarangDTO.equals(other.listCreateGudangBarangDTO))
            return false;
        return true;
    }

    
    
}
