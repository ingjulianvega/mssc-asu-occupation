package ingjulianvega.ximic.occupation.services;


import ingjulianvega.ximic.occupation.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.occupation.domain.OccupationEntity;
import ingjulianvega.ximic.occupation.domain.repositories.OccupationRepository;
import ingjulianvega.ximic.occupation.exception.OccupationException;
import ingjulianvega.ximic.occupation.web.Mappers.OccupationMapper;
import ingjulianvega.ximic.occupation.web.model.Occupation;
import ingjulianvega.ximic.occupation.web.model.OccupationDto;
import ingjulianvega.ximic.occupation.web.model.OccupationList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class OccupationServiceImpl implements OccupationService {

    private final OccupationRepository occupationRepository;
    private final OccupationMapper occupationMapper;

    @Cacheable(cacheNames = "occupationListCache", condition = "#usingCache == false")
    @Override
    public OccupationList get(Boolean usingCache) {
        log.debug("get()...");
        return OccupationList
                .builder()
                .occupationDto(occupationMapper.occupationEntityListToOccupationDtoList(occupationRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "occupationCache")
    @Override
    public OccupationDto getById(UUID id) {
        log.debug("getById()...");
        return occupationMapper.occupationEntityToOccupationDto(
                occupationRepository.findById(id).orElseThrow(() -> new OccupationException(ErrorCodeMessages.OCCUPATION_NOT_FOUND, "")));
    }

    @Override
    public void create(Occupation occupation) {
        log.debug("create()...");
        occupationMapper.occupationEntityToOccupationDto(
                occupationRepository.save(
                        occupationMapper.occupationDtoToOccupationEntity(
                                OccupationDto
                                        .builder()
                                        .name(occupation.getName()).
                                        build())));
    }

    @Override
    public void updateById(UUID id, Occupation occupation) {
        log.debug("updateById...");
        OccupationEntity occupationEntity = occupationRepository.findById(id).orElseThrow(() -> new OccupationException(ErrorCodeMessages.OCCUPATION_NOT_FOUND, ""));
        occupationEntity.setName(occupation.getName());

        occupationRepository.save(occupationEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        occupationRepository.deleteById(id);
    }
}
