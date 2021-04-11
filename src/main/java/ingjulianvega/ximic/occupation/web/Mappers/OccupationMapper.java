package ingjulianvega.ximic.occupation.web.Mappers;


import ingjulianvega.ximic.occupation.domain.OccupationEntity;
import ingjulianvega.ximic.occupation.web.model.OccupationDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface OccupationMapper {
    OccupationDto occupationEntityToOccupationDto(OccupationEntity occupationEntity);

    OccupationEntity occupationDtoToOccupationEntity(OccupationDto occupationDto);

    ArrayList<OccupationDto> occupationEntityListToOccupationDtoList(List<OccupationEntity> occupationEntityList);
}
