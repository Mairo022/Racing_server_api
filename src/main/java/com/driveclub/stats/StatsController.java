package com.driveclub.stats;

import com.driveclub.logs.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    @Autowired
    private StatsService statsService;
}
