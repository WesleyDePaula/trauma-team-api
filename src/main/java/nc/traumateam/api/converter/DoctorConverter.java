package nc.traumateam.api.converter;

import lombok.experimental.UtilityClass;
import nc.traumateam.api.entities.dto.DoctorDTO;
import nc.traumateam.api.entities.dto.ListDoctorDTO;
import nc.traumateam.api.entities.entity.DoctorEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DoctorConverter {

    public static DoctorEntity toEntity(DoctorDTO dto){
        return DoctorEntity.builder()
                .name(dto.name())
                .email(dto.email())
                .phone(dto.phone())
                .crm(dto.crm())
                .specialty(dto.specialty())
                .address(AddressConverter.toEntity(dto.address()))
                .build();
    }

    public static DoctorDTO toDTO(DoctorEntity entity) {
        return new DoctorDTO(
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCrm(),
                entity.getSpecialty(),
                AddressConverter.toDTO(entity.getAddress()));
    }

    public static List<DoctorDTO> toDTO(List<DoctorEntity> entities) {
        return entities.stream().map(DoctorConverter::toDTO).toList();
    }

    public static ListDoctorDTO toListDTO(DoctorEntity entity){
        return new ListDoctorDTO(
                entity.getName(),
                entity.getEmail(),
                entity.getCrm(),
                entity.getSpecialty());
    }

    public static Page<ListDoctorDTO> toListDto(Page<DoctorEntity> entities) {
        return entities.map(DoctorConverter::toListDTO);
    }

}
