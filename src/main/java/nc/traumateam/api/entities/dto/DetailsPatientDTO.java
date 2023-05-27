package nc.traumateam.api.entities.dto;

import nc.traumateam.api.entities.entity.AddressEntity;

public record DetailsPatientDTO(
        String name,
        String email,
        String phone,
        String cpf,
        AddressEntity address
) {}
