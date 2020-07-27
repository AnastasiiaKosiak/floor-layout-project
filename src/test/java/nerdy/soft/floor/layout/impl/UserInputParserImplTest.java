package nerdy.soft.floor.layout.impl;

import nerdy.soft.floor.layout.entity.dto.CoordinateDto;
import nerdy.soft.floor.layout.service.UserInputParser;
import nerdy.soft.floor.layout.service.impl.UserInputParserImpl;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInputParserImplTest {
    private final UserInputParser parser = new UserInputParserImpl();

    @Test
    public void checkParsing() {
        String input = "1234";
        List<CoordinateDto> expected = List.of(CoordinateDto.of(1, 2), CoordinateDto.of(3, 4));
        List<CoordinateDto> actual = parser.getCoordinatesFromInput(input);
        assertEquals(expected, actual);
    }
}
