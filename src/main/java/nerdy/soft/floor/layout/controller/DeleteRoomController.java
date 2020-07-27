package nerdy.soft.floor.layout.controller;

import nerdy.soft.floor.layout.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete")
public class DeleteRoomController {
    private final RoomService roomService;

    public DeleteRoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public String deleteRoom(Model model, @PathVariable String id) {
        roomService.remove(Long.parseLong(id));
        model.addAttribute("rooms", roomService.getAll());
        return "rooms";
    }
}
