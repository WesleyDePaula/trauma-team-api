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
}
