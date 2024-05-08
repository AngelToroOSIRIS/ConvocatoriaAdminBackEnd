package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.PersonaResponse;

import java.util.Set;

public interface IPersonaService {
    Set<PersonaResponse> getPersonas();
}
