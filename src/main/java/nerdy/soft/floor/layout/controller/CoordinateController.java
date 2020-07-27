package nerdy.soft.floor.layout.controller;

import java.util.List;
import java.util.stream.Collectors;
import nerdy.soft.floor.layout.entity.Coordinate;
import nerdy.soft.floor.layout.entity.Room;
import nerdy.soft.floor.layout.entity.dto.CoordinateDto;
import nerdy.soft.floor.layout.entity.dto.InputFormDto;
import nerdy.soft.floor.layout.exception.InvalidCoordinatesException;
import nerdy.soft.floor.layout.mapper.CoordinateMapper;
import nerdy.soft.floor.layout.service.CoordinateService;
import nerdy.soft.floor.layout.service.CoordinateValidatorService;
import nerdy.soft.floor.layout.service.RoomService;
import nerdy.soft.floor.layout.service.UserInputParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coordinates")
public class CoordinateController {
    private final UserInputParser parser;
    private final CoordinateValidatorService validator;
    private final CoordinateMapper coordinateMapper;
    private final CoordinateService coordinateService;
    private final RoomService roomService;

    public CoordinateController(UserInputParser parser,
                                CoordinateValidatorService validator,
                                CoordinateMapper coordinateMapper,
                                CoordinateService coordinateService,
                                RoomService roomService) {
        this.parser = parser;
        this.validator = validator;
        this.coordinateMapper = coordinateMapper;
        this.coordinateService = coordinateService;
        this.roomService = roomService;
    }

    @GetMapping("/add")
    public String getInputForm(Model model) {
        model.addAttribute("input", new InputFormDto());
        return "addCoordinates";
    }

    @PostMapping("/add")
    public String processUserInput(@ModelAttribute(value = "input") InputFormDto input) {
        String coordinateString = input.getInput();
        List<CoordinateDto> coordinateDtos = parser.getCoordinatesFromInput(coordinateString);
        if (isValidCoordinates(coordinateDtos)) {
            List<Coordinate> coordinates = coordinateDtos.stream()
                    .map(coordinateMapper::convertFromDtoToCoordinate)
                    .collect(Collectors.toList());
            createRoom(coordinates);
        } else {
            throw new InvalidCoordinatesException("invalid coordinates");
        }
        return "index";
    }

    private boolean isValidCoordinates(List<CoordinateDto> coordinateDtos) {
        return validator.checkClockWiseDirection(coordinateDtos)
                && validator.checkCorners(coordinateDtos)
                && validator.checkDiagonalLine(coordinateDtos)
                && validator.checkNoIntersection(coordinateDtos)
                && validator.checkRightAngles(coordinateDtos);
    }

    private void createRoom(List<Coordinate> coordinates) {
        coordinateService.addAll(coordinates);
        Room room = new Room();
        room.setCoordinates(coordinates);
        roomService.add(room);
    }

    @ExceptionHandler(InvalidCoordinatesException.class)
    public String handleInvalidCoordinatesError() {
        return "showError";
    }
}
