package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.DistincionResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IDistincionesServices;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DistincionesService implements IDistincionesServices {

    private final RegistroConnection registroConnection;

    public DistincionesService(RegistroConnection registroConnection) {
        this.registroConnection = registroConnection;
    }

    public Set<DistincionResponse> getDistinciones(Integer id){
        try{
            List<Map<String, String>> distincion = registroConnection.executeSelectSql(String.format("""
                    select iddis, nombre, instit, pais, anio, razon, blq
                    from odi.distinciones where idemp = '%s' order by anio
                    """, id));
            return distincion.stream().map(this::entityToResponse).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private DistincionResponse entityToResponse(Map<String, String> distinciones) {
        DistincionResponse response = new DistincionResponse();

        response.setIddis(Integer.valueOf(distinciones.get("iddis")));
        response.setNombre(distinciones.get("nombre"));
        response.setInstit(distinciones.get("instit"));
        response.setPais(distinciones.get("pais"));
        response.setAnio(distinciones.get("anio"));
        response.setRazon(distinciones.get("razon"));
        response.setBlq(distinciones.get("bql"));
        return response;
    }

}
