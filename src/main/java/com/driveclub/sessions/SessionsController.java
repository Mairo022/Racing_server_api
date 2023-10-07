package com.driveclub.sessions;

import com.driveclub.logs.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sessions")
public class SessionsController {
    @Autowired
    private SessionsService sessionsService;
}
