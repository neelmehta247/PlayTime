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
import java.util.Scanner;

public class Game {

    static int choice;
    static Scanner s = new Scanner(System.in);
    static String thrash;
    static Resources tool = new Resources();
    static SnakesAndLadders sal = new SnakesAndLadders();
    static Minesweeper mine = new Minesweeper();
    static TypeRacer tr = new TypeRacer();

    public Game() {
        choice = 4;
    }

    public static void main(String[] args) {
        do {
            System.out.println("\f");
            System.out.println("         _   _                 _   _       ");
            tool.delay(0.25);
            System.out.println("        | \\ | |               | | ( )      ");
            tool.delay(0.25);
            System.out.println("        |  \\| |   ___    ___  | | |/   ___ ");
            tool.delay(0.25);
            System.out.println("        | . ` |  / _ \\  / _ \\ | |     / __|");
            tool.delay(0.25);
            System.out
                    .println("        | |\\  | |  __/ |  __/ | |     \\__ \\");
            tool.delay(0.25);
            System.out
                    .println("        |_| \\_|  \\___|  \\___| |_|     |___/");
            tool.delay(0.25);
            System.out
                    .println("   _____                       _                 ");
            tool.delay(0.25);
            System.out
                    .println("  / ____|                     (_)                ");
            tool.delay(0.25);
            System.out
                    .println(" | |  __    __ _   _ __ ___    _   _ __     __ _ ");
            tool.delay(0.25);
            System.out
                    .println(" | | |_ |  / _` | | '_ ` _ \\  | | | '_ \\   / _` |");
            tool.delay(0.25);
            System.out
                    .println(" | |__| | | (_| | | | | | | | | | | | | | | (_| |");
            tool.delay(0.25);
            System.out
                    .println("  \\_____|  \\__,_| |_| |_| |_| |_| |_| |_|  \\__, |");
            tool.delay(0.25);
            System.out
                    .println("                                            __/ |");
            tool.delay(0.25);
            System.out
                    .println("                                           |___/ ");
            tool.delay(0.25);
            System.out
                    .println("                                       _        ");
            tool.delay(0.25);
            System.out
                    .println("     /\\                               | |       ");
            tool.delay(0.25);
            System.out
                    .println("    /  \\     _ __    ___    __ _    __| |   ___ ");
            tool.delay(0.25);
            System.out
                    .println("   / /\\ \\   | '__|  / __|  / _` |  / _` |  / _ \\");
            tool.delay(0.25);
            System.out
                    .println("  / ____ \\  | |    | (__  | (_| | | (_| | |  __/");
            tool.delay(0.25);
            System.out
                    .println(" /_/    \\_\\ |_|     \\___|  \\__,_|  \\__,_|  \\___|");
            tool.delay(0.25);
            System.out.println();
            System.out.println("1) Play Snakes and Ladders");
            tool.delay(1);
            System.out.println("2) Play TypeRacer");
            tool.delay(1);
            System.out.println("3) Play Minesweeper");
            tool.delay(1);
            System.out.println("4) About");
            tool.delay(1);
            System.out.println("5) Exit");
            tool.delay(1);
            System.out.println("Make your choice");
            System.out.print("Choice : ");
            try {
                choice = Integer.parseInt(s.next());
            } catch (NumberFormatException nfe) {
                System.out.println("\f");
                System.out.println("Enter a number please......");
                tool.delay(2);
                main(null);
            }
            switch (choice) {
                case 1:
                    sal.main(null);
                    break;
                case 2:
                    tr.main(null);
                    break;
                case 3:
                    mine.main(null);
                    break;
                case 4:
                    System.out.println("\f");
                    System.out.println("This application was made by Neel Mehta");
                    System.out.println("It was for his project of standard 10....");
                    System.out
                            .println("This contains 3 very interesting games...\n Snakes And Ladders\n TypeRacer \n Minesweeper");
                    System.out.println("When you are done here press enter");
                    thrash = s.nextLine();
                    thrash = s.nextLine();
                    break;
                case 5:
                    System.out.println("\f");
                    System.out
                            .println("Thank you for using my application.... I hope you liked it");
                    tool.delay(2);
                    break;
                default:
                    System.out.println("\f");
                    System.out
                            .println("You entered a invalid number....\nEnter a number between 1 and 4");
                    tool.delay(2);
            }
        } while (choice != 5);
    }
}
