package com.driveclub.stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    @Autowired
    private StatsRepository statsRepository;
}
