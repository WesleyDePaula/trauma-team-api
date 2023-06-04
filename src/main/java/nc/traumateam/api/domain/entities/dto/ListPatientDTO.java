package nc.traumateam.api.domain.entities.dto;

public record ListPatientDTO(
        String id,
        String name,
        String email,
        String cpf
) {}
