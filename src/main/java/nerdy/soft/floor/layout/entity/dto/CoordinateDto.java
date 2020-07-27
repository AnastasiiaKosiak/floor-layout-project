package nerdy.soft.floor.layout.entity.dto;

import lombok.Data;

@Data
public class CoordinateDto {
    private int first;
    private int second;

    public CoordinateDto(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public static CoordinateDto of(int first, int second) {
        return new CoordinateDto(first, second);
    }
}
