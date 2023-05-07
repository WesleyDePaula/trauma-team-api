package nc.traumateam.api.entities.dto;

import jakarta.validation.Valid;

import java.util.UUID;

public record UpdatePatientDTO(
        UUID id,
        String name,
        String phone,
        @Valid AddressDTO address
) {}
