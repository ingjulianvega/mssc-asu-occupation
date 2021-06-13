package ingjulianvega.ximic.occupation.web.controller;


import ingjulianvega.ximic.occupation.services.OccupationService;
import ingjulianvega.ximic.occupation.web.model.Occupation;
import ingjulianvega.ximic.occupation.web.model.OccupationDto;
import ingjulianvega.ximic.occupation.web.model.OccupationList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OccupationController implements OccupationI {
    private final OccupationService occupationService;

    @Override
    public ResponseEntity<OccupationList> get(Boolean usingCache) {
        return new ResponseEntity<>(occupationService.get(usingCache), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OccupationDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(occupationService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Occupation occupation) {
        occupationService.create(occupation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Occupation occupation) {
        occupationService.updateById(id, occupation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        occupationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}