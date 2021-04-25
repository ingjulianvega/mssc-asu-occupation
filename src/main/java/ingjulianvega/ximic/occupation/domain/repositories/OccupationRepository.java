package ingjulianvega.ximic.occupation.domain.repositories;


import ingjulianvega.ximic.occupation.domain.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface OccupationRepository extends JpaRepository<OccupationEntity, UUID>, JpaSpecificationExecutor<OccupationEntity> {
    List<OccupationEntity> findAllByOrderByName();
}
