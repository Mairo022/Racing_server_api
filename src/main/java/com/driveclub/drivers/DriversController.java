package com.driveclub.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {
    @Autowired
    private DriversService driversService;

    @GetMapping(value = "getDrivers")
    public ResponseEntity<Page<DriverDTO>> getDrivers(
            @RequestParam (required = false) String name,
            @PageableDefault (
                    page = 0,
                    size = 50,
                    sort = "money",
                    direction = Sort.Direction.DESC
            ) Pageable pageable)
    {
        return ResponseEntity.ok(driversService.getDrivers(pageable, name));
    }

    @GetMapping(value="getDriver")
    public ResponseEntity<DriverDTO> getDriver(
            @RequestParam Long id)
    {
        return ResponseEntity.ok(driversService.getDriver(id));
    }

    @PostMapping(value="saveDriver")
    public ResponseEntity<DriverDTO> saveDriver(
            @RequestBody @Validated(DriverDTO.class) DriverDTO driverDTO)
    {
        return ResponseEntity.ok(driversService.saveDriver(driverDTO));
    }
}
