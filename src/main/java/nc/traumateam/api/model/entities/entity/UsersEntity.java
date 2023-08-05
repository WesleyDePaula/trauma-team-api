package nc.traumateam.api.model.entities.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "users")
@Entity(name = "UsersEntity")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String login;
    private String password;
}
