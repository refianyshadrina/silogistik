package apap.ti.silogistik2106650185.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106650185.dto.request.CreateKaryawanReqDTO;
import apap.ti.silogistik2106650185.model.Karyawan;

@Mapper(componentModel = "spring")
public interface KaryawanMapper {
        Karyawan createKaryawanReqDTOToKaryawan(CreateKaryawanReqDTO createKaryawanReqDTO);
}
