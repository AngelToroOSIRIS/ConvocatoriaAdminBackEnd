package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.responses.IdiomaResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IIdiomaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/language")
@CrossOrigin(origins = "*")
public class IdiomaController {

    public IdiomaController(IIdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }

    public final IIdiomaService idiomaService;

    @GetMapping(path = "{cedula}")
    public ResponseEntity<Set<IdiomaResponse>> findAllByCedula(@PathVariable String cedula) {
        return ResponseEntity.ok(this.idiomaService.findAllByCedula(cedula));
    }
}
