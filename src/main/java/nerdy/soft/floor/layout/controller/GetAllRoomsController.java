package nerdy.soft.floor.layout.controller;

import nerdy.soft.floor.layout.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class GetAllRoomsController {
    private final RoomService roomService;

    public GetAllRoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public String getRoomsInfo(Model model) {
        model.addAttribute("rooms", roomService.getAll());
        return "rooms";
    }
}
