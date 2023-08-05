package nc.traumateam.api.model.entities.dto;

import nc.traumateam.api.model.entities.entity.AddressEntity;

public record DetailsPatientDTO(
        String name,
        String email,
        String phone,
        String cpf,
        AddressEntity address
) {}
