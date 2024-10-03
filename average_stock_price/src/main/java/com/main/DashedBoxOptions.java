package com.main;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DashedBoxOptions {

    public static void main(String[] args, Stock company) {
        // Define the options
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner scanner = new Scanner(System.in);
        DashedBox dashedBox = new DashedBox();

        String[] options = {
            "1. Buy Stock",
            "2. Sell Stock",
            "3. Check Shares",
            "4. Check Capital",
            "5. Exit"
        };

        boolean exit = false;

        while (true) {
            // Display the options in a dashed box
            dashedBox.displayOptionsInBox(options);

            // Get user's choice
            System.out.print("Please enter the number of your choice: ");
            int choice = scanner.nextInt();

            if (choice == options.length) {
                System.out.println("Exiting the program. Goodbye!");
                break;  // Exit after showing the box again
            } else {
                System.out.println("You selected: " + options[choice - 1]);
            }

            if (choice == 1) {
                Scanner firstScan = new Scanner(System.in);
                System.err.println("How many shares would you like to buy?");
                double shares = scanner.nextDouble();
                Scanner secondScan = new Scanner(System.in);
                System.err.println("How much is each share?");
                double price = scanner.nextDouble();
                company.buy(shares, price);
                String totalCapital = company.getCapital();
                System.out.println("Your capital is now: " + totalCapital);
            } else if (choice == 4) {
                String totalCapital = company.getCapital();
                System.out.println("Your total capital is: " + totalCapital);
            } else if (choice == 3) {
                String shares = company.getShares();
                System.out.println("You have a total of " + shares + " in your portfolio!");
            } else if (choice == 2) {
                String s = company.getShares();
                if (Double.parseDouble(s) >= 0) {
                    System.err.println("Sorry, you do not have any shares to sell!");
                    break;
                }
                Scanner firstScan = new Scanner(System.in);
                System.out.println("How many shares would you like to sell?");
                double shares = scanner.nextDouble();
                Scanner secondScan = new Scanner(System.in);
                System.out.println("How much are you selling each share?");
                double price = scanner.nextDouble();
                company.sell(shares, price);
                String totalShares = company.getShares();
                System.out.println("Your capital is now: " + totalShares);
            }

            System.out.println(""); // Print a blank line before prompting again
        }
    }
}
