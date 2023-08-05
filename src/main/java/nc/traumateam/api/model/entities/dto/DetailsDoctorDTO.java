package nc.traumateam.api.model.entities.dto;

import nc.traumateam.api.model.entities.entity.AddressEntity;
import nc.traumateam.api.model.enums.SpecialtyEnum;

public record DetailsDoctorDTO (
        String id,
        String name,
        String email,
        String crm,
        String phone,
        SpecialtyEnum specialty,
        AddressEntity address
) {}