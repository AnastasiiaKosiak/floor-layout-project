package nerdy.soft.floor.layout.service.impl;

import java.util.List;
import nerdy.soft.floor.layout.entity.Coordinate;
import nerdy.soft.floor.layout.repository.CoordinateRepository;
import nerdy.soft.floor.layout.service.CoordinateService;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements CoordinateService {
    private final CoordinateRepository coordinateRepository;

    public CoordinateServiceImpl(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    @Override
    public Coordinate add(Coordinate coordinate) {
        return coordinateRepository.save(coordinate);
    }

    @Override
    public List<Coordinate> addAll(List<Coordinate> coordinates) {
        return coordinateRepository.saveAll(coordinates);
    }

    @Override
    public List<Coordinate> getAll() {
        return coordinateRepository.findAll();
    }

    @Override
    public void remove(List<Coordinate> coordinates) {
        coordinateRepository.deleteAll(coordinates);
    }
}
