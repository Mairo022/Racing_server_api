package com.driveclub.endpoints.stats;

import com.driveclub.utils.ModelMapperFactory;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    @Autowired
    private StatsRepository statsRepository;

    public Page<StatDTO> getStats(Pageable pageable, String track, String car) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        Specification<Stat> spec = Specification.where(null);

        if (track != null) spec = spec.and((stat, cq, cb) ->
                cb.like(cb.lower(stat.get("track")), "%" + track.toLowerCase() + "%")
        );
        if (car != null) spec = spec.and((stat, cq, cb) ->
                cb.like(cb.lower(stat.get("car")), "%" + car.toLowerCase() + "%")
        );

        return statsRepository
                .findAll(spec, pageable)
                .map(stat -> modelMapper.map(stat, StatDTO.class));
    }

    public StatDTO getStat(Long id) {
        return statsRepository
                .findById(id)
                .map(stat -> ModelMapperFactory.getMapper().map(stat, StatDTO.class))
                .orElse(null);
    }

    public StatDTO saveStat(StatDTO stat) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();

        Stat savedStat = statsRepository.findById(stat.getId())
                .map(statDB -> {
                    modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

                    Stat statMapped = modelMapper.map(stat, Stat.class);
                    modelMapper.map(statMapped, statDB);

                    return statsRepository.save(statDB);
                })
                .orElse(
                        statsRepository.save(modelMapper.map(stat, Stat.class))
                );

        return modelMapper.map(savedStat, StatDTO.class);
    }

    public void deleteStat(Long id) {
        statsRepository.deleteById(id);
    }
}
