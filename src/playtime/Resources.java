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
public class Resources {

    void delay(double a) {
        long startTime = System.nanoTime();
        a *= 1000000000;
        long runTime = System.nanoTime() - startTime;
        while (runTime <= a) {
            runTime = System.nanoTime() - startTime;
        }
    }

    void countdown(int a) {
        for (int i = a; i >= 1; i--) {
            System.out.println("\t" + i + "..");
            delay(1);
        }
        System.out.println("  Lets Go!!");
    }

}
