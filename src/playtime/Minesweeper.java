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

class Minesweeper {

    int bombs, row, col, crtm = 0, state = 0;
    static int choice;
    char prox = '0';
    char real[][] = new char[5][5];
    char toShow[][] = new char[5][5];
    double[] hSVal = {999999999, 999999999, 999999999, 999999999, 999999999,
        999999999, 999999999, 999999999, 999999999, 999999999};
    String[] highScore = {"", "", "", "", "", "", "", "", "", ""};
    static String name, thrash;
    static Minesweeper mine = new Minesweeper();
    static Scanner s = new Scanner(System.in);
    Random r = new Random();
    static double runTime, startTime;
    static Game g = new Game();
    static Resources tool = new Resources();

    public int highScr() {
        int flag = 0;
        runTime /= Math.pow(10, 6);
        runTime = Math.rint(runTime);
        runTime /= 1000;
        for (int i = 0; i < 10; i++) {
            if (state == 1) {
                if (runTime < hSVal[i]) {
                    System.out.println("Your score has got you at position : "
                            + (i + 1) + " in your leaderboard");
                    flag = 1;
                    break;
                }
            }
        }
        return flag;
    }

    public void highScr(String a) {
        System.out.println("\f");
        int i;
        for (i = 0; i < 10; i++) {
            if (hSVal[i] > 0 && hSVal[i] < 100000) {
                System.out.println((1 + i) + ") " + highScore[i] + " - "
                        + hSVal[i] + " s ");
            } else {
                break;
            }
        }
        if (i == 0) {
            System.out
                    .println("There are no high scores to show at the moment");
        }
        System.out.println("Press enter when you are done here");
        thrash = s.nextLine();
        thrash = s.nextLine();
    }

    public void highScr(String hName, double hScr) {
        hSVal[9] = hScr;
        highScore[9] = hName;
        for (int i = 0; i < hSVal.length - 1; i++) {
            for (int j = 0; j < hSVal.length - i - 1; j++) {
                if (hSVal[j] > hSVal[j + 1]) {
                    double tmp = hSVal[j];
                    hSVal[j] = hSVal[j + 1];
                    hSVal[j + 1] = tmp;
                    String tmpS = highScore[j];
                    highScore[j] = highScore[j + 1];
                    highScore[j + 1] = tmpS;
                }
            }
        }
    }

    void instructions() {
        System.out.println("\f");
        System.out
                .println("-----------------------Instructions-----------------------");
        System.out
                .println("1) Minesweeper is a simple game wherein the aim is to find all the mines");
        tool.delay(1);
        System.out
                .println("2) Enter the row number and the column number of the cell that you want to select");
        tool.delay(1);
        System.out
                .println("3) If it is a mine then you lose... but dont get disheartened you may win next time");
        tool.delay(1);
        System.out
                .println("4) If it is not a mine then a number will show which will display how many mines there are \n\t next to that cell..");
        tool.delay(1);
        System.out
                .println("5) The faster you so it.. the higher the chances of you getting a high score");
        System.out.println("Press enter when you are done here");
        thrash = s.nextLine();
        thrash = s.nextLine();
    }

    public static void main(String[] args) {
        do {
            System.out.println("\f");
            System.out
                    .println("  __  __   _                                                                     ");
            tool.delay(0.125);
            System.out
                    .println(" |  \\/  | (_)                                                                    ");
            tool.delay(0.125);
            System.out
                    .println(" | \\  / |  _   _ __     ___   ___  __      __   ___    ___   _ __     ___   _ __ ");
            tool.delay(0.125);
            System.out
                    .println(" | |\\/| | | | | '_ \\   / _ \\ / __| \\ \\ /\\ / /  / _ \\  / _ \\ | '_ \\   / _ \\ | '__|");
            tool.delay(0.125);
            System.out
                    .println(" | |  | | | | | | | | |  __/ \\__ \\  \\ V  V /  |  __/ |  __/ | |_) | |  __/ | |   ");
            tool.delay(0.125);
            System.out
                    .println(" |_|  |_| |_| |_| |_|  \\___| |___/   \\_/\\_/    \\___|  \\___| | .__/   \\___| |_|   ");
            tool.delay(0.125);
            System.out
                    .println("                                                            | |                  ");
            tool.delay(0.125);
            System.out
                    .println("                                                            |_|                  ");
            tool.delay(0.125);
            System.out.println();
            System.out.println("1) Play Minesweeper");
            System.out.println("2) Instructions");
            System.out.println("3) High Scores");
            System.out.println("4) Back to previous menu");
            System.out.println("Make your choice...");
            System.out.print("Choice : ");
            try {
                choice = Integer.parseInt(s.next());
            } catch (NumberFormatException nfe) {
                System.out.println("\f");
                System.out.println("Enter a Number please....");
                main(null);
            }
            switch (choice) {
                case 1:
                    mine.generate();
                    mine.play();
                    ;
                    int a = mine.highScr();
                    if (a > 0) {
                        System.out.println("Enter your name for high score");
                        name = s.nextLine();
                        name = s.nextLine();
                        mine.highScr(name, runTime);
                    }
                    break;
                case 2:
                    mine.instructions();
                    break;
                case 3:
                    mine.highScr(thrash);
                    break;
                case 4:
                    System.out.println("\f");
                    System.out.println("Do check out the other games....");
                    tool.delay(2);
                    g.main(null);
                    break;
                default:
                    System.out.println("\f");
                    System.out.println("Invalid Option....");
                    tool.delay(2);
            }
        } while (choice != 4);
    }

    void play() {
        crtm = 0;
        state = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                toShow[i][j] = '.';
            }
        }
        startTime = System.nanoTime();
        do {
            System.out.println("\f");
            printGrid(toShow);
            System.out.println("You will now have to enter the co-ordinates");
            try {
                System.out.print("Enter Row Number : ");
                row = Integer.parseInt(s.next());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");
                tool.delay(2);
                continue;
            }
            if (row > 5 || row < 1) {
                System.out.println("Enter a Number Between 1 and 5");
                tool.delay(1.5);
                continue;
            }
            try {
                System.out.print("Enter Column Number : ");
                col = Integer.parseInt(s.next());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");
                tool.delay(2);
                continue;
            }
            if (col > 5 || col < 1) {
                System.out.println("Enter a Number Between 1 and 5");
                tool.delay(1.5);
                continue;
            }
            row--;
            col--;
            if (toShow[row][col] == real[row][col]) {
                crtm--;
            }
            toShow[row][col] = real[row][col];
            if (toShow[row][col] == '*') {
                state = 2;
                printGrid(toShow);
                break;
            } else if (toShow[row][col] == '0') {
                crtm++;
                checkNear(row, col);
            } else {
                crtm++;
            }
            if (crtm == 20) {
                state = 1;
                printGrid(toShow);
                break;
            }
        } while (state != 1 || state != 2);
        if (state == 1) {
            runTime = System.nanoTime() - startTime;
            printGrid(real);
            System.out
                    .println("Congratulations... You have uncovered all the mines... You have won!!!");
            tool.delay(3);
        } else if (state == 2) {
            printGrid(real);
            System.out
                    .println("You stumbled onto a mine.... Try again.... You may win");
            tool.delay(3);
            System.out.println("Press enter to continue");
            thrash = s.nextLine();
            thrash = s.nextLine();
        }
    }

    void checkNear(int row1, int col1) {
        if (row1 == 0) {
            if (col1 == 0) {
                if (real[row1 + 1][col1] == '0') {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1] = real[row1 + 1][col1];
                        checkNear((row1 + 1), col1);
                    }
                } else {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1] = real[row1 + 1][col1];
                }
                if (real[row1 + 1][col1 + 1] == '0') {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                        checkNear((row1 + 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                }
                if (real[row1][col1 + 1] == '0') {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 + 1] = real[row1][col1 + 1];
                        checkNear(row1, (col1 + 1));
                    }
                } else {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 + 1] = real[row1][col1 + 1];
                }
            } else if (col1 == 4) {
                if (real[row1][col1 - 1] == '0') {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 - 1] = real[row1][col1 - 1];
                        checkNear(row1, (col1 - 1));
                    }
                } else {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 - 1] = real[row1][col1 - 1];
                }
                if (real[row1 + 1][col1 - 1] == '0') {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                        checkNear((row1 + 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                }
                if (real[row1 + 1][col1] == '0') {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1] = real[row1 + 1][col1];
                        checkNear((row1 + 1), col1);
                    }
                } else {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1] = real[row1 + 1][col1];
                }
            } else {
                if (real[row1][col1 - 1] == '0') {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 - 1] = real[row1][col1 - 1];
                        checkNear(row1, (col1 - 1));
                    }
                } else {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 - 1] = real[row1][col1 - 1];
                }
                if (real[row1][col1 + 1] == '0') {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 + 1] = real[row1][col1 + 1];
                        checkNear(row1, (col1 + 1));
                    }
                } else {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 + 1] = real[row1][col1 + 1];
                }
                if (real[row1 + 1][col1 - 1] == '0') {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                        checkNear((row1 + 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                }
                if (real[row1 + 1][col1] == '0') {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1] = real[row1 + 1][col1];
                        checkNear((row1 + 1), col1);
                    }
                } else {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1] = real[row1 + 1][col1];
                }
                if (real[row1 + 1][col1 + 1] == '0') {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                        checkNear((row1 + 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                }

            }
        } else if (row1 > 0 && row1 < 4) {
            if (col1 == 0) {
                if (real[row1 - 1][col1] == '0') {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1] = real[row1 - 1][col1];
                        checkNear((row1 - 1), col1);
                    }
                } else {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1] = real[row1 - 1][col1];
                }
                if (real[row1 - 1][col1 + 1] == '0') {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                        checkNear((row1 - 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                }
                if (real[row1][col1 + 1] == '0') {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 + 1] = real[row1][col1 + 1];
                        checkNear(row1, (col1 + 1));
                    }
                } else {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 + 1] = real[row1][col1 + 1];
                }
                if (real[row1 + 1][col1] == '0') {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1] = real[row1 + 1][col1];
                        checkNear((row1 + 1), col1);
                    }
                } else {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1] = real[row1 + 1][col1];
                }
                if (real[row1 + 1][col1 + 1] == '0') {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                        checkNear((row1 + 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                }
            } else if (col1 == 4) {
                if (real[row1 - 1][col1] == '0') {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1] = real[row1 - 1][col1];
                        checkNear((row1 - 1), col1);
                    }
                } else {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1] = real[row1 - 1][col1];
                }
                if (real[row1 - 1][col1 - 1] == '0') {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                        checkNear((row1 - 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                }
                if (real[row1][col1 - 1] == '0') {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 - 1] = real[row1][col1 - 1];
                        checkNear(row1, (col1 - 1));
                    }
                } else {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 - 1] = real[row1][col1 - 1];
                }
                if (real[row1 + 1][col1 - 1] == '0') {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                        checkNear((row1 + 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                }
                if (real[row1 + 1][col1] == '0') {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1] = real[row1 + 1][col1];
                        checkNear((row1 + 1), col1);
                    }
                } else {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1] = real[row1 + 1][col1];
                }
            } else {
                if (real[row1 - 1][col1 - 1] == '0') {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                        checkNear((row1 - 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                }
                if (real[row1 - 1][col1] == '0') {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1] = real[row1 - 1][col1];
                        checkNear((row1 - 1), col1);
                    }
                } else {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1] = real[row1 - 1][col1];
                }
                if (real[row1 - 1][col1 + 1] == '0') {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                        checkNear((row1 - 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                }
                if (real[row1][col1 - 1] == '0') {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 - 1] = real[row1][col1 - 1];
                        checkNear(row1, (col1 - 1));
                    }
                } else {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 - 1] = real[row1][col1 - 1];
                }
                if (real[row1][col1 + 1] == '0') {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 + 1] = real[row1][col1 + 1];
                        checkNear(row1, (col1 + 1));
                    }
                } else {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 + 1] = real[row1][col1 + 1];
                }
                if (real[row1 + 1][col1 - 1] == '0') {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                        checkNear((row1 + 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 - 1] == real[row1 + 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 - 1] = real[row1 + 1][col1 - 1];
                }
                if (real[row1 + 1][col1] == '0') {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1] = real[row1 + 1][col1];
                        checkNear((row1 + 1), col1);
                    }
                } else {
                    if (toShow[row1 + 1][col1] == real[row1 + 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1] = real[row1 + 1][col1];
                }
                if (real[row1 + 1][col1 + 1] == '0') {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                        checkNear((row1 + 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 + 1][col1 + 1] == real[row1 + 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 + 1][col1 + 1] = real[row1 + 1][col1 + 1];
                }
            }
        } else {
            if (col1 == 0) {

                if (real[row1 - 1][col1] == '0') {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1] = real[row1 - 1][col1];
                        checkNear((row1 - 1), col1);
                    }
                } else {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1] = real[row1 - 1][col1];
                }
                if (real[row1 - 1][col1 + 1] == '0') {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                        checkNear((row1 - 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                }
                if (real[row1][col1 + 1] == '0') {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 + 1] = real[row1][col1 + 1];
                        checkNear(row1, (col1 + 1));
                    }
                } else {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 + 1] = real[row1][col1 + 1];
                }
            } else if (col1 == 4) {

                if (real[row1 - 1][col1] == '0') {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1] = real[row1 - 1][col1];
                        checkNear((row1 - 1), col1);
                    }
                } else {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1] = real[row1 - 1][col1];
                }
                if (real[row1 - 1][col1 - 1] == '0') {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                        checkNear((row1 - 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                }
                if (real[row1][col1 - 1] == '0') {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 - 1] = real[row1][col1 - 1];
                        checkNear(row1, (col1 - 1));
                    }
                } else {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 - 1] = real[row1][col1 - 1];
                }
            } else {

                if (real[row1][col1 - 1] == '0') {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 - 1] = real[row1][col1 - 1];
                        checkNear(row1, (col1 - 1));
                    }
                } else {
                    if (toShow[row1][col1 - 1] == real[row1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 - 1] = real[row1][col1 - 1];
                }
                if (real[row1 - 1][col1 - 1] == '0') {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                        checkNear((row1 - 1), (col1 - 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 - 1] == real[row1 - 1][col1 - 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 - 1] = real[row1 - 1][col1 - 1];
                }
                if (real[row1 - 1][col1] == '0') {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1] = real[row1 - 1][col1];
                        checkNear((row1 - 1), col1);
                    }
                } else {
                    if (toShow[row1 - 1][col1] == real[row1 - 1][col1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1] = real[row1 - 1][col1];
                }
                if (real[row1 - 1][col1 + 1] == '0') {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                        checkNear((row1 - 1), (col1 + 1));
                    }
                } else {
                    if (toShow[row1 - 1][col1 + 1] == real[row1 - 1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1 - 1][col1 + 1] = real[row1 - 1][col1 + 1];
                }
                if (real[row1][col1 + 1] == '0') {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        ;
                    } else {
                        crtm++;
                        toShow[row1][col1 + 1] = real[row1][col1 + 1];
                        checkNear(row1, (col1 + 1));
                    }
                } else {
                    if (toShow[row1][col1 + 1] == real[row1][col1 + 1]) {
                        crtm--;
                    }
                    crtm++;
                    toShow[row1][col1 + 1] = real[row1][col1 + 1];
                }
            }
        }
    }

    void printGrid(char a[][]) {
        System.out.println("\f");
        System.out.println("\t  \t   1     2     3     4     5   ");
        System.out.println("\t  \t+-----+-----+-----+-----+-----+");
        for (int i = 0; i < 5; i++) {
            System.out.print("\t" + (i + 1) + "\t|");

            for (int j = 0; j < 5; j++) {
                System.out.print("  " + a[i][j] + "  |");
            }
            System.out.println();
            System.out.println("\t  \t+-----+-----+-----+-----+-----+");
        }
    }

    void generate() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                real[i][j] = '.';
            }
        }
        bombs = 0;
        while (bombs != 5) {
            row = r.nextInt(5);
            col = r.nextInt(5);
            if (real[row][col] == '*') {
                continue;
            } else {
                real[row][col] = '*';
                bombs++;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    if (j == 0) {
                        if (real[i][j] != '*') {
                            if (real[i][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j + 1] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    } else if (j == 4) {
                        if (real[i][j] != '*') {
                            if (real[i][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    } else {
                        if (real[i][j] != '*') {
                            if (real[i][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j + 1] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    }
                } else if (i > 0 && i < 4) {
                    if (j == 0) {
                        if (real[i][j] != '*') {
                            if (real[i - 1][j] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j + 1] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    } else if (j == 4) {
                        if (real[i][j] != '*') {
                            if (real[i - 1][j] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    } else {
                        if (real[i][j] != '*') {
                            if (real[i - 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j] == '*') {
                                prox++;
                            }
                            if (real[i + 1][j + 1] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    }
                } else {
                    if (j == 0) {
                        if (real[i][j] != '*') {
                            if (real[i - 1][j] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i][j + 1] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    } else if (j == 4) {
                        if (real[i][j] != '*') {
                            if (real[i - 1][j] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i][j - 1] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    } else {
                        if (real[i][j] != '*') {
                            if (real[i][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j - 1] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j] == '*') {
                                prox++;
                            }
                            if (real[i - 1][j + 1] == '*') {
                                prox++;
                            }
                            if (real[i][j + 1] == '*') {
                                prox++;
                            }
                            real[i][j] = prox;
                        }
                    }
                }
                prox = '0';
            }
        }
    }
}
