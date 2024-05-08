package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.ProyectoResponse;

import java.util.Set;

public interface IProyectoService {
    Set<ProyectoResponse> getProyectos(Integer id);
}
