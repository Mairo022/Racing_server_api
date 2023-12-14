package com.driveclub.endpoints.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Log, Long>, JpaSpecificationExecutor<Log> {
}
