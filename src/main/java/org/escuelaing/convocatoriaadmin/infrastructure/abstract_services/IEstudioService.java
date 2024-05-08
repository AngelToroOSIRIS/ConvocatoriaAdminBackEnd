package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.EstudiosResponse;

import java.util.Set;

public interface IEstudioService {
    Set<EstudiosResponse> getEstudios(Integer id);
}
