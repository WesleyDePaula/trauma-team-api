package nc.traumateam.api.model.converter;

import lombok.experimental.UtilityClass;
import nc.traumateam.api.model.entities.dto.DetailsDoctorDTO;
import nc.traumateam.api.model.entities.dto.SaveDoctorDTO;
import nc.traumateam.api.model.entities.dto.UpdateDoctorDTO;
import nc.traumateam.api.model.entities.entity.DoctorEntity;
import nc.traumateam.api.model.entities.dto.ListDoctorDTO;
import org.springframework.data.domain.Page;

import java.util.List;

@UtilityClass
public class DoctorConverter {

    public static DoctorEntity toEntity(SaveDoctorDTO dto){
        return DoctorEntity.builder()
                .name(dto.name())
                .email(dto.email())
                .phone(dto.phone())
                .crm(dto.crm())
                .specialty(dto.specialty())
                .address(AddressConverter.toEntity(dto.address()))
                .deleted(false)
                .build();
    }

    public static SaveDoctorDTO toDTO(DoctorEntity entity) {
        return new SaveDoctorDTO(
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCrm(),
                entity.getSpecialty(),
                AddressConverter.toDTO(entity.getAddress()));
    }

    public static List<SaveDoctorDTO> toDTO(List<DoctorEntity> entities) {
        return entities.stream().map(DoctorConverter::toDTO).toList();
    }

    public static ListDoctorDTO toListDTO(DoctorEntity entity){
        return new ListDoctorDTO(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail(),
                entity.getCrm(),
                entity.getSpecialty());
    }

    public static Page<ListDoctorDTO> toListDto(Page<DoctorEntity> entities) {
        return entities.map(DoctorConverter::toListDTO);
    }



    public static DoctorEntity updateFields(DoctorEntity entity, UpdateDoctorDTO dto) {
        if (dto.name() != null && !dto.name().isBlank()) {
            entity.setName(dto.name());
        }

        if (dto.phone() != null && !dto.phone().isBlank()) {
            entity.setPhone(dto.phone());
        }

        if (dto.address() != null) {
            entity.setAddress(AddressConverter.updateFields(dto.address()));
        }
        return entity;
    }

    public static DetailsDoctorDTO toDetailsDoctorDTO(DoctorEntity entity) {
        return new DetailsDoctorDTO(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail(),
                entity.getCrm(),
                entity.getPhone(),
                entity.getSpecialty(),
                entity.getAddress()
        );
    }
}
