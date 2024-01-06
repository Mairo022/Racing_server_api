package com.driveclub.endpoints.laps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LapsService {
    @Autowired
    private LapsRepository lapsRepository;

    public List<LapOverviewDTO> getDriverSessionLaps(UUID sessionID, Long driverID) {
        return lapsRepository.getDriverSessionLaps(sessionID, driverID);
    }

    public Optional<Lap> getLap(int id) {
        return lapsRepository.findById(id);
    }

    public LapSectorsDTO getBestSectorTimes(String track, Long driverID) {
        return lapsRepository.getBestSectorTimes(track, driverID);
    }
}
