package org.escuelaing.convocatoriaadmin.api.controllers;


import org.escuelaing.convocatoriaadmin.api.models.responses.PublicacionesResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IPublicacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/publication")
@CrossOrigin(origins = "*")
public class PublicacionController {
    private final IPublicacionesService publicacionesService;

    public PublicacionController(IPublicacionesService publicacionesService) {
        this.publicacionesService = publicacionesService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Set<PublicacionesResponse>> getPublicacion(@PathVariable Integer id) {
        return ResponseEntity.ok(this.publicacionesService.getPublicaciones(id));
    }
}
