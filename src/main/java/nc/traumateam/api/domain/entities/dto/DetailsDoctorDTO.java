package nc.traumateam.api.domain.entities.dto;

import nc.traumateam.api.domain.entities.entity.AddressEntity;
import nc.traumateam.api.domain.enums.SpecialtyEnum;

public record DetailsDoctorDTO (
        String id,
        String name,
        String email,
        String crm,
        String phone,
        SpecialtyEnum specialty,
        AddressEntity address
) {}