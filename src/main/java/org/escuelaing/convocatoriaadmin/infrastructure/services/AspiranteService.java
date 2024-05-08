package org.escuelaing.convocatoriaadmin.infrastructure.services;


import org.escuelaing.convocatoriaadmin.api.models.request.RequestNewAspirante;
import org.escuelaing.convocatoriaadmin.api.models.responses.AspiranteResponse;
import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.AspiranteEntity;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IAspiranteService;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AspiranteService implements IAspiranteService {
    private final RegistroConnection registroConnection;

    public AspiranteService(RegistroConnection registroConnection) {
        this.registroConnection = registroConnection;
    }

    public Set<AspiranteResponse> getAspirantes(Integer id) {
        try {
            List<Map<String, String>> aspirant = registroConnection.executeSelectSql("""
                    select LTRIM(RTRIM(b.ap1)) + ' ' + LTRIM(RTRIM(b.ap2)) + ' ' + LTRIM(RTRIM(b.nom)) as nombre,  a.estado, a.obs, a.fecha, a.conv, b.docid
                    from odi.partconvoca a
                    inner join odi.aspirante b on (a.cod_emp = b.docid)
                    where a.conv =
                    """ + id);
            return aspirant.stream().map(this::entityToResponse).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public Set<AspiranteResponse> crearAspirante(RequestNewAspirante request) {
        try {

            List<Map<String, String>> validarAspiranteExistente = registroConnection.executeSelectSql(String.format("""
                    SELECT * FROM odi.aspirante where docid = '%s' 
                    """, request.docid));

            if (validarAspiranteExistente.size() > 0) {
                System.out.println(validarAspiranteExistente);
                throw new RuntimeException();
            } else {

                System.out.println(validarAspiranteExistente);

                AspiranteEntity aspiranteToPersist = new AspiranteEntity();
                aspiranteToPersist.setNom(request.nom);
                aspiranteToPersist.setAp1(request.ap1);
                aspiranteToPersist.setAp2(request.ap2);
                aspiranteToPersist.setDocid(request.docid);
                aspiranteToPersist.setEmail(request.email);

                registroConnection.executeSql(String.format("""
                        INSERT INTO odi.aspirante (nom, ap1, ap2, docid, email) VALUES ('%s', '%s', '%s', '%s', '%s');
                        """, request.nom, request.ap1, request.ap2, request.docid, request.email));

                return (Set<AspiranteResponse>) Collections.singletonMap("message", "Usuario creado correctamenre");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private AspiranteResponse entityToResponse(Map<String, String> aspirant) {
        AspiranteResponse response = new AspiranteResponse();

        response.setNombre((aspirant.get("nombre").toUpperCase()));
        response.setEstado(aspirant.get("estado"));
        response.setObs(aspirant.get("obs"));
        response.setFecha(aspirant.get("fecha"));
        response.setDocid(Integer.parseInt(aspirant.get("docid").trim()));
        return response;
    }
}
