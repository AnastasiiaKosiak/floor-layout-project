package nerdy.soft.floor.layout.mapper;

import nerdy.soft.floor.layout.entity.Coordinate;
import nerdy.soft.floor.layout.entity.dto.CoordinateDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateMapperTest {
    private final CoordinateMapper mapper = new CoordinateMapper();

    @Test
    public void checkConvertFromCoordinateToDto() {
        CoordinateDto expected = CoordinateDto.of(2, 3);
        CoordinateDto actual = mapper.convertFromCoordinateToDto(Coordinate.of(2, 3));
        assertEquals(expected, actual);
    }

}
