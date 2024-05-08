package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.EstudiosResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IEstudioService;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EstudioService implements IEstudioService {

    private final RegistroConnection registroConnection;

    public EstudioService(RegistroConnection registroConnection) {
        this.registroConnection = registroConnection;
    }


    public Set<EstudiosResponse> getEstudios(Integer id) {
        try {
            List<Map<String, String>> estudio = registroConnection.executeSelectSql(String.format("""
                    select idestud, nom_est, nom_ins, convert(varchar(10), fec_gra, 103) fgra, des_est,blq, nro_tar
                    from  novasoft.dbo.rhh_tbclaest, odi.estudasp, novasoft.dbo.rhh_tbinsti
                    where novasoft.dbo.rhh_tbclaest.tip_est = odi.estudasp.tip_est collate Modern_Spanish_CI_AS and
                    odi.estudasp.cod_ins collate Modern_Spanish_CI_AS = novasoft.dbo.rhh_tbinsti.cod_ins and
                    cod_emp = '%s' order by fec_gra DESC       
                    """, id));
            return estudio.stream().map(this::entityResponse).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private EstudiosResponse entityResponse(Map<String, String> estudio) {
        EstudiosResponse response = new EstudiosResponse();

        response.setIdestud(Integer.valueOf(estudio.get("idestud")));
        response.setNom_est(estudio.get("nom_est"));
        response.setNom_ins(estudio.get("nom_ins").trim());
        response.setFgra(estudio.get("fgra"));
        response.setDes_est(estudio.get("des_est").trim());
        response.setBlq(estudio.get("blq"));
        response.setNro_tar(estudio.get("nro_tar"));
        return response;
    }

}
