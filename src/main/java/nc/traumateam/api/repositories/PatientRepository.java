package nc.traumateam.api.repositories;

import nc.traumateam.api.entities.entity.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {
    Page<PatientEntity> findAllByDeletedFalse(Pageable page);
}
