package com.driveclub.endpoints.laps;

import com.driveclub.endpoints.laps.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<List<LapOverviewDTO>> getDriverSessionLaps(
            @RequestParam UUID sessionID,
            @RequestParam Long driverID
    )
    {
        return ResponseEntity.ok(lapsService.getDriverSessionLaps(sessionID, driverID));
    }

    @GetMapping(value="getLeaderboard")
    public ResponseEntity<List<LapLeaderboardDTO>> getLeaderboard(
            @PageableDefault(
                    page = 0,
                    size = 50,
                    sort = "laptime",
                    direction = Sort.Direction.ASC
            ) Pageable pageable,
            @RequestParam String car,
            @RequestParam String track
    )
    {
        return ResponseEntity.ok(lapsService.findBestValidLaps(pageable, car, track));
    }

    @GetMapping(value="getLap")
    public ResponseEntity<Optional<Lap>> getLap(@RequestParam int id) {
        return ResponseEntity.ok(lapsService.getLap(id));
    }

    @GetMapping(value="getLapStat")
    public ResponseEntity<LapStatDTO> getLapStat(@RequestParam int id) {
        return ResponseEntity.ok(lapsService.getLapStat(id));
    }

    @GetMapping(value="getBestSectors")
    public ResponseEntity<LapSectorsDTO> getBestSectorTimes(
            @RequestParam String track,
            @RequestParam Long driverID
    )
    {
        return ResponseEntity.ok(lapsService.getBestSectorTimes(track, driverID));
    }

    @GetMapping(value = "getValidDriverLaps")
    public ResponseEntity<List<LapDriverValidDTO>> getValidDriverLaps(
            @PageableDefault(
                    page = 0,
                    size = 20,
                    sort = "date",
                    direction = Sort.Direction.DESC
            ) Pageable pageable,
            @RequestParam Long driverID
    )
    {
        return ResponseEntity.ok(lapsService.findValidDriverLaps(pageable, driverID));
    }
}
