package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.MembresiaResponse;
import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.MembresiaEntity;
import org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias.MembresiaRepository;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IMembresiaService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MembresiaService implements IMembresiaService {
    public MembresiaRepository membresiaRepository;

    public MembresiaService(MembresiaRepository membresiaRepository) {
        this.membresiaRepository = membresiaRepository;
    }

    public Set<MembresiaResponse> findAllByIdemp(String id) {
        List<MembresiaEntity> membresia = membresiaRepository.findAllByIdemp(id);
        return membresia.stream().map(this::entityToResponse).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private MembresiaResponse entityToResponse(MembresiaEntity membresiaEntity) {
        MembresiaResponse response = new MembresiaResponse();

        response.setIdmem(membresiaEntity.getIdmem());
        response.setIdemp(Integer.valueOf(membresiaEntity.getIdemp()));
        response.setOrg(membresiaEntity.getOrg());
        response.setTipm(membresiaEntity.getTipm());
        response.setFing(membresiaEntity.getFing());
        response.setFret(membresiaEntity.getFret());
        response.setCat(membresiaEntity.getCat());
        response.setPais(membresiaEntity.getPais());
        return response;
    }
}
