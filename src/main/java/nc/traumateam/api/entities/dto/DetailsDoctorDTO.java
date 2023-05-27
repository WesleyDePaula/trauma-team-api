package nc.traumateam.api.entities.dto;

import nc.traumateam.api.entities.entity.AddressEntity;
import nc.traumateam.api.enums.SpecialtyEnum;

public record DetailsDoctorDTO (
        String id,
        String name,
        String email,
        String crm,
        String phone,
        SpecialtyEnum specialty,
        AddressEntity address
) {}