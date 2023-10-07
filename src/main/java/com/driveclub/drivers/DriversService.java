package com.driveclub.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriversService {
    @Autowired
    private DriversRepository driversRepository;
}
