package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.ExperienceResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IExperienceService;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExperienceService implements IExperienceService {
    private final RegistroConnection registroConnection;

    public ExperienceService(RegistroConnection registroConnection) {
        this.registroConnection = registroConnection;
    }

    public Set<ExperienceResponse> getExperiencia(Integer id){
        try {
            List<Map<String, String>> experience = registroConnection.executeSelectSql(String.format("""
                    select idhis, nomorg, convert(varchar(10), fini, 103) + ' - ' + convert(varchar(10), ffin, 103) as periodo,
                    cargo as nombre_cargo, tpcar as tipo_cargo, convert(varchar(10), fini, 103) fini, convert(varchar(10), ffin, 103) ffin
                    from odi.histlab where idemp = '%s' order by odi.histlab.fini DESC""", id));

            return experience.stream().map(this::entityResponse).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
    private ExperienceResponse entityResponse(Map<String, String> experience){
        ExperienceResponse response = new ExperienceResponse();

        response.setIdhis(Integer.valueOf(experience.get("idhis")));
        response.setNomorg(experience.get("nomorg"));
        response.setPeriodo(experience.get("periodo"));
        response.setNombre_cargo(experience.get("nombre_cargo"));
        response.setTipo_cargo(experience.get("tipo_cargo"));
        response.setFini(experience.get("fini"));
        response.setFfin(experience.get("ffin"));

        return response;
    }

}
