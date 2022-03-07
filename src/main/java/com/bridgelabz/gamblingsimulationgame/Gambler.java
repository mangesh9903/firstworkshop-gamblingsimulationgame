package com.bridgelabz.gamblingsimulationgame;

import java.util.Scanner;

public class Gambler {
    public static final int STAKE = 100;
    public static final int BET = 1;

    public static void main(String[] args) {
        Gambler gambler = new Gambler();
        Scanner scanner = new Scanner(System.in);
        System.out.println("******* Welcome to Gambler Game *******");
        System.out.println("Set Limit till you want to win ");
        int winLimit = scanner.nextInt();
        System.out.println("Set Limit till you can afford Lose");
        int loseLimit = scanner.nextInt();
        gambler.gamePlay(winLimit, loseLimit);
        System.out.println("******* Game Finished *******");
    }

    /**
     * Usecase 2 ( Checking If player Win Or Lose )
     *
     * @return
     */
    public boolean checkWinOrLose() {
        boolean randomlyCheck = (Math.random() < 0.5);

        if (randomlyCheck) {
            System.out.println(" Congrats Player Win ");
        } else {
            System.out.println(" Player Lose ");
        }
        return randomlyCheck;
    }

    /**
     * UseCase 3 ( Checking player Win or Lose using Limits )
     *
     * @param winLimit  player will stop playing game when reaches to winLimit
     * @param loseLimit player will stop playing game when reches to loseLimit
     * @return stake    It will return the result whether player Win or Lose
     */
    public int gamePlay(int winLimit, int loseLimit) {
        int stake = 100;
        while (stake < winLimit && stake > loseLimit) {
            if (checkWinOrLose()) {
                stake = stake + 1;
                System.out.println(stake + " ");
            } else {
                stake = stake - 1;
                System.out.println(stake + " ");
            }
        }
        return stake;
    }
}
