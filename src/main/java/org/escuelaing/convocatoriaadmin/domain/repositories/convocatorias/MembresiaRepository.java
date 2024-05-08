package org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias;

import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.MembresiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembresiaRepository extends JpaRepository<MembresiaEntity, String> {
    List<MembresiaEntity> findAllByIdemp(String id);
}
