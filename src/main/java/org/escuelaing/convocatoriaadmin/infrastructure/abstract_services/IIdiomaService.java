package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.IdiomaResponse;

import java.util.Set;

public interface IIdiomaService {
    Set<IdiomaResponse> findAllByCedula(String cedula);
}
