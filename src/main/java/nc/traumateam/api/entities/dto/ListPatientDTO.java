package nc.traumateam.api.entities.dto;

public record ListPatientDTO(
        String id,
        String name,
        String email,
        String cpf
) {}
