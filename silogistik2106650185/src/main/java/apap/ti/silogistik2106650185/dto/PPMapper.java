package apap.ti.silogistik2106650185.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106650185.dto.request.CreatePPReqDTO;
import apap.ti.silogistik2106650185.model.PermintaanPengiriman;

@Mapper(componentModel = "spring")
public interface PPMapper {
    PermintaanPengiriman createPPReqDTOToPermintaanPengiriman(CreatePPReqDTO createPPReqDTO);
}
