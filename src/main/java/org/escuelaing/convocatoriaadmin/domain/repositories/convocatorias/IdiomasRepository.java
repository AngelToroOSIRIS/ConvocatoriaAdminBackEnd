package org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias;

import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.IdiomasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdiomasRepository extends JpaRepository<IdiomasEntity, String> {
    List<IdiomasEntity> findAllByIdemp(String id);
}
