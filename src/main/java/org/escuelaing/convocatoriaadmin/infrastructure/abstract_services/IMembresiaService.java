package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.MembresiaResponse;

import java.util.Set;

public interface IMembresiaService {
    Set<MembresiaResponse> findAllByIdemp(String id);
}
