package nerdy.soft.floor.layout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int first;
    private int second;
    @ManyToOne
    private Room room;

    public Coordinate(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int a) {
        this.first = a;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int b) {
        this.second = b;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public static Coordinate of(int first, int second) {
        return new Coordinate(first, second);
    }

    @Override
    public String toString() {
        return "(a=" + first + ", b=" + second + ")";
    }
}
