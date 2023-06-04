package nc.traumateam.api.domain.entities.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import nc.traumateam.api.domain.enums.SpecialtyEnum;

public record SaveDoctorDTO(

        @NotBlank
        String name,

        @NotBlank @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        SpecialtyEnum specialty,

        @NotNull @Valid
        AddressDTO address
) {}
