package org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias;

import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.ConvocatoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConvocatoriaRepository extends JpaRepository<ConvocatoriasEntity, Integer> {
    List<ConvocatoriasEntity> findAllByIdcon(Integer id);
}
