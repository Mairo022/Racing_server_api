package com.driveclub.endpoints.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {
    @Autowired
    private TrackService trackService;
    @GetMapping(value = "getAll")
    public ResponseEntity<List<Track>> getAll() {
        return ResponseEntity.ok(trackService.findAll());
    }

    @GetMapping(value = "getAllTracks")
    public ResponseEntity<List<String>>getAllTracks() {
        return ResponseEntity.ok(trackService.findAllTracks());
    }
}
