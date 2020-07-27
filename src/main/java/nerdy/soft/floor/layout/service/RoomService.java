package nerdy.soft.floor.layout.service;

import java.util.List;
import nerdy.soft.floor.layout.entity.Room;

public interface RoomService {
    Room add(Room room);
    
    List<Room> addAll(List<Room> rooms);

    List<Room> getAll();

    Room getById(Long id);

    void remove(Long id);
}
