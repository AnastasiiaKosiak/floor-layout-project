package nerdy.soft.floor.layout.service;

import java.util.List;
import nerdy.soft.floor.layout.entity.dto.CoordinateDto;

public interface CoordinateValidatorService {
    boolean checkCorners(List<CoordinateDto> coordinates);

    boolean checkClockWiseDirection(List<CoordinateDto> coordinates);

    boolean checkDiagonalLine(List<CoordinateDto> coordinates);

    boolean checkNoIntersection(List<CoordinateDto> coordinates);

    boolean checkRightAngles(List<CoordinateDto> coordinates);
}
