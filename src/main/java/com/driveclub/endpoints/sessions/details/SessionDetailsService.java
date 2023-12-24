package com.driveclub.endpoints.sessions.details;

import com.driveclub.utils.ModelMapperFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionDetailsService {
    @Autowired
    private SessionDetailsRepository sessionsDetailsRepository;

    public Page<SessionDetailsDTO> getSessionDetails(Pageable pageable, UUID sessionID) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        Specification<SessionDetails> spec = Specification.where(null);

        if (sessionID != null) spec = spec.and((session, cq, cb) ->
                cb.equal(session.get("sessionID"), sessionID)
        );

        return sessionsDetailsRepository
                .findAll(spec, pageable)
                .map(sessionDetails -> modelMapper.map(sessionDetails, SessionDetailsDTO.class));
    }
}
