package nc.traumateam.api.domain.entities.dto;

import nc.traumateam.api.domain.enums.SpecialtyEnum;

public record ListDoctorDTO(
        String id,
        String name,
        String email,
        String crm,
        SpecialtyEnum specialty
) {}
