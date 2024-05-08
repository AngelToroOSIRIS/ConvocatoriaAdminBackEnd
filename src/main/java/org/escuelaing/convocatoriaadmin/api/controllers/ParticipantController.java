package org.escuelaing.convocatoriaadmin.api.controllers;


import org.escuelaing.convocatoriaadmin.api.models.responses.ParticipantResponse;
import org.escuelaing.convocatoriaadmin.infrastructure.abstract_services.IParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/infoAspirant")
@CrossOrigin(origins = "*")
public class ParticipantController {
    public final IParticipantService participantService;

    public ParticipantController(IParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping(path = "{document}")
    public ResponseEntity<ParticipantResponse> getInfoAspirant(@PathVariable String document) {
        return ResponseEntity.ok(this.participantService.getInfoAspirant(document));
    }

}
