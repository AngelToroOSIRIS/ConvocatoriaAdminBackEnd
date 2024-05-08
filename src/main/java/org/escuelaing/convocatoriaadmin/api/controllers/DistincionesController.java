package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.responses.DistincionResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IDistincionesServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/distincion")
@CrossOrigin(origins = "*")
public class DistincionesController {
    private final IDistincionesServices distincionesServices;

    public DistincionesController(IDistincionesServices distincionesServices) {
        this.distincionesServices = distincionesServices;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Set<DistincionResponse>> getDistinciones(@PathVariable Integer id){
        return  ResponseEntity.ok(this.distincionesServices.getDistinciones(id));
    }
}
