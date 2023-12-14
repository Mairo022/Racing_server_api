package com.driveclub.endpoints.sessions.details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDetailsRepository extends JpaRepository<SessionDetails, Long>, JpaSpecificationExecutor<SessionDetails> {
}
