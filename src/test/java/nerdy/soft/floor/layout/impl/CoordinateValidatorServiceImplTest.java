package nerdy.soft.floor.layout.impl;

import nerdy.soft.floor.layout.entity.dto.CoordinateDto;
import nerdy.soft.floor.layout.service.CoordinateValidatorService;
import nerdy.soft.floor.layout.service.impl.CoordinateValidatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;


class CoordinateValidatorServiceImplTest {
    private final CoordinateValidatorService validator = new CoordinateValidatorServiceImpl();

    @Test
    public void checkDirection() {
        boolean expected = false;
        List<CoordinateDto> list = List.of(CoordinateDto.of(1, 1), CoordinateDto.of(1, 2),
                CoordinateDto.of(2, 2), CoordinateDto.of(0, 1));
        boolean actual = validator.checkClockWiseDirection(list);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkDiagonal() {
        boolean expected = false;
        List<CoordinateDto> list = List.of(CoordinateDto.of(1, 1), CoordinateDto.of(2, 2));
        boolean actual = validator.checkDiagonalLine(list);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkNoIntersection() {
        boolean expected = false;
        List<CoordinateDto> list = List.of(CoordinateDto.of(1, 1), CoordinateDto.of(2, 2),
                CoordinateDto.of(1, 1));
        boolean actual = validator.checkNoIntersection(list);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkRightAngles() {
        boolean expected = true;
        List<CoordinateDto> coordinates = List.of(CoordinateDto.of(1,1), CoordinateDto.of(1,2),
                CoordinateDto.of(0,2), CoordinateDto.of(0,3),
                CoordinateDto.of(2,3), CoordinateDto.of(2,1));
        boolean actual = validator.checkRightAngles(coordinates);
        Assertions.assertEquals(expected, actual);
    }

}
