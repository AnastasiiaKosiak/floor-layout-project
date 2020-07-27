package nerdy.soft.floor.layout.service.impl;

import java.util.List;
import nerdy.soft.floor.layout.entity.Room;
import nerdy.soft.floor.layout.repository.RoomRepository;
import nerdy.soft.floor.layout.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room add(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> addAll(List<Room> rooms) {
        return roomRepository.saveAll(rooms);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getById(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        roomRepository.delete(roomRepository.findById(id).get());
    }
}
