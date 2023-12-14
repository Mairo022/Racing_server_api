package com.driveclub.sessions;

import com.driveclub.utils.ModelMapperFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionsService {
    @Autowired
    private SessionsRepository sessionsRepository;

    public Page<SessionDTO> getSessions(Pageable pageable) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        Specification<Session> spec = Specification.where(null);

        return sessionsRepository
                .findAll(spec, pageable)
                .map(session -> modelMapper.map(session, SessionDTO.class));
    }

    public SessionDTO getSession(UUID session_id) {
        return sessionsRepository
                .findById(session_id)
                .map(session -> ModelMapperFactory.getMapper().map(session, SessionDTO.class))
                .orElse(null);
    }
}
