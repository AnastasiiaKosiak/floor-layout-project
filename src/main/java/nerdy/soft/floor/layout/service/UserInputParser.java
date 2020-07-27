package nerdy.soft.floor.layout.service;

import java.util.List;
import nerdy.soft.floor.layout.entity.dto.CoordinateDto;

public interface UserInputParser {
    List<CoordinateDto> getCoordinatesFromInput(String input);
}
