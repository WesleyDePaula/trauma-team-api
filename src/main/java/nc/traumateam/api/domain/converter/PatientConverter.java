package nc.traumateam.api.domain.converter;

import lombok.experimental.UtilityClass;
import nc.traumateam.api.domain.entities.dto.PatientDTO;
import nc.traumateam.api.domain.entities.entity.PatientEntity;
import nc.traumateam.api.domain.entities.dto.*;
import org.springframework.data.domain.Page;

@UtilityClass
public class PatientConverter {

    public PatientEntity toEntity(PatientDTO dto) {
        return PatientEntity.builder()
                .name(dto.name())
                .email(dto.email())
                .phone(dto.phone())
                .cpf(dto.cpf())
                .deleted(false)
                .address(AddressConverter.toEntity(dto.address()))
                .build();
    }

    public static ListPatientDTO toListDTO(PatientEntity entity) {
        return new ListPatientDTO(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail(),
                entity.getCpf());
    }

    public static Page<ListPatientDTO> toListDTO(Page<PatientEntity> entities) {
        return entities.map(PatientConverter::toListDTO);
    }

    public static void updateFields(PatientEntity patient, UpdatePatientDTO dto) {
        if (dto.name() != null && !dto.name().isBlank()) {
            patient.setName(dto.name());
        }

        if (dto.phone() != null && !dto.phone().isBlank()) {
            patient.setPhone(dto.phone());
        }

        if (dto.address() != null) {
            patient.setAddress(AddressConverter.updateFields(dto.address()));
        }

    }

    public static DetailsPatientDTO toDetailsPatientDTO(PatientEntity entity) {
        return new DetailsPatientDTO(
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCpf(),
                entity.getAddress()
        );
    }
}
