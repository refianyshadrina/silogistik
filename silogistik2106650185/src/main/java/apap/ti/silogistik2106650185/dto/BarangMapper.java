package apap.ti.silogistik2106650185.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106650185.dto.request.CreateBarangReqDTO;
import apap.ti.silogistik2106650185.dto.request.UpdateBarangReqDTO;
import apap.ti.silogistik2106650185.model.Barang;

@Mapper(componentModel = "spring")
public interface BarangMapper {

    Barang createBarangReqDTOToBarang(CreateBarangReqDTO createBarangReqDTO);

    UpdateBarangReqDTO barangToUpdateBarangReqDTO(Barang barang);

    Barang UpdateBarangReqDTOToBarang(UpdateBarangReqDTO updateBarangReqDTO);
    
}
