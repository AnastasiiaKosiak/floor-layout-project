package nerdy.soft.floor.layout.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nerdy.soft.floor.layout.entity.dto.CoordinateDto;
import nerdy.soft.floor.layout.service.UserInputParser;
import org.springframework.stereotype.Service;

@Service
public class UserInputParserImpl implements UserInputParser {
    private static final int STRING_LENGTH_FACTOR = 2;

    @Override
    public List<CoordinateDto> getCoordinatesFromInput(String input) {
        if (input.length() == 0) {
            return Collections.emptyList();
        }
        String[] digits = input.replaceAll("[^0-9]", "")
                .split("");
        if (digits.length % STRING_LENGTH_FACTOR != 0) {
            return Collections.emptyList();
        }
        List<CoordinateDto> coordinates = new ArrayList<>();
        for (int i = 0; i < digits.length; i += 2) {
            coordinates.add(CoordinateDto.of(Integer.parseInt(digits[i]),
                    Integer.parseInt(digits[i + 1])));
        }
        return coordinates;
    }
}
