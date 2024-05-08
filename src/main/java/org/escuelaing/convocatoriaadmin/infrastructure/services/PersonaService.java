package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.PersonaResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IPersonaService;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.NovasoftConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService {
    private final NovasoftConnection novasoftConnection;

    public PersonaService(NovasoftConnection novasoftConnection) {
        this.novasoftConnection = novasoftConnection;
    }

    public Set<PersonaResponse> getPersonas() {
        try {
            List<Map<String, String>> people = novasoftConnection.executeSelectSql("""
                    select  distinct a.cod_emp,  ltrim(rtrim(a.ap1_emp)) + ' ' + ltrim(rtrim(ap2_emp)) + ' ' + ltrim(rtrim(a.nom_emp)) as nombre, a.cod_cl1, b.nombre as area
                    from Novasoft.dbo.rhh_emplea a
                    inner join Novasoft.dbo.gen_clasif1 b on (a.cod_cl1 = b.codigo)
                    WHERE est_lab in ('02', '01')
                            """);

            return people.stream().map(this::entityToResponse).sorted(Comparator.comparing(PersonaResponse::getNombre)).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private PersonaResponse entityToResponse(Map<String, String> person) {
        PersonaResponse response = new PersonaResponse();

        response.setCod_emp(Integer.parseInt(person.get("cod_emp").trim()));
        response.setNombre(person.get("nombre"));
        response.setCod_cl1(Integer.parseInt(person.get("cod_cl1").trim()));
        response.setArea(person.get("area"));

        return response;
    }
}
