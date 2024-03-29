package nc.traumateam.api.entities.dto;

import nc.traumateam.api.enums.SpecialtyEnum;

public record ListDoctorDTO(
        String name,
        String email,
        String crm,
        SpecialtyEnum specialty
) {}
