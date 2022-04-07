package Game;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter@EqualsAndHashCode
public class Dice {
    // in case if we want more than 1 dice in our game
    private int numberOfDice;

    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }

    // default
    public Dice(){
    }

    public int rollDice(){
        return (int)(Math.random() * 6) + 1;
    }
}
