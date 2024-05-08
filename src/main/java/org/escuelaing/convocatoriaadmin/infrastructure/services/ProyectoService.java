package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.ProyectoResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IProyectoService;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProyectoService implements IProyectoService {

    private final RegistroConnection registroConnection;

    public ProyectoService(RegistroConnection registroConnection) {
        this.registroConnection = registroConnection;
    }

    public Set<ProyectoResponse> getProyectos(Integer id) {
        try{
            List<Map<String, String>> proyecto = registroConnection.executeSelectSql(String.format("""
                    select idpro, tipp, titp, convert(varchar(10),fini,103) fini, convert(varchar(10),ffin,103) ffin, blq
                    from odi.productos
                    where idemp = '%s' order by fini
                    """, id));
            return proyecto.stream().map(this::entityToResponse).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private ProyectoResponse entityToResponse(Map<String, String> proyecto){
        ProyectoResponse response = new ProyectoResponse();

        response.setIdpro(Integer.valueOf(proyecto.get("idpro")));
        response.setTipp(proyecto.get("tipp"));
        response.setTitp(proyecto.get("titp"));
        response.setFini(proyecto.get("fini"));
        response.setFfin(proyecto.get("ffin"));
        response.setBlq(proyecto.get("blq"));
        return response;
    }

}
