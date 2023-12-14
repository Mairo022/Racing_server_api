package com.driveclub.endpoints.sessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessionsRepository extends JpaRepository<Session, UUID>, JpaSpecificationExecutor<Session> {
}