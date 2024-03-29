package com.driveclub.endpoints.laps;

import com.driveclub.endpoints.laps.dto.*;
import com.driveclub.utils.ModelMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LapsService {
    @Autowired
    private LapsRepository lapsRepository;

    public List<LapOverviewDTO> findSessionLapsOfDriver(UUID sessionID, Long driverID) {
        return lapsRepository.findSessionLapsOfDriver(sessionID, driverID);
    }

    public List<LapLeaderboardDTO> findBestValidLaps(Pageable pageable, String car, String track) {
        return lapsRepository.findBestValidLaps(pageable, car, track);
    }

    public Optional<Lap> findLap(int id) {
        return lapsRepository.findById(id);
    }

    public LapStatDTO findLapAndTotalCombinationLapsOfDriver(int id) {
        LapDTO lap = lapsRepository
                .findById(id)
                .map(driver -> ModelMapperFactory.getMapper().map(driver, LapDTO.class))
                .orElse(null);

        if (lap != null) {
            long driverID = lap.getDriver().getId();
            String track = lap.getTrack();
            String car = lap.getCar();

            int totalLaps = lapsRepository.findLapsCountByDriverIDTrackCar(driverID, track, car);

            return new LapStatDTO(lap, totalLaps);
        }

        return null;
    }

    public LapSectorsDTO findDriverBestSectors(String track, Long driverID, String car) {
        return lapsRepository.findDriverBestSectors(track, driverID, car);
    }

    public List<LapDriverValidDTO> findValidDriverLaps(Pageable pageable, Long driverID) {
        return lapsRepository.findValidDriverLaps(pageable, driverID);
    }
}
