package week03;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Divisions {

    public static void main(String[] args) {
        try {
            float answer = divide();
            System.out.println(answer);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e);
            System.out.println("You terminated the process!");
        }
    }

    private static float divide() {
        float numerator;
        float denominator;
        numerator = getFloat();
        denominator = getFloat();
        return numerator / denominator;
    }

    private static float getFloat() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        while (true) {
            try {
                return input.nextFloat();
            } catch(InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter an actual number: ");
            }
        }
    }

}
