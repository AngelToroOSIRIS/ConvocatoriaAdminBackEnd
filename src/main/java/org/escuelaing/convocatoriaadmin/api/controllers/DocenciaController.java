package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.responses.DocenciaResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IDocenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teaching")
@CrossOrigin(origins = "*")
public class DocenciaController {
    public final IDocenciaService docenciaService;

    public DocenciaController(IDocenciaService docenciaService) {
        this.docenciaService = docenciaService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Set<DocenciaResponse>> getDocencia(@PathVariable Integer id){
        return ResponseEntity.ok(this.docenciaService.getDocencia(id));
    }
}
