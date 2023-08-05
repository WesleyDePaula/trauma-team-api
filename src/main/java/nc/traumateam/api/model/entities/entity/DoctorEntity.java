package nc.traumateam.api.model.entities.entity;

import jakarta.persistence.*;
import lombok.*;
import nc.traumateam.api.model.enums.SpecialtyEnum;

import java.util.UUID;

@Table(name = "doctor")
@Entity(name = "DoctorEntity")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private SpecialtyEnum specialty;
    @Embedded
    private AddressEntity address;
    private Boolean deleted;

}
