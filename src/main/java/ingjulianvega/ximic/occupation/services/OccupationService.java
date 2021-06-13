package ingjulianvega.ximic.occupation.services;



import ingjulianvega.ximic.occupation.web.model.Occupation;
import ingjulianvega.ximic.occupation.web.model.OccupationDto;
import ingjulianvega.ximic.occupation.web.model.OccupationList;

import java.util.UUID;

public interface OccupationService {
    OccupationList get(Boolean usingCache);

    OccupationDto getById(UUID id);

    void create(Occupation occupation);

    void updateById(UUID id, Occupation occupation);

    void deleteById(UUID id);
}
