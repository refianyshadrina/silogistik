package apap.ti.silogistik2106650185.dto;
import org.mapstruct.Mapper;
import apap.ti.silogistik2106650185.dto.request.CreateGudangReqDTO;
import apap.ti.silogistik2106650185.dto.request.RestockGudangReqDTO;
import apap.ti.silogistik2106650185.model.Gudang;

@Mapper(componentModel = "spring")
public interface GudangMapper {
    Gudang createGudangReqDTOToGudang(CreateGudangReqDTO createGudangReqDTO);

    // gudangToReadGudangResponseDTO
    RestockGudangReqDTO gudangToRestockGudangReqDTO(Gudang gudang);

    Gudang restockGudangReqDTOToGudang(RestockGudangReqDTO restockGudangReqDTO);
}
