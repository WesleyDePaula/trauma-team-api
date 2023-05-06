package nc.traumateam.api.entities.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "patient")
@Entity(name = "PatientEntity")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;
    private String cpf;
    private String phone;

    @Embedded
    private AddressEntity address;

}
