package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.DocenciaResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IDocenciaService;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DocenciaService implements IDocenciaService {

    private final RegistroConnection registroConnection;

    public DocenciaService(RegistroConnection registroConnection) {
        this.registroConnection = registroConnection;
    }

    public Set<DocenciaResponse> getDocencia(Integer id){
        try {
            List<Map<String, String>> docencia = registroConnection.executeSelectSql(String.format("""
                    select * FROM odi.histprof where docprof = '%s'""", id));
            return docencia.stream().map(this::entityResponse).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private DocenciaResponse entityResponse(Map<String, String> docencia) {
        DocenciaResponse response = new DocenciaResponse();

        response.setPeriodo(docencia.get("periodo"));
        response.setDocprof(Integer.valueOf(docencia.get("docprof")));
        response.setNom_asig(docencia.get("nom_asig"));
        response.setGrupo(Integer.valueOf(docencia.get("grupo")));
        response.setCan_alum(Integer.valueOf(docencia.get("can_alum")));
        response.setCan_gan(Integer.valueOf(docencia.get("can_gan")));
        response.setPerdida(Integer.valueOf(docencia.get("perdida")));
        response.setCancelaron(Integer.valueOf(docencia.get("cancelaron")));
        return response;
    }
}
