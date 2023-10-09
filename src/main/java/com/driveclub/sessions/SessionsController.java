package com.driveclub.sessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions")
public class SessionsController {
    @Autowired
    private SessionsService sessionsService;

    @GetMapping(value = "getSessions")
    public ResponseEntity<Page<SessionDTO>> getSessions(
            @RequestParam Pageable pageable)
    {
        return ResponseEntity.ok(sessionsService.getSessions(pageable));
    }

    @GetMapping(value="getSession")
    public ResponseEntity<SessionDTO> getSession(
            @RequestParam Long id)
    {
        return ResponseEntity.ok(sessionsService.getSession(id));
    }

    @PostMapping(value="saveSession")
    public ResponseEntity<SessionDTO> saveSession(
            @RequestBody @Validated(SessionDTO.class) SessionDTO sessionDTO)
    {
        return ResponseEntity.ok(sessionsService.saveSession(sessionDTO));
    }
}
