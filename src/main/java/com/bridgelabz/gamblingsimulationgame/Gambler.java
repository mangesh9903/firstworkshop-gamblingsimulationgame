package com.bridgelabz.gamblingsimulationgame;

import java.util.Scanner;

public class Gambler {
    public static final int STAKE = 100;
    public static final int BET = 1;

    public static void main(String[] args) {
        Gambler gambler = new Gambler();
        Scanner scanner = new Scanner(System.in);
        System.out.println("******* Welcome to Gambler Game *******");
        while (true) {
            System.out.println("====== Menu =======");
            System.out.println("1. UC3.");
            System.out.println("2. UC4.");
            System.out.println("3. UC5.");
            System.out.println("4. UC6.");
            System.out.println("5. UC7.");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Set Limit till you want to win for 3rd Use Case ");
                    int winLimit = scanner.nextInt();
                    System.out.println("Set Limit till you can afford Lose or 3rd Use Case");
                    int loseLimit = scanner.nextInt();
                    gambler.gamePlay(winLimit, loseLimit);
                    break;
                case 2:
                    System.out.println("Set Limit till you want to win for 4th Use Case ");
                    int winLimit2 = scanner.nextInt();
                    System.out.println("Set Limit till you can afford Lose for 4th Use Case ");
                    int loseLimit2 = scanner.nextInt();
                    gambler.totalAmountCalFor20Days(winLimit2, loseLimit2);
                    break;
                case 3:
                    System.out.println("Set Limit till you want to win for 5th Use Case");
                    int winLimit3 = scanner.nextInt();
                    System.out.println("Set Limit till you can afford Lose 5th Use Case");
                    int loseLimit3 = scanner.nextInt();
                    gambler.monthlyCalculate(winLimit3, loseLimit3);
                    break;
                case 4:
                    System.out.println("Set Limit till you want to win for 6th Use Case");
                    int winLimit4 = scanner.nextInt();
                    System.out.println("Set Limit till you can afford Lose 6th Use Case");
                    int loseLimit4 = scanner.nextInt();
                    gambler.checkLuckyOrUnluckyDay(winLimit4, loseLimit4);
                    break;
                case 5:
                    System.out.println("Set Limit till you want to win for 7th Use Case");
                    int winLimit5 = scanner.nextInt();
                    System.out.println("Set Limit till you can afford Lose 7th Use Case");
                    int loseLimit5 = scanner.nextInt();
                    gambler.ifWonPlayAgain(winLimit5, loseLimit5);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

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

    /**
     * Use Case 5 ( Checking monthly Wins Or Loses And by how much. )
     *
     * @param winLimit  player will stop playing game when reaches to winLimit
     * @param loseLimit player will stop playing game when reches to loseLimit
     */
    public void monthlyCalculate(int winLimit, int loseLimit) {
        int checkWin = winLimit;
        int checkLose = loseLimit;
        int days = 30;
        int countWin = 0;
        int countLose = 0;
        int wonByHowMuch = 0;
        int loseByHowMuch = 0;
        for (int index = 0; index < days; index++) {

            int resultOfDay = gamePlay(winLimit, loseLimit);
            if (resultOfDay == checkWin) {
                wonByHowMuch = wonByHowMuch + resultOfDay;
                countWin++;
            } else if (resultOfDay == checkLose) {
                loseByHowMuch = loseByHowMuch + resultOfDay;
                countLose++;
            }
        }
        System.out.println("==================================================== Monthly Result ============================================");
        System.out.println("===================================================== In Month Total Wins  ==========================================            " + countWin);
        System.out.println("===================================================== In Month Total Loses  =========================================             " + countLose);
        System.out.println(" Won By :- " + wonByHowMuch);
        System.out.println(" Lose By :- " + loseByHowMuch);
    }

    /**
     * UseCase 6 ( Checking Luckiest Day and Unluckiest Day )
     *
     * @param winLimit  player will stop playing game when reaches to winLimit
     * @param loseLimit player will stop playing game when reches to loseLimit
     */
    public void checkLuckyOrUnluckyDay(int winLimit, int loseLimit) {
        int checkWin = winLimit;
        int checkLose = loseLimit;
        int days = 30;
        int countWin = 0;
        int countLose = 0;
        int day = 0;
        int luckiestDay = 0;
        int unLuckiestDay = 0;

        for (int index = 0; index < days; index++, day++) {

            int resultOfDay = gamePlay(winLimit, loseLimit);
            if (resultOfDay == checkWin) {
                countWin++;
                luckiestDay = day;
                System.out.println("===================================== Luckyiest Day " + luckiestDay + " ============================================================");

            } else if (resultOfDay == checkLose) {
                countLose++;
                unLuckiestDay = day;
                System.out.println("===================================== Unluckyiest Day " + unLuckiestDay + " ============================================================");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("==================================================== Monthly How Many Luckiest Days And Unluckiest Days ============================================");
        System.out.println("===================================================== In Month Luckiest Days       ====================================            " + countWin);
        System.out.println("===================================================== In Month Unluckiest Days     ====================================             " + countLose);
    }

    /**
     * UseCase 7 ( Checking IF the player Win most Time in the month then It can play again for next month
     * if not then Player Quit Game)
     *
     * @param winLimit  player will stop playing game when reaches to winLimit
     * @param loseLimit player will stop playing game when reches to loseLimit
     */

    public void ifWonPlayAgain(int winLimit, int loseLimit) {
        int checkWin = winLimit;
        int checkLose = loseLimit;
        int days = 30;
        int countWin = 0;
        int countLose = 0;
        int day = 0;
        int luckiestDay = 0;
        int unLuckiestDay = 0;

        for (int index = 0; index < days; index++, day++) {

            // UseCase  6
            int resultOfDay = gamePlay(winLimit, loseLimit);
            if (resultOfDay == checkWin) {
                countWin++;
                luckiestDay = day;
                System.out.println("===================================== Luckyiest Day " + luckiestDay + " ============================================================");

            } else if (resultOfDay == checkLose) {
                countLose++;
                unLuckiestDay = day;
                System.out.println("===================================== Unluckyiest Day " + unLuckiestDay + " ============================================================");
            }
        }

        // Use case 7
        if (unLuckiestDay < luckiestDay) {
            ifWonPlayAgain(winLimit, loseLimit);
        } else {
            System.out.println(" Finished");

        }
        System.out.println("==================================================== Monthly How Many Luckiest Days And Unluckiest Days ============================================");
        System.out.println("===================================================== In Month Luckiest Days       ====================================            " + countWin);
        System.out.println("===================================================== In Month Unluckiest Days     ====================================             " + countLose);
        System.out.println();
        System.out.println();


    }
}

