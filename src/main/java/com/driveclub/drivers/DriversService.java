package com.driveclub.drivers;

import com.driveclub.utils.ModelMapperFactory;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DriversService {
    @Autowired
    private DriversRepository driversRepository;

    public Page<DriverDTO> getDrivers(Pageable pageable, String name) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        Specification<Driver> spec = Specification.where(null);

        if (name != null) spec = spec.and((driver, cq, cb) ->
                cb.like(cb.lower(driver.get("driver")), "%" + name.toLowerCase() + "%")
        );

        return driversRepository
                .findAll(spec, pageable)
                .map(driver -> modelMapper.map(driver, DriverDTO.class));
    }

    public DriverDTO getDriver(Long id) {
        return driversRepository
                .findById(id)
                .map(driver -> ModelMapperFactory.getMapper().map(driver, DriverDTO.class))
                .orElse(null);
    }

    public DriverDTO saveDriver(DriverDTO driver) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();

        Driver savedDriver = driversRepository.findById(driver.getId())
                .map(driverDB -> {
                    modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

                    Driver driverMapped = modelMapper.map(driver, Driver.class);
                    modelMapper.map(driverMapped, driverDB);

                    // BUG: Case of field initially missing, sends value as null
                    return driversRepository.save(driverDB);
                })
                .orElse(
                        driversRepository.save(modelMapper.map(driver, Driver.class))
                );

        return modelMapper.map(savedDriver, DriverDTO.class);
    }
}
