package Game;

// using java lombok library
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode


// jumper class is used to store  snakes and ladders start and end position
public class Jumper {
    int startPoint;
    int endPoint;
    public Jumper(int start, int end){
        this.startPoint = start;
        this.endPoint = end;
    }
}
