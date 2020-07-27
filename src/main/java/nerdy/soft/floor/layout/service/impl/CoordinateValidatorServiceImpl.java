package nerdy.soft.floor.layout.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nerdy.soft.floor.layout.entity.dto.CoordinateDto;
import nerdy.soft.floor.layout.service.CoordinateValidatorService;
import org.springframework.stereotype.Service;

@Service
public class CoordinateValidatorServiceImpl implements CoordinateValidatorService {
    private static final int MIN_COORDINATES_NUM = 4;

    @Override
    public boolean checkCorners(List<CoordinateDto> coordinates) {
        return coordinates.size() >= MIN_COORDINATES_NUM;
    }

    @Override
    public boolean checkClockWiseDirection(List<CoordinateDto> coordinates) {
        int sum = 0;
        for (int i = 1; i < coordinates.size(); i++) {
            sum += (coordinates.get(i).getFirst() - coordinates.get(i - 1).getFirst())
                    * (coordinates.get(i).getSecond() + coordinates.get(i - 1).getSecond());
        }
        return sum >= 0;
    }

    @Override
    public boolean checkDiagonalLine(List<CoordinateDto> coordinates) {
        for (int i = 1; i < coordinates.size(); i++) {
            if (Math.abs(coordinates.get(i).getFirst() - coordinates.get(i - 1).getFirst())
                    == (Math.abs(coordinates.get(i).getSecond()
                    - coordinates.get(i - 1).getSecond()))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkNoIntersection(List<CoordinateDto> coordinates) {
        Set<CoordinateDto> coordinatesSet = new HashSet<>();
        for (CoordinateDto coordinate : coordinates) {
            if (!coordinatesSet.add(coordinate)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkRightAngles(List<CoordinateDto> coordinates) {
        if (coordinates.get(coordinates.size() - 1).getSecond() != coordinates.get(0).getSecond()) {
            return false;
        }
        for (int i = 2; i < coordinates.size() - 1; i += 2) {
            if (coordinates.get(i).getSecond() != coordinates.get(i - 1).getSecond()) {
                return false;
            }
        }
        return true;
    }
}
