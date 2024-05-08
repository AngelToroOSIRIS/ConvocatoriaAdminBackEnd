package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.responses.ExperienceResponse;

import java.util.Set;

public interface IExperienceService {
    Set<ExperienceResponse> getExperiencia(Integer id);
}
