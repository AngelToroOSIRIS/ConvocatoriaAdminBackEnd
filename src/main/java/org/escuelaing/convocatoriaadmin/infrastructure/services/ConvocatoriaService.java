package org.escuelaing.convocatoriaadmin.infrastructure.services;

import org.escuelaing.convocatoriaadmin.api.models.request.RequestNewConvocatoria;
import org.escuelaing.convocatoriaadmin.api.models.request.RequestUpdateConvocatoria;
import org.escuelaing.convocatoriaadmin.api.models.responses.ConvocatoriaResponse;
import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.ConvocatoriasEntity;
import org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias.ConvocatoriaRepository;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IConvocatoriaServices;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.NovasoftConnection;
import org.escuelaing.convocatoriaadmin.infrastructure.helpers.RegistroConnection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(value = "db1TransactionManager")
public class ConvocatoriaService implements IConvocatoriaServices {

    private final RegistroConnection registroConnection;
    private final NovasoftConnection novasoftConnection;

    private final ConvocatoriaRepository convocatoriaRepository;

    public ConvocatoriaService(RegistroConnection registroConnection, NovasoftConnection novasoftConnection, ConvocatoriaRepository convocatoriaRepository) {
        this.registroConnection = registroConnection;
        this.novasoftConnection = novasoftConnection;
        this.convocatoriaRepository = convocatoriaRepository;
    }

    public Set<ConvocatoriaResponse> getConvocatorias() {
        List<ConvocatoriasEntity> convocatorias = convocatoriaRepository.findAll();
        return convocatorias.stream().map(this::entityToResponse).sorted(Comparator.comparing(ConvocatoriaResponse::getFfin).reversed()).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Map<String, String> postConvocatoria(RequestNewConvocatoria request) {
        try {
            List<Map<String, String>> getIdSecuencia = registroConnection.executeSelectSql("""
                    select sig_sec as id from registro.secuencias where nombre='CONVOCATORIA'
                    """);

            Integer idSecuencia = Integer.valueOf(getIdSecuencia.get(0).get("id").trim());

            DateTimeFormatter formateador = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toFormatter();

            ConvocatoriasEntity convocatoriaToPersist = new ConvocatoriasEntity();
            convocatoriaToPersist.setIdcon(idSecuencia);
            convocatoriaToPersist.setUnidad(request.unidad);
            convocatoriaToPersist.setNombre(request.nombre);
            convocatoriaToPersist.setDescon(request.descon);
            convocatoriaToPersist.setEstado("Abierta");
            convocatoriaToPersist.setFini(String.valueOf(LocalDateTime.parse(request.fini + " 00:00:00", formateador)));
            convocatoriaToPersist.setFfin(String.valueOf(LocalDateTime.parse(request.ffin + " 00:00:00", formateador)));
            convocatoriaToPersist.setTipo(request.tipo);
            convocatoriaToPersist.setAsig(0);
            convocatoriaToPersist.setPeracad(request.periodo);
            convocatoriaToPersist.setIdadm(Integer.valueOf(request.idadm));
            convocatoriaToPersist.setDirunidad(Integer.valueOf(request.dirunidad));

            convocatoriaRepository.save(convocatoriaToPersist);

            registroConnection.executeSql("""
                    update registro.secuencias set sig_sec=(sig_sec + incr) where nombre='CONVOCATORIA'
                    """);

            return Collections.singletonMap("message", "Convocatoria creada correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public ConvocatoriasEntity putConvocatoria(Integer id, RequestUpdateConvocatoria requestUpdate) {
        try {
            List<ConvocatoriasEntity> convocatorias = convocatoriaRepository.findAllByIdcon(id);

            if (convocatorias.size() < 1) {
                throw new RuntimeException();
            }

            ConvocatoriasEntity convocatoriaToUpdate = convocatorias.get(0);

            convocatoriaToUpdate.setNombre(requestUpdate.nombre);
            convocatoriaToUpdate.setDescon(requestUpdate.descon);
            convocatoriaToUpdate.setUnidad(requestUpdate.unidad);
            convocatoriaToUpdate.setFini(requestUpdate.fini);
            convocatoriaToUpdate.setFfin(requestUpdate.ffin);
            convocatoriaToUpdate.setEstado("Abierta");
            convocatoriaToUpdate.setTipo(requestUpdate.tipo);
            convocatoriaToUpdate.setPeracad(requestUpdate.peracad);
            convocatoriaToUpdate.setIdadm(Integer.valueOf(requestUpdate.idadm));
            convocatoriaToUpdate.setDirunidad(Integer.valueOf(requestUpdate.dirunidad));

            convocatoriaRepository.save(convocatoriaToUpdate);
            return convocatoriaToUpdate;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private ConvocatoriaResponse entityToResponse(ConvocatoriasEntity convocatoriasEntity) {
        ConvocatoriaResponse response = new ConvocatoriaResponse();


        response.setIdcon(convocatoriasEntity.getIdcon());
        response.setNombre(convocatoriasEntity.getNombre());
        response.setDescon(convocatoriasEntity.getDescon());
        response.setUnidad(convocatoriasEntity.getUnidad());
        response.setFini(convocatoriasEntity.getFini());
        response.setFfin(convocatoriasEntity.getFfin());
        response.setTipo(convocatoriasEntity.getTipo());
        response.setAsig(convocatoriasEntity.getAsig());
        response.setPeracad(convocatoriasEntity.getPeracad());
        response.setEstado(convocatoriasEntity.getEstado());
        response.setIdadm(convocatoriasEntity.getIdadm());
        response.setDirunidad(convocatoriasEntity.getDirunidad());
        return response;
    }

}
