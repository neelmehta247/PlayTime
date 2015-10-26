/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtime;

/**
 *
 * @author neel
 */
import java.util.Random;
import java.util.Scanner;

class SnakesAndLadders {

    static Scanner s = new Scanner(System.in);
    String name, thrash;
    Random r = new Random();
    static Game g = new Game();
    static Resources tool = new Resources();
    static int pPos = 0, cPos = 0, oldIntP = 0, oldIntC = 0, pDice, cDice,
            rValP = 0, cValP = 0, rValC = 0, cValC = 0, choice, flag = 0;
    static SnakesAndLadders sal = new SnakesAndLadders();
    /*
     * 0-Normal 1-Ladder Piece 2-Snake Head 3-Snake Body 4-Player 5-Computer
     */
    int[][] board = {{0, 3, 1, 0, 0, 0, 0, 0, 0, 0},
    {0, 3, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 3, 1, 0, 0, 0, 1, 0, 0, 0},
    {0, 3, 1, 3, 1, 0, 1, 3, 0, 0}, {0, 2, 1, 3, 1, 0, 1, 3, 0, 3},
    {0, 0, 1, 3, 1, 0, 0, 3, 0, 3}, {0, 0, 1, 3, 1, 0, 0, 3, 0, 2},
    {0, 0, 1, 2, 0, 1, 0, 3, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 3, 0, 0},
    {0, 0, 0, 0, 0, 1, 0, 2, 0, 0}};
    int[][] brdFrmt = {{01, 02, 03, 04, 05, 06, 07, 8, 9, 10},
    {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
    {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
    {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
    {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
    {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
    {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
    {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
    {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
    {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}};

    public void printFRMT() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j < 9) {
                    System.out.print(" ");
                }
                System.out.print(brdFrmt[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public void play() {
        System.out.println("Player 1 enter your name");
        name = s.nextLine();
        System.out.println("If you are ready press enter");
        thrash = s.nextLine();
        tool.countdown(3);
        tool.delay(1);
        pPos = 0;
        cPos = 0;
        System.out.println("\f");
        while (pPos != 100 && cPos != 100) {
            System.out.println("\f");
            System.out.println("This is how it looks");
            printBrd();
            tool.delay(1);
            System.out.println("Enter 0 to exit the game \nor");
            System.out.println("Press Enter to Roll the Dice");
            thrash = s.nextLine();
            if (thrash.equals("0")) {
                break;
            }
            pDice = r.nextInt(6);
            pDice++;
            cDice = r.nextInt(6);
            cDice++;
            System.out.println(name + " rolled a " + pDice);
            tool.delay(1.5);
            pPos += pDice;
            cPos += cDice;
            if (pPos > 100) {
                System.out.println(name + " went over 100.....");
                pPos -= pDice;
                tool.delay(1.5);
            }
            if (pPos == 3) {
                System.out.println(name + " found a ladder!!!");
                System.out.println(name + " climbed up from 3 to 83");
                pPos = 83;
                tool.delay(1.5);
            } else if (pPos == 35) {
                System.out.println(name + " found a ladder!!!");
                System.out.println(name + " climbed up from 35 to 65");
                pPos = 65;
                tool.delay(1.5);
            } else if (pPos == 76) {
                System.out.println(name + " found a ladder!!!");
                System.out.println(name + " climbed up from 76 to 96");
                pPos = 96;
                tool.delay(1.5);
            } else if (pPos == 27) {
                System.out.println(name + " found a ladder!!!");
                System.out.println(name + " climbed up from 27 to 47");
                pPos = 47;
                tool.delay(1.5);
            } else if (pPos == 42) {
                System.out.println(name + " was bit by a snake...");
                System.out
                        .println(name + " fell down all the way from 42 to 2");
                pPos = 2;
                tool.delay(1.5);
            } else if (pPos == 74) {
                System.out.println(name + " was bit by a snake...");
                System.out.println(name
                        + " fell down all the way from 74 to 34");
                pPos = 34;
                tool.delay(1.5);
            } else if (pPos == 98) {
                System.out.println(name + " was bit by a snake...");
                System.out.println(name
                        + " fell down all the way from 98 to 38");
                pPos = 38;
                tool.delay(1.5);
            } else if (pPos == 70) {
                System.out.println(name + " was bit by a snake...");
                System.out.println(name
                        + " fell down all the way from 70 to 50");
                pPos = 50;
                tool.delay(1.5);
            }
            System.out.println(name + " is at " + pPos);
            board[rValP][cValP] = oldIntP;
            rValP = pPos / 10;
            cValP = pPos % 10 - 1;
            if (cValP == -1) {
                rValP--;
                cValP = 9;
            }
            oldIntP = board[rValP][cValP];
            if (pPos == 100) {
                System.out.println("\n\t\tCongratulations " + name
                        + "!!!!!!!! \n\t\t  You have won");
                tool.delay(2);
                break;
            }
            tool.delay(3);
            System.out.println("Computer rolled a " + cDice);
            board[rValC][cValC] = oldIntC;
            tool.delay(1.5);
            if (cPos > 100) {
                System.out.println("Computer went over 100.....");
                cPos -= cDice;
                tool.delay(1.5);
            }
            if (cPos == 3) {
                System.out.println("Computer has found a ladder!!!");
                System.out.println("Computer climbed up from 3 to 83");
                cPos = 83;
                tool.delay(1.5);
            } else if (cPos == 35) {
                System.out.println("Computer has found a ladder!!!");
                System.out.println("Computer climbed up from 35 to 65");
                cPos = 65;
                tool.delay(1.5);
            } else if (cPos == 76) {
                System.out.println("Computer has found a ladder!!!");
                System.out.println("Computer climbed up from 76 to 96");
                cPos = 96;
                tool.delay(1.5);
            } else if (cPos == 27) {
                System.out.println("Computer has found a ladder!!!");
                System.out.println("Computer climbed up from 27 to 47");
                cPos = 47;
                tool.delay(1.5);
            } else if (cPos == 42) {
                System.out.println("Computer was bit by a snake...");
                System.out
                        .println("Computer fell down all the way from 42 to 2");
                cPos = 2;
                tool.delay(1.5);
            } else if (cPos == 74) {
                System.out.println("Computer was bit by a snake...");
                System.out
                        .println("Computer fell down all the way from 74 to 34");
                cPos = 34;
                tool.delay(1.5);
            } else if (cPos == 98) {
                System.out.println("Computer was bit by a snake...");
                System.out
                        .println("Computer fell down all the way from 98 to 38");
                cPos = 38;
                tool.delay(1.5);
            } else if (cPos == 70) {
                System.out.println("Computer was bit by a snake...");
                System.out
                        .println("Computer fell down all the way from 70 to 50");
                cPos = 50;
                tool.delay(1.5);
            }
            System.out.println("Computer is at " + cPos);
            rValC = cPos / 10;
            cValC = cPos % 10 - 1;
            if (cValC == -1) {
                rValC--;
                cValC = 9;
            }
            oldIntC = board[rValC][cValC];
            board[rValP][cValP] = 4;
            board[rValC][cValC] = 5;
            tool.delay(1);
            if (cPos == 100) {
                System.out
                        .println("\n\t\tComputer Wins....\n\t  Better luck next time");
                tool.delay(2);
            }
        }
        System.out.println("Press enter when ready to continue");
        thrash = s.nextLine();
        SnakesAndLadders.main(null);
    }

    public void beginPlay() {
        System.out.println("\f");
        System.out
                .println("Before you start playing here are the things that you should know....");
        tool.delay(2);
        System.out
                .println("Firstly this is the way you will be progressing throught the board...");
        tool.delay(2);
        printFRMT();
        tool.delay(2.5);
        System.out
                .println("Further on this is how the board looks with the Snakes and the Ladders on it");
        tool.delay(2);
        printBrd();
        System.out
                .println("Keep in mind that the \"----@\" is the snake and the \"l-l\" is the ladder...");
        tool.delay(2.5);
        System.out
                .println("Now that you are know the essential things you are ready to play!!!");
        tool.delay(2);
        System.out.println("Press enter when you are ready to proceed");
        thrash = s.nextLine();
    }

    public static void main(String[] args) {
        do {
            flag = 0;
            System.out.println("\f");
            System.out
                    .println("      _____                   _                 ");
            tool.delay(0.125);
            System.out
                    .println("     / ____|                 | |                ");
            tool.delay(0.125);
            System.out
                    .println("    | (___    _ __     __ _  | | __   ___   ___ ");
            tool.delay(0.125);
            System.out
                    .println("     \\___ \\  | '_ \\   / _` | | |/ /  / _ \\ / __|");
            tool.delay(0.125);
            System.out
                    .println("     ____) | | | | | | (_| | |   <  |  __/ \\__ \\");
            tool.delay(0.125);
            System.out
                    .println("    |_____/  |_| |_|  \\__,_| |_|\\_\\  \\___| |___/");
            tool.delay(0.125);
            System.out.println("                                      _  ");
            tool.delay(0.125);
            System.out.println("                  /\\                 | | ");
            tool.delay(0.125);
            System.out.println("                 /  \\     _ __     __| | ");
            tool.delay(0.125);
            System.out.println("                / /\\ \\   | '_ \\   / _` |");
            tool.delay(0.125);
            System.out.println("               / ____ \\  | | | | | (_| | ");
            tool.delay(0.125);
            System.out.println("              /_/    \\_\\ |_| |_|  \\__,_| ");
            tool.delay(0.125);
            System.out
                    .println("  _                    _       _                     ");
            tool.delay(0.125);
            System.out
                    .println(" | |                  | |     | |                    ");
            tool.delay(0.125);
            System.out
                    .println(" | |        __ _    __| |   __| |   ___   _ __   ___ ");
            tool.delay(0.125);
            System.out
                    .println(" | |       / _` |  / _` |  / _` |  / _ \\ | '__| / __|");
            tool.delay(0.125);
            System.out
                    .println(" | |____  | (_| | | (_| | | (_| | |  __/ | |    \\__ \\");
            tool.delay(0.125);
            System.out
                    .println(" |______|  \\__,_|  \\__,_|  \\__,_|  \\___| |_|    |___/");
            tool.delay(0.125);
            System.out.println();
            System.out.println(" 1. Play Snakes and Ladders");
            System.out.println(" 2. Instructions");
            System.out.println(" 3. Go Back to previous menu");
            System.out.println(" Make your Choice ");
            try {
                System.out.print(" Choice : ");
                choice = Integer.parseInt(s.next());
            } catch (NumberFormatException nfe) {
                flag = 1;
            }
            if (flag == 1) {
                System.out.println("\f");
                System.out.println("\t\tEnter a number please...");
                tool.delay(2);
            }
            switch (choice) {
                case 1:
                    sal.beginPlay();
                    System.out.println("\f");
                    sal.play();
                    break;
                case 2:
                    sal.instr();
                    break;
                case 3:
                    System.out.println("\f\t\tDo enjoy the other games....");
                    tool.delay(2);
                    g.main(null);
                    break;
                default:
                    System.out
                            .println("Invalid Option\n Enter a number between 1 and 3");
            }
        } while (choice != 3);
    }

    public void instr() {
        System.out.println("\f");
        System.out
                .println("-------------------------Instructions-------------------------");
        System.out.println();
        System.out
                .println("1. Snakes and Ladders is a simple board game where the main objective\n\tis to reach the 100 mark before your opponent does");
        System.out.println();
        tool.delay(2);
        System.out.println("2. To roll the dice press enter");
        System.out.println();
        tool.delay(2);
        System.out
                .println("3. You will be able to check your progress in comparision to your opponent \n\tin the board that is printed..");
        System.out.println();
        tool.delay(2);
        System.out.println("4. Reach 100 before the computer");
        System.out.println();
        tool.delay(2);
        System.out.println("5. If you win then celebrate!!!!!");
        System.out.println();
        tool.delay(2);
        System.out
                .println("6. If you lose then dont worry and try again for sure... You may win next time");
        System.out.println();
        tool.delay(2);
        System.out
                .println("That is all the instructions you need to play this addicting and fun-filled game....\n Enjoy");
        System.out.println();
        tool.delay(2);
        System.out.println("When you are done reading press enter");
        thrash = s.nextLine();
        thrash = s.nextLine();
        SnakesAndLadders.main(null);
    }

    public void printBrd() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                switch (board[i][j]) {
                    case 0:
                        a = " |_| ";
                        break;
                    case 1:
                        a = " l-l ";
                        break;
                    case 2:
                        a = "  @  ";
                        break;
                    case 3:
                        a = "  |  ";
                        break;
                    case 4:
                        a = name.substring(0, 1);
                        a = a.toUpperCase();
                        a = "  " + a + "  ";
                        break;
                    case 5:
                        a = "  C  ";
                        break;
                }
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
