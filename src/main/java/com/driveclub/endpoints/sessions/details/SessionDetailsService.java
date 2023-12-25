package com.driveclub.endpoints.sessions.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionDetailsService {
    @Autowired
    private SessionDetailsRepository sessionsDetailsRepository;

    public List<SessionDetailsDTO> getSessionDetails(Pageable pageable, UUID sessionID) {
        return sessionsDetailsRepository.getDetails(pageable, sessionID);
    }
}
