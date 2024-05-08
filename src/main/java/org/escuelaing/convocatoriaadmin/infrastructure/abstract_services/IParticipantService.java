package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.ParticipantResponse;

import java.util.LinkedHashSet;

public interface IParticipantService {
    ParticipantResponse getInfoAspirant(String document);

}
