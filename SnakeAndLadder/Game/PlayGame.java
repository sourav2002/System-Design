package Game;

import java.util.*;

public class PlayGame {
    public static void main(String[] args) {
        Dice dice = new Dice();

        // add players in our Game
        Player p1 = new Player("Sourav" ,1);
        Player p2 = new Player("kamal" ,2);
        Player p3 = new Player("Gourav" ,3);
        Map<String, Integer> playerCurrentPosition = new HashMap<>();
        playerCurrentPosition.put("Sourav", 0);
        playerCurrentPosition.put("kamal", 0);
        playerCurrentPosition.put("Gourav", 0);

        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        allPlayers.offer(p3);

        // add snakes with start and end position
        Jumper snake1 = new Jumper(10,3);
        Jumper snake2 = new Jumper(99,30);
        Jumper snake3 = new Jumper(70,15);
        Jumper snake4 = new Jumper(50,8);
        List<Jumper> allSnakes = new ArrayList<>();
        allSnakes.add(snake1);
        allSnakes.add(snake2);
        allSnakes.add(snake3);
        allSnakes.add(snake4);

        // add all ladders with start and end points
        Jumper ladder1 = new Jumper(5,18);
        Jumper ladder2 = new Jumper(20,55);
        Jumper ladder3 = new Jumper(11,33);
        Jumper ladder4 = new Jumper(70,90);
        List<Jumper> allLadders = new ArrayList<>();
        allLadders.add(ladder1);
        allLadders.add(ladder2);
        allLadders.add(ladder3);
        allLadders.add(ladder4);


        GameBoard gb = new GameBoard(dice,allPlayers, allSnakes, allLadders, playerCurrentPosition, 100);
        gb.startGame();
    }
}
