package nc.traumateam.api.model.entities.dto;

public record ListPatientDTO(
        String id,
        String name,
        String email,
        String cpf
) {}
