package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.request.RequestNewConvocatoria;
import org.escuelaing.convocatoriaadmin.api.models.request.RequestUpdateConvocatoria;
import org.escuelaing.convocatoriaadmin.api.models.responses.ConvocatoriaResponse;
import org.escuelaing.convocatoriaadmin.domain.entities.convocatorias.ConvocatoriasEntity;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IConvocatoriaServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/announcement")
@CrossOrigin(origins = "*")
public class ConvocatoriasController {
    private final IConvocatoriaServices convocatoriaServices;

    public ConvocatoriasController(IConvocatoriaServices convocatoriaServices) {
        this.convocatoriaServices = convocatoriaServices;
    }

    @GetMapping
    public ResponseEntity<Set<ConvocatoriaResponse>> getConvocatorias() {
        return ResponseEntity.ok(this.convocatoriaServices.getConvocatorias());
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postConvocatoria(@RequestBody RequestNewConvocatoria request) {
        return ResponseEntity.ok(this.convocatoriaServices.postConvocatoria( request));
    }

    @PutMapping("{id}")
    public ResponseEntity<ConvocatoriasEntity> putConvocatoria(@PathVariable Integer id, @RequestBody RequestUpdateConvocatoria requestUpdate) {
        return ResponseEntity.ok(this.convocatoriaServices.putConvocatoria(id, requestUpdate));
    }
}
