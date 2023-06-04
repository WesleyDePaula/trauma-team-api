package nc.traumateam.api.domain.entities.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateDoctorDTO(
        @NotNull
        UUID id,
        String name,
        String phone,
        AddressDTO address
) {}
