package com.driveclub.stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<Stat, Long>, JpaSpecificationExecutor<Stat> {
}