package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.responses.EstudiosResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IEstudioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/study")
@CrossOrigin(origins = "*")
public class EstudioController {
    public final IEstudioService estudioService;

    public EstudioController(IEstudioService estudioService) {
        this.estudioService = estudioService;
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<Set<EstudiosResponse>> getEstudios(@PathVariable Integer id) {
        return ResponseEntity.ok(this.estudioService.getEstudios(id));
    }
}
