package nc.traumateam.api.converter;

import lombok.experimental.UtilityClass;
import nc.traumateam.api.entities.dto.AddressDTO;
import nc.traumateam.api.entities.entity.AddressEntity;

@UtilityClass
public class AddressConverter {

    public static AddressEntity toEntity(AddressDTO dto) {
        return AddressEntity.builder()
                .street(dto.street())
                .neighborhood(dto.neighborhood())
                .cep(dto.cep())
                .city(dto.city())
                .uf(dto.uf())
                .number(dto.number())
                .complement(dto.complement())
                .build();
    }

    public static AddressDTO toDTO(AddressEntity entity) {
        return new AddressDTO(
                entity.getStreet(),
                entity.getNeighborhood(),
                entity.getCep(),
                entity.getCity(),
                entity.getUf(),
                entity.getNumber(),
                entity.getComplement());
    }

    public static AddressEntity updateFields(AddressDTO dto) {
        var entity = new AddressEntity();

        if (dto.street() != null && !dto.street().isBlank()) {
            entity.setStreet(dto.street());
        }

        if (dto.neighborhood() != null && !dto.neighborhood().isBlank()) {
            entity.setNeighborhood(dto.neighborhood());
        }

        if (dto.cep() != null && !dto.cep().isBlank()) {
            entity.setCep(dto.cep());
        }

        if (dto.city() != null && !dto.city().isBlank()) {
            entity.setCity(dto.city());
        }

        if (dto.uf() != null && !dto.uf().isBlank()) {
            entity.setUf(dto.uf());
        }

        if (dto.number() != null && !dto.number().isBlank()) {
            entity.setNumber(dto.number());
        }

        if (dto.complement() != null && !dto.complement().isBlank()) {
            entity.setComplement(dto.complement());
        }

        return entity;
    }
}
