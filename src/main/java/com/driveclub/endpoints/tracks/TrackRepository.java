package com.driveclub.endpoints.tracks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Short>, JpaSpecificationExecutor<Track> {
    @Query(value="SELECT track FROM Track ORDER BY track ASC")
    List<String> findAllTracks();
}