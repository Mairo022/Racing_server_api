package com.driveclub.stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping(value = "getStats")
    public ResponseEntity<Page<StatDTO>> getStats(
            @RequestParam String car,
            @RequestParam String track,
            @RequestParam Pageable pageable)
    {
        return ResponseEntity.ok(statsService.getStats(pageable, track, car));
    }

    @GetMapping(value="getStat")
    public ResponseEntity<StatDTO> getStat(
            @RequestParam Long id)
    {
        return ResponseEntity.ok(statsService.getStat(id));
    }

    @PostMapping(value="saveStat")
    public ResponseEntity<StatDTO> saveStat(
            @RequestBody @Validated(StatDTO.class) StatDTO statDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(statsService.saveStat(statDTO));
    }

    @DeleteMapping(value="deleteStat")
    public ResponseEntity<Void> deleteStat(
            @RequestParam Long id)
    {
        statsService.deleteStat(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
