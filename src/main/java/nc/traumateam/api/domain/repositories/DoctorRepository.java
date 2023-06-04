package nc.traumateam.api.domain.repositories;

import nc.traumateam.api.domain.entities.entity.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {
    Page<DoctorEntity> findAllByDeletedFalse(Pageable page);
}
