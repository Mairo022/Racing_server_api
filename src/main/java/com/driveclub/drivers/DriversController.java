package com.driveclub.drivers;

import com.driveclub.logs.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {
    @Autowired
    private DriversService driversService;
}
