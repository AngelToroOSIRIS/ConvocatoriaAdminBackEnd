package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.PublicacionesResponse;

import java.util.Set;

public interface IPublicacionesService {
    Set<PublicacionesResponse> getPublicaciones(Integer id);
}
