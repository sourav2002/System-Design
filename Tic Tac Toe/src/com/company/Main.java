package com.company;

public class Main {

    public static void main(String args[]) {
        PlayGame game = new PlayGame();
        game.initializeGame();
        System.out.println("game winner is: " + game.startGame());
    }
}

