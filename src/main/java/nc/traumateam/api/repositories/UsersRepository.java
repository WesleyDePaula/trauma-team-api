package nc.traumateam.api.repositories;

import nc.traumateam.api.model.entities.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, UUID> {
    UserDetails findByLogin(String login);
}
