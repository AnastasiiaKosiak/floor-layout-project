package nerdy.soft.floor.layout.mapper;

import nerdy.soft.floor.layout.entity.Coordinate;
import nerdy.soft.floor.layout.entity.dto.CoordinateDto;
import org.springframework.stereotype.Component;

@Component
public class CoordinateMapper {
    public Coordinate convertFromDtoToCoordinate(CoordinateDto dto) {
        return new Coordinate(dto.getFirst(), dto.getSecond());
    }

    public CoordinateDto convertFromCoordinateToDto(Coordinate coordinate) {
        return CoordinateDto.of(coordinate.getFirst(), coordinate.getSecond());
    }
}
