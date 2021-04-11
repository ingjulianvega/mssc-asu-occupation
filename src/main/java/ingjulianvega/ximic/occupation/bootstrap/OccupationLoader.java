package ingjulianvega.ximic.occupation.bootstrap;


import ingjulianvega.ximic.occupation.domain.OccupationEntity;
import ingjulianvega.ximic.occupation.domain.repositories.OccupationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class OccupationLoader implements CommandLineRunner {

    private final OccupationRepository occupationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (occupationRepository.count() == 0) {
            loadOccupationObjects();
        }
    }

    private void loadOccupationObjects() {
        occupationRepository.saveAll(Arrays.asList(
                OccupationEntity.builder().name("Carpintero").build(),
                OccupationEntity.builder().name("Lechero").build(),
                OccupationEntity.builder().name("Frutero").build(),
                OccupationEntity.builder().name("Cerrajero").build(),
                OccupationEntity.builder().name("Cocinero").build(),
                OccupationEntity.builder().name("Mecánico").build(),
                OccupationEntity.builder().name("Lavandero").build(),
                OccupationEntity.builder().name("Artesano").build(),
                OccupationEntity.builder().name("Pescador").build(),
                OccupationEntity.builder().name("Escultor").build(),
                OccupationEntity.builder().name("Albañil").build(),
                OccupationEntity.builder().name("Editor").build(),
                OccupationEntity.builder().name("Barrendero").build(),
                OccupationEntity.builder().name("Fontanero o plomero").build(),
                OccupationEntity.builder().name("Obrero").build(),
                OccupationEntity.builder().name("Panadero").build(),
                OccupationEntity.builder().name("Locutor").build(),
                OccupationEntity.builder().name("Barbero").build(),
                OccupationEntity.builder().name("Soldador").build(),
                OccupationEntity.builder().name("Escritor").build(),
                OccupationEntity.builder().name("Leñador").build(),
                OccupationEntity.builder().name("Pintor de brocha gorda").build(),
                OccupationEntity.builder().name("Vendedor").build(),
                OccupationEntity.builder().name("Sastre").build(),
                OccupationEntity.builder().name("Repartidor").build(),
                OccupationEntity.builder().name("Impresor").build(),
                OccupationEntity.builder().name("Pastor ganadero").build(),
                OccupationEntity.builder().name("Cajero").build(),
                OccupationEntity.builder().name("Policía").build(),
                OccupationEntity.builder().name("Agricultor").build(),
                OccupationEntity.builder().name("Vigilante").build(),
                OccupationEntity.builder().name("Exterminador").build(),
                OccupationEntity.builder().name("Carnicero").build(),
                OccupationEntity.builder().name("Animador").build(),
                OccupationEntity.builder().name("Peluquero").build(),
                OccupationEntity.builder().name("Chofer o conductor").build(),
                OccupationEntity.builder().name("Otro").build()
        ));
    }
}
