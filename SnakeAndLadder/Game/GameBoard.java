package Game;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {

    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String, Integer> playerCurrentPosition;
    int boardSize;

    public GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders,Map<String,Integer> playerCurrentPosition,int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
    }

//    this is the main method to start our game
    public void startGame(){

        // while we have more than one player in our queue
        while (nextTurn.size() > 1){
            Player currentPlayer = nextTurn.poll();
            System.out.println();
            System.out.print(currentPlayer.getPlayerName() +"'s turn ..(press Enter key)");
            int diceValue = 0;
            Scanner scanner = new Scanner(System.in);
            String readString = scanner.nextLine();
            while(!readString.isEmpty()){
                System.out.print("Please press Enter key to roll the dice");
                readString = scanner.nextLine();
            }
            diceValue = dice.rollDice();
            System.out.println(currentPlayer.getPlayerName()+ " got a " + diceValue + " on dice rolling" );
            int currentPosition = playerCurrentPosition.get(currentPlayer.getPlayerName()); // get the position from hashmap by key(name)
            int nextCell = currentPosition + diceValue;
            if (nextCell > boardSize) nextTurn.offer(currentPlayer); // dice number should be exact to make 100 if it makes 101 then it is not valid
            else if (nextCell == boardSize) { // win condition
                System.out.println( currentPlayer.getPlayerName() + " won the game");
            }else{
                // here we are using array to store next position for easily checking snakes and ladders positions
                int[] nextPosition= new int[1];
                boolean[] b =new boolean[1]; // used for if we get ladder

                nextPosition[0]= nextCell;
                // check if snake is there at nextCell position
                snakes.forEach(v-> {
                    if(v.startPoint==nextCell) {
                        nextPosition[0] = v.endPoint;
                    } } );
                // if yes(snake is there) print alert and update next position for that player
                if(nextPosition[0] != nextCell) System.out.println(currentPlayer.getPlayerName() + " Bitten by Snake present at: "+ nextCell);
                // check if we got a ladder
                ladders.forEach(v-> {
                    if(v.startPoint==nextCell) {
                        nextPosition[0] = v.endPoint;
                        b[0]=true;
                    } } );
                // if yes then update position of current player
                if(nextPosition[0] != nextCell && b[0]) System.out.println(currentPlayer.getPlayerName() + " Got ladder present at: "+ nextCell);

                if(nextPosition[0] == boardSize){
                    System.out.println(currentPlayer.getPlayerName() + " won the game. Hoorayy!");
                    // no need to insert that player in the queue again
                }else{
                    playerCurrentPosition.put(currentPlayer.getPlayerName(),nextPosition[0]);
                    System.out.println(currentPlayer.getPlayerName() + " is at position "+ nextPosition[0]);

                    // at the end, put this current player in the queue again if he doesn't win the game
                    nextTurn.offer(currentPlayer);
                }
            }
        }

        System.out.println(nextTurn.poll().getPlayerName() + " Lose this game");
    }
}
