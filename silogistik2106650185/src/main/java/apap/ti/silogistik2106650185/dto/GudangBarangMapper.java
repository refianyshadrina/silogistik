package apap.ti.silogistik2106650185.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106650185.dto.request.CreateGudangBarangDTO;
import apap.ti.silogistik2106650185.model.GudangBarang;

@Mapper(componentModel = "spring")
public interface GudangBarangMapper {
    GudangBarang createGudangBarangDTOToGudangBarang(CreateGudangBarangDTO createGudangBarangDTO);
}
