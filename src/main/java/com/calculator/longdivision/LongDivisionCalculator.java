package com.calculator.longdivision;

import java.util.Scanner;

public class LongDivisionCalculator {

    public static void main(String[] args) {
        LongDivisionProcessor processor = new LongDivisionProcessor();
        LongDivisionFormatter formatter = new LongDivisionFormatter();
        System.out.println("Welcome to the long division calculator app!");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter dividend and divisor: ");
                int dividend = requireInput(scanner);
                int divisor = requireInput(scanner);
                LongDivisionResult result = processor.divide(dividend, divisor);
                System.out.println(formatter.format(result));
                System.out.println("Exit? Yes / No");
                String userChoice = scanner.next();
                if (userChoice.equalsIgnoreCase("yes")) {
                    System.out.println("See you later!)");
                    break;
                } else {
                    System.out.println(
                            "Continuing the program... you entered: '" + userChoice + "'. Let's move forward!");
                }
            }
        }
    }

    private static int requireInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out
                    .println("Invalid input: '" + scanner.next() + "'. Please enter a valid integer (max 2147483647)!");
        }
        return scanner.nextInt();
    }

}