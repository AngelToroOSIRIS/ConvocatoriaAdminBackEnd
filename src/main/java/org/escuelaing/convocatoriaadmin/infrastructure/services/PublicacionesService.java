package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.PublicacionesResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IPublicacionesService;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PublicacionesService implements IPublicacionesService {

    private final RegistroConnection registroConnection;

    public PublicacionesService(RegistroConnection registroConnection) {
        this.registroConnection = registroConnection;
    }

    public Set<PublicacionesResponse> getPublicaciones(Integer id) {
        try {
            List<Map<String, String>> publicacion = registroConnection.executeSelectSql(String.format("""
                    select idpub, tipo, titulo, titmay, area, fec, edic, edit, ciudad, pais from odi.publicaciones where idemp = '%s' order by fec DESC
                    """, id));
            return publicacion.stream().map(this::entityToResponse).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private PublicacionesResponse entityToResponse(Map<String, String> publicacion) {
        PublicacionesResponse response = new PublicacionesResponse();

        response.setIdpub(Integer.valueOf(publicacion.get("idpub")));
        response.setTipo(publicacion.get("tipo"));
        response.setTitulo(publicacion.get("titulo"));
        response.setTitmay(publicacion.get("titmay"));
        response.setArea(publicacion.get("area"));
        response.setFec(publicacion.get("fec"));
        response.setEdic(publicacion.get("edic"));
        response.setEdit(publicacion.get("edit"));
        response.setCiudad(publicacion.get("ciudad"));
        response.setPais(publicacion.get("pais"));
        return response;
    }

}
