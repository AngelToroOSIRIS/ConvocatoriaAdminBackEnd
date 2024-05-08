package org.escuelaing.convocatoriaadmin.api.controllers;

import org.escuelaing.convocatoriaadmin.api.models.responses.ExperienceResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "*")
public class ExperiencieController {
    public final IExperienceService experienceService;

    public ExperiencieController(IExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Set<ExperienceResponse>> getExperiencia(@PathVariable Integer id) {
        return ResponseEntity.ok(this.experienceService.getExperiencia(id));
    }
}
