package com.driveclub.endpoints.laps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/laps")
public class LapsController {
    @Autowired
    private LapsService lapsService;

    @GetMapping(value="getDriverSessionLaps")
    public ResponseEntity<List<LapOverviewsDTO>> getDriverSessionLaps(
            @RequestParam UUID sessionID,
            @RequestParam Long driverID
    )
    {
        return ResponseEntity.ok(lapsService.getDriverSessionLaps(sessionID, driverID));
    }

    @GetMapping(value="getLap")
    public ResponseEntity<Optional<Lap>> getLap(@RequestParam int id) {
        return ResponseEntity.ok(lapsService.getLap(id));
    }
}
