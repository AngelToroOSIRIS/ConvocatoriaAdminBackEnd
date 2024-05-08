package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.responses.MembresiaResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IMembresiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "*")
public class MembresiaController {
    public final IMembresiaService membresiaService;

    public MembresiaController(IMembresiaService membresiaService) {
        this.membresiaService = membresiaService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Set<MembresiaResponse>> findAllByIdemp(@PathVariable String id){
        return ResponseEntity.ok(this.membresiaService.findAllByIdemp(id));
    }
}
