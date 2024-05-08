package org.escuelaing.convocatoriaadmin.infrastructure.abstract_services;

import org.escuelaing.convocatoriaadmin.api.models.request.RequestNewConvocatoria;
import org.escuelaing.convocatoriaadmin.api.models.request.RequestUpdateConvocatoria;
import org.escuelaing.convocatoriaadmin.api.models.responses.ConvocatoriaResponse;
import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.ConvocatoriasEntity;

import java.util.Map;
import java.util.Set;

public interface IConvocatoriaServices {
    Set<ConvocatoriaResponse> getConvocatorias();
    Map<String, String> postConvocatoria(RequestNewConvocatoria requestNewConvocatoria);

    ConvocatoriasEntity putConvocatoria(Integer id, RequestUpdateConvocatoria requestUpdate);
}
