package com.driveclub.endpoints.sessions.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/sessions/details")
public class SessionDetailsController {
    @Autowired
    private SessionDetailsService sessionDetailsService;

    @GetMapping(value="getDetails")
    public ResponseEntity<Page<SessionDetailsDTO>> getDetails(
            @PageableDefault(
                    page = 0,
                    size = 50
            ) Pageable pageable,
            UUID sessionID)
    {
        return ResponseEntity.ok(sessionDetailsService.getSessionDetails(pageable, sessionID));
    }
}
