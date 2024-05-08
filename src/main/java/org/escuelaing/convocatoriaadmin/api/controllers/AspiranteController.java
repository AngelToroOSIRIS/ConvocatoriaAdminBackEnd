package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.request.RequestNewAspirante;
import org.escuelaing.convocatoriaadmin.api.models.responses.AspiranteResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IAspiranteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/participant")
@CrossOrigin(origins = "*")
public class AspiranteController {
    public AspiranteController(IAspiranteService aspiranteService) {
        this.aspiranteService = aspiranteService;
    }

    public final IAspiranteService aspiranteService;


    @GetMapping(path = "{id}")
    public ResponseEntity<Set<AspiranteResponse>> getAspirantes(@PathVariable Integer id) {
        return ResponseEntity.ok(this.aspiranteService.getAspirantes(id));
    }

    @PostMapping
    public ResponseEntity<Set<AspiranteResponse>> crearAspirante(@RequestBody RequestNewAspirante request) {
        return ResponseEntity.ok(this.aspiranteService.crearAspirante(request));
    }

}
