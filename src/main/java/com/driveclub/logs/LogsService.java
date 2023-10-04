package com.driveclub.logs;

import com.driveclub.utils.ModelMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


@Service
public class LogsService {
    @Autowired
    private LogsRepository logsRepository;

    public Page<LogDTO> getLogs(Pageable pageable) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();

        return logsRepository
                .findAll(pageable)
                .map(log -> modelMapper.map(log, LogDTO.class));
    }

    public LogDTO saveLog(LogDTO log) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        Log savedLog = logsRepository.save(modelMapper.map(log, Log.class));

        return modelMapper.map(savedLog, LogDTO.class);
    }

    public void deleteLog(Long id) {
        logsRepository.deleteById(id);
    }
}
