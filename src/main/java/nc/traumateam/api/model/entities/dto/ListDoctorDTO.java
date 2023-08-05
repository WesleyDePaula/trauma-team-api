package nc.traumateam.api.model.entities.dto;

import nc.traumateam.api.model.enums.SpecialtyEnum;

public record ListDoctorDTO(
        String id,
        String name,
        String email,
        String crm,
        SpecialtyEnum specialty
) {}
