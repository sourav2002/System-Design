package Game;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Player {
    private String playerName;
    private int playerId;
    public Player(String playerName, int playerId){
        this.playerName = playerName;
        this.playerId = playerId;
    }
}
