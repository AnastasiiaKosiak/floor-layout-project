package nerdy.soft.floor.layout.controller;

import nerdy.soft.floor.layout.entity.Room;
import nerdy.soft.floor.layout.service.CoordinateService;
import nerdy.soft.floor.layout.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/draw-rooms")
public class DrawRoomsController {
    private final RoomService roomService;
    private final CoordinateService coordinateService;

    public DrawRoomsController(RoomService roomService, CoordinateService coordinateService) {
        this.roomService = roomService;
        this.coordinateService = coordinateService;
    }

    @GetMapping("/{id}")
    public String drawRoom(Model model, @PathVariable String id) {
        Room room = roomService.getById(Long.parseLong(id));
        model.addAttribute("list", room.getCoordinates());
        return "drawRooms";
    }

    @GetMapping
    public String drawAllRooms(Model model) {
        model.addAttribute("list", coordinateService.getAll());
        return "drawRooms";
    }
}
