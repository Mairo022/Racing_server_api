package com.driveclub.endpoints.sessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sessions")
public class SessionsController {
    @Autowired
    private SessionsService sessionsService;

    @GetMapping(value = "getSessions")
    public ResponseEntity<Page<SessionDTO>> getAll(
            @PageableDefault(
                    page = 0,
                    size = 50,
                    sort = "date",
                    direction = Sort.Direction.DESC
            ) Pageable pageable)
    {
        return ResponseEntity.ok(sessionsService.findAll(pageable));
    }

    @GetMapping(value="getSession")
    public ResponseEntity<SessionDTO> getSession(
            @RequestParam UUID id)
    {
        return ResponseEntity.ok(sessionsService.findSession(id));
    }

    @GetMapping(value="getOverviews")
    public ResponseEntity<Page<List>> getOverviews(
            @PageableDefault(
                    page = 0,
                    size = 50,
                    sort = "date",
                    direction = Sort.Direction.DESC
            ) Pageable pageable)
    {
        return ResponseEntity.ok(sessionsService.findOverviews(pageable));
    }
}
