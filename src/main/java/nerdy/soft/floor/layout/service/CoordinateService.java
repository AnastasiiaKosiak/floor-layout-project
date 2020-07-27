package nerdy.soft.floor.layout.service;

import java.util.List;
import nerdy.soft.floor.layout.entity.Coordinate;

public interface CoordinateService {
    Coordinate add(Coordinate coordinate);

    List<Coordinate> addAll(List<Coordinate> coordinates);

    List<Coordinate> getAll();

    void remove(List<Coordinate> coordinates);
}
