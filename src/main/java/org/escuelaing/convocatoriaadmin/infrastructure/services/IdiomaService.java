package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.IdiomaResponse;
import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.IdiomasEntity;
import org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias.IdiomasRepository;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IIdiomaService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IdiomaService implements IIdiomaService {
    public IdiomaService(IdiomasRepository idiomasRepository) {
        this.idiomasRepository = idiomasRepository;
    }

    private final IdiomasRepository idiomasRepository;

    public Set<IdiomaResponse> findAllByCedula(String cedula) {
        List<IdiomasEntity> idioma = idiomasRepository.findAllByIdemp(cedula);
        return idioma.stream().map(this::entityToResponse).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private IdiomaResponse entityToResponse(IdiomasEntity idiomasEntity) {
        IdiomaResponse response = new IdiomaResponse();

        response.setIdlen(idiomasEntity.getIdlen());
        response.setIdemp(idiomasEntity.getIdemp());
        response.setLengua(idiomasEntity.getLengua());
        response.setNivlec(idiomasEntity.getNivlec());
        response.setNivhab(idiomasEntity.getNivhab());
        response.setNivesc(idiomasEntity.getNivesc());
        response.setBlq(idiomasEntity.getBlq());
        return response;
    }

}
