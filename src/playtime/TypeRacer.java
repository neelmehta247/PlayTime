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

public class TypeRacer {
    
    static Scanner s = new Scanner(System.in);
    static double startTime, runTime;
    static int correct, incorrect, wordSpeed, i, pos, choice;
    static Random r = new Random();
    static Game g = new Game();
    static String input, name, thrash;
    static String highScore[] = {"", "", "", "", "", "", "", "", "", ""};
    static int hSVal[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   
    static String word[] = {"Computer", "Count", "There", "Cube", "Friend",
     "Super", "Star", "Mother", "Father", "Reset", "History", "Society",
     "Love", "Speed", "Awesome", "Earth", "Moon", "Cool", "Marble",
     "Class", "Object", "Second", "Cross", "Bank", "United", "Science",
     "Transport", "Defence", "Games", "Snakes", "Ladders", "Football",
     "Time", "Space", "Five", "Hundred", "Thousand", "Child", "Parent",
     "Race", "Distance", "Water", "Food", "India", "Page", "Freedom",
     "Free", "Nuts", "Olympics", "Planet", "Phone", "Hair", "Money",
     "Gender", "Country", "Life", "Many", "Version", "House", "God",
     "Spirit", "Stick", "Sports", "Camera", "Oily", "Shade", "Tissue",
     "Bowl", "Cover", "Modify", "Declare", "Default", "Paper",
     "Almonds", "Fruit", "Mobile", "Bible", "Hotel", "Horror",
     "Captain", "Leader", "Team", "Language", "Cousin", "Welcome",
     "Array", "Print", "Scanner", "Java", "Internet", "Network", "Epic",
     "Novel", "Sell", "Income", "Expense", "Savings", "Adapt",
     "Explode", "Bomb", "Likely", "Doing", "Glass", "Blind", "Deaf",
     "Dumb", "Sound", "Vehicle", "Books", "Patient", "Apple", "Cake",
     "Soap", "Dusk", "Dawn", "Scale", "Map", "Brain", "Atom", "Empty",
     "Garbage", "Rubbish", "Crazy", "Passion", "Hobby", "Husband",
     "Fast", "Twist", "Fingers", "Comedy", "Jokes", "Death", "Because",
     "Project", "Bite", "Scramble", "Numbers", "Swim", "Letter",
     "Essay", "Portion", "Scope", "Come", "Glad", "Tease", "Speak",
     "Gamble", "Face", "Artist", "Minister", "Rule", "Conquer", "Jump",
     "Mark", "Write", "Allow", "Dance", "Compell", "Spend", "End",
     "Tough", "Hard", "English", "Limit", "Increase", "Attempt",
     "Answer", "Work", "Newton", "Subject", "Wind", "Crops", "Plant",
     "Enjoy", "Pyramid", "Assert", "Mule", "Cow", "Horse", "Aware",
     "Pig", "Pizza", "Cards", "Deck", "Bridge", "Aeroplane", "Born",
     "Cafe", "Done", "Land", "Fail", "Pass", "Cheque", "Pastry",
     "Desert", "Suit", "Bowtie", "Show", "Shop", "Impress"};
    static int random[] = new int[word.length];
    static TypeRacer tr = new TypeRacer();
    static Resources tool = new Resources();
    
    public void play() {
        correct = 0;
        incorrect = 0;
        startTime = System.nanoTime();
        runTime = 0;
        int i = 0;
        System.out.println("\f");
        while (runTime < 60) {
            System.out.println(word[i] + "\t\tNext Word : " + word[i + 1]);
            input = s.next();
            input = input.trim();
            if (input.equalsIgnoreCase(word[i])) {
                correct++;
            } else {
                incorrect++;
            }
            System.out.println();
            runTime = (System.nanoTime() - startTime) / 1000000000;
            i++;
        }
    }
    
    public void results() {
        wordSpeed = correct - incorrect;
        System.out.println("\f");
        System.out.println("Time Up!!!!!");
        tool.delay(2);
        System.out.println("Number of correct words : " + correct);
        tool.delay(2);
        System.out.println("Number of incorrect words : " + incorrect);
        tool.delay(2);
        System.out.println("Your adjusted words typed : " + wordSpeed);
        tool.delay(2);
        System.out.println("Your type speed (in words per minute) : "
                + wordSpeed + " WPM");
        tool.delay(2);
        System.out.println("When you are done here press enter");
        thrash = s.nextLine();
        thrash = s.nextLine();
    }
    
    public void randomize() {
        for (i = 0; i < random.length; i++) {
            random[i] = r.nextInt(1000);
        }
        for (i = 0; i < random.length - 1; i++) {
            for (int j = 0; j < random.length - i - 1; j++) {
                if (random[j] > random[j + 1]) {
                    int tmp = random[j];
                    random[j] = random[j + 1];
                    random[j + 1] = tmp;
                    String tmpS = word[j];
                    word[j] = word[j + 1];
                    word[j + 1] = tmpS;
                }
            }
        }
    }
    
    public void rules() {
        System.out.println("\f");
        System.out.println("Here are the rules........");
        System.out.println();
        tool.delay(1);
        System.out.println("1. You will get 60 seconds worth of time");
        System.out.println();
        tool.delay(2);
        System.out.println("2. Words will show up on the screen");
        System.out.println();
        tool.delay(2);
        System.out.println("3. You have to type the words as fast as possible");
        System.out.println();
        tool.delay(2);
        System.out
                .println("4. You will be notified at the end of a minute and your results will be shown");
        System.out.println();
        tool.delay(2);
        System.out
                .println("5. If you make a high score then you will be prompted to enter your name");
        System.out.println();
        tool.delay(2);
        System.out
                .println("6. You can check the high score in the high score menu");
        System.out.println();
        tool.delay(2);
        System.out.println("Press enter when you are done here");
        thrash = s.nextLine();
        thrash = s.nextLine();
    }
    
    public int highScr() {
        int flag = 0;
        for (i = 0; i < 10; i++) {
            if (wordSpeed > hSVal[i]) {
                System.out.println("Your score has got you at position : "
                        + (i + 1) + " in your leaderboard");
                flag = 1;
                break;
            }
        }
        return flag;
    }
    
    public void highScr(String a) {
        System.out.println("\f");
        for (i = 0; i < 10; i++) {
            if (hSVal[i] > 0) {
                System.out.println((1 + i) + ") " + highScore[i] + " - "
                        + hSVal[i]);
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
    
    public void highScr(String hName, int hScr) {
        hSVal[9] = hScr;
        highScore[9] = hName;
        for (i = 0; i < hSVal.length - 1; i++) {
            for (int j = 0; j < hSVal.length - i - 1; j++) {
                if (hSVal[j] < hSVal[j + 1]) {
                    int tmp = hSVal[j];
                    hSVal[j] = hSVal[j + 1];
                    hSVal[j + 1] = tmp;
                    String tmpS = highScore[j];
                    highScore[j] = highScore[j + 1];
                    highScore[j + 1] = tmpS;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        do {
         System.out.println("\f");
         System.out
         .println("  ______                              ____                                     ");
         tool.delay(0.25);
         System.out
         .println(" /_  __/__  __  ____   ___           / __ \\  ____ _  _____  ___    _____       ");
         tool.delay(0.25);
         System.out
         .println("  / /  / / / / / __ \\ / _ \\         / /_/ / / __ `/ / ___/ / _ \\  / ___/       ");
         tool.delay(0.25);
         System.out
         .println(" / /  / /_/ / / /_/ //  __/        / _, _/ / /_/ / / /__  /  __/ / /           ");
         tool.delay(0.25);
         System.out
         .println("/_/   \\__, / / .___/ \\___/        /_/ |_|  \\__,_/  \\___/  \\___/ /_/            ");
         tool.delay(0.25);
         System.out
         .println("     /____/ /_/                                                                ");
         tool.delay(0.25);
         System.out.println();
         System.out
         .println("1) Play Type Racer\n2) Instructions\n3) High Scores\n4) Back To Previous Menu");
         System.out.println("Make your Choice");
         System.out.print("Choice : ");
         try {
         choice = Integer.parseInt(s.next());
         } catch (NumberFormatException nfe) {
         System.out.println("\f\t\t Please Enter a Number");
         tool.delay(2);
         }
         switch (choice) {
         case 1:
         System.out.println("\f");
         System.out.println("\t\tGet Ready");
         tool.countdown(3);
         tr.randomize();
         tr.play();
         tr.results();
         int a = tr.highScr();
         if (a > 0) {
         System.out.println("Enter you name for high score");
         name = s.next();
         tr.highScr(name, wordSpeed);
         }
         break;
         case 2:
         tr.rules();
         break;
         case 3:
         tr.highScr(thrash);
         break;
         case 4:
         System.out.println("\f\t\tDo check out the other games");
         tool.delay(2);
         g.main(null);
         break;
         default:
         System.out
         .println("Invalid Option. Enter a number between 1 and 4");
         }
        
         } while (choice != 4);
        TypeRacer t = new TypeRacer();
        t.randomize();
        for (String word1 : t.word) {
            System.out.print(word1);
        }
    }
}
