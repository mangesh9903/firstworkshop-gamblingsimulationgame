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
        System.out.println();
        System.out.println("===================================================================================================       Use Case 3 Finished     ===================================================================================================");
        System.out.println("Set Limit till you want to win ");
        int winLimitt = scanner.nextInt();
        System.out.println("Set Limit till you can afford Lose");
        int loseLimitt = scanner.nextInt();
        gambler.totalAmountCalFor20Days(winLimitt, loseLimitt);
        System.out.println("******* Game Finished *******");
    }

    /**
     * Usecase 2 ( Checking If player Win Or Lose )
     *
     * @return result whether Player Win Or Lose using random function
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

    /**
     * UseCase 4 ( Calculating 20 Days Result by checking Player Win Or Lose )
     *
     * @param winLimit  player will stop playing game when reaches to winLimit
     * @param loseLimit player will stop playing game when reches to loseLimit
     */
    public void totalAmountCalFor20Days(int winLimit, int loseLimit) {
        int checkWin = winLimit;
        int checkLose = loseLimit;
        int days = 20;
        int countWin = 0;
        int countLose = 0;
        for (int index = 0; index < days; index++) {

            int resultOfDay = gamePlay(winLimit, loseLimit);
            if (resultOfDay == checkWin) {
                countWin++;
            } else if (resultOfDay == checkLose) {
                countLose++;
            }
        }
        System.out.println(":==================================================== Total 20 Days Result ============================================");
        System.out.println("===================================================== In 20 Days Total Wins  ==========================================            " + countWin);
        System.out.println("===================================================== In 20 Days Total Loses  =========================================             " + countLose);
    }

}

