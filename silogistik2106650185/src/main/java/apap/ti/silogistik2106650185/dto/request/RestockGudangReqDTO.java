package apap.ti.silogistik2106650185.dto.request;

import java.util.List;

import apap.ti.silogistik2106650185.model.GudangBarang;
// import apap.ti.silogistik2106650185.model.CreateGudangBarangDTO;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestockGudangReqDTO extends CreateGudangReqDTO {
    
    private Long idGudang;

    private List<CreateGudangBarangDTO> listCreateGudangBarangDTO;

    public Long getIdGudang() {
        return idGudang;
    }

    public void setIdGudang(Long idGudang) {
        this.idGudang = idGudang;
    }

    public List<CreateGudangBarangDTO> getListCreateGudangBarangDTO() {
        return listCreateGudangBarangDTO;
    }

    public void setListCreateGudangBarangDTO(List<CreateGudangBarangDTO> listCreateGudangBarangDTO) {
        this.listCreateGudangBarangDTO = listCreateGudangBarangDTO;
    }

    public RestockGudangReqDTO() {
    }

    public RestockGudangReqDTO(Long idGudang, @Size(max = 255) String nama, @Size(max = 255) String alamatGudang,
            List<GudangBarang> listGudangBarang, Long idGudang2,
            List<CreateGudangBarangDTO> listCreateGudangBarangDTO) {
        super(idGudang, nama, alamatGudang, listGudangBarang);
        idGudang = idGudang2;
        this.listCreateGudangBarangDTO = listCreateGudangBarangDTO;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((idGudang == null) ? 0 : idGudang.hashCode());
        result = prime * result + ((listCreateGudangBarangDTO == null) ? 0 : listCreateGudangBarangDTO.hashCode());
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
        RestockGudangReqDTO other = (RestockGudangReqDTO) obj;
        if (idGudang == null) {
            if (other.idGudang != null)
                return false;
        } else if (!idGudang.equals(other.idGudang))
            return false;
        if (listCreateGudangBarangDTO == null) {
            if (other.listCreateGudangBarangDTO != null)
                return false;
        } else if (!listCreateGudangBarangDTO.equals(other.listCreateGudangBarangDTO))
            return false;
        return true;
    }

    
}
