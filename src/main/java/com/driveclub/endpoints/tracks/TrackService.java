package com.driveclub.endpoints.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    public List<String> findAllTracks() {
        return trackRepository.findAllTracks();
    }
}
