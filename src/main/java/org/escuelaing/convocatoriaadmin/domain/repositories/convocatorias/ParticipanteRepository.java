package org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias;

import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.AspiranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository  extends JpaRepository<AspiranteEntity, String> {
}
