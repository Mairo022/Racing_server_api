package com.driveclub.endpoints.sessions;

import com.driveclub.utils.ModelMapperFactory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionsService {
    @Autowired
    private SessionsRepository sessionsRepository;

    public Page<SessionDTO> findAll(Pageable pageable) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        Specification<Session> spec = Specification.where(null);

        return sessionsRepository
                .findAll(spec, pageable)
                .map(session -> modelMapper.map(session, SessionDTO.class));
    }

    public SessionDTO findSession(UUID session_id) {
        return sessionsRepository
                .findById(session_id)
                .map(session -> ModelMapperFactory.getMapper().map(session, SessionDTO.class))
                .orElse(null);
    }

    public Page<List> findOverviews(Pageable pageable) {
        return sessionsRepository.findOverviews(pageable);
    }
}
