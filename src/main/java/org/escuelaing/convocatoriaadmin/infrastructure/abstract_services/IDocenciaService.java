package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.DocenciaResponse;

import java.util.Set;

public interface IDocenciaService {
    Set<DocenciaResponse> getDocencia(Integer id);
}
