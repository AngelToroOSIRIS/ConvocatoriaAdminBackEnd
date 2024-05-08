package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.DistincionResponse;

import java.util.Set;

public interface IDistincionesServices {
    Set<DistincionResponse> getDistinciones(Integer id);
}
