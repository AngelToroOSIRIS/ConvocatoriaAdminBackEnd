package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.request.RequestNewAspirante;
import org.escuelaing.convocatoriaadmin.api.models.responses.AspiranteResponse;

import java.util.Set;


public interface IAspiranteService {
    Set<AspiranteResponse> getAspirantes(Integer id);

    Set<AspiranteResponse> crearAspirante(RequestNewAspirante request);
}
