package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.responses.ParticipantResponse;
import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.AspiranteEntity;
import org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias.ParticipanteRepository;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IParticipantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(value = "db1TransactionManager", readOnly = true)
public class ParticipantService implements IParticipantService {
    public ParticipantService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    private final ParticipanteRepository participanteRepository;

    public ParticipantResponse getInfoAspirant(String document) {
        AspiranteEntity participant = participanteRepository.findById(document).orElseThrow();

        return entityToResponse(participant);
    }

    private ParticipantResponse entityToResponse(AspiranteEntity aspiranteEntity) {
        ParticipantResponse response = new ParticipantResponse();

        response.setDocid(aspiranteEntity.getDocid());
        response.setTdoc(aspiranteEntity.getTdoc());
        response.setAp1((aspiranteEntity.getAp1()).toUpperCase());
        response.setAp2((aspiranteEntity.getAp2()).toUpperCase());
        response.setNom((aspiranteEntity.getNom().toUpperCase()));
        response.setFnac(aspiranteEntity.getFnac());
        response.setCiunac(aspiranteEntity.getCiunac());
        response.setEciv(aspiranteEntity.getEciv());
        response.setTpsan(aspiranteEntity.getTpsan());
        response.setFrh(aspiranteEntity.getFrh());
        response.setLmil(aspiranteEntity.getLmil());
        response.setClase(aspiranteEntity.getClase());
        response.setDmil(aspiranteEntity.getDmil());
        response.setDirres(aspiranteEntity.getDirres());
        response.setTelres(aspiranteEntity.getTelres());
        response.setCiudad(aspiranteEntity.getCiudad());
        response.setCel(aspiranteEntity.getCel());
        response.setEmail(aspiranteEntity.getEmail());
        response.setFreg(aspiranteEntity.getFreg());
        response.setPerfil(aspiranteEntity.getPerfil());
        response.setGen(aspiranteEntity.getGen());

        return response;
    }
}
