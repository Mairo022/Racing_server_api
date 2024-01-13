package com.driveclub.endpoints.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
public class LogsController {
    @Autowired
    private LogsService logsService;

    @GetMapping(value="getLogs")
    public ResponseEntity<Page<LogDTO>> getLogs(
            @RequestParam Pageable pageable)
    {
        return ResponseEntity.ok(logsService.findAll(pageable));
    }

    @PostMapping(value="saveLog")
    public ResponseEntity<LogDTO> saveLog(
            @RequestBody @Validated(LogDTO.class) LogDTO log)
    {
        return ResponseEntity.ok(logsService.saveLog(log));
    }

    @DeleteMapping(value="deleteLog")
    public ResponseEntity<Void> deleteLog(
            @RequestParam Long id)
    {
        logsService.deleteLog(id);
        return ResponseEntity.ok().build();
    }
}
