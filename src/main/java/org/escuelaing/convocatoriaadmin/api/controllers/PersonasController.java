package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.responses.PersonaResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IPersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = "*")
public class PersonasController {
    private final IPersonaService personaService;

    public PersonasController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<Set<PersonaResponse>> getPersonas() {
        return ResponseEntity.ok(this.personaService.getPersonas());
    }
}
