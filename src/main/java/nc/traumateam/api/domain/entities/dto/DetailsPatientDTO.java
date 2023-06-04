package nc.traumateam.api.domain.entities.dto;

import nc.traumateam.api.domain.entities.entity.AddressEntity;

public record DetailsPatientDTO(
        String name,
        String email,
        String phone,
        String cpf,
        AddressEntity address
) {}
