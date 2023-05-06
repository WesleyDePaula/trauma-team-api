package nc.traumateam.api.converter;

import lombok.experimental.UtilityClass;
import nc.traumateam.api.entities.dto.ListPatientDTO;
import nc.traumateam.api.entities.dto.PatientDTO;
import nc.traumateam.api.entities.entity.PatientEntity;
import org.springframework.data.domain.Page;

@UtilityClass
public class PatientConverter {

    public PatientEntity toEntity(PatientDTO dto) {
        return PatientEntity.builder()
                .name(dto.name())
                .email(dto.email())
                .phone(dto.phone())
                .cpf(dto.cpf())
                .address(AddressConverter.toEntity(dto.address()))
                .build();
    }

    public static ListPatientDTO toListDTO(PatientEntity entity) {
        return new ListPatientDTO(
                entity.getName(),
                entity.getEmail(),
                entity.getCpf());
    }

    public static Page<ListPatientDTO> toListDTO(Page<PatientEntity> entities) {
        return entities.map(PatientConverter::toListDTO);
    }
}
