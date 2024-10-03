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

        OUTER:
        while (true) {
            dashedBox.displayOptionsInBox(options);
            System.out.print("Please enter the number of your choice: ");
            int choice = scanner.nextInt();
            if (choice == options.length) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            } else {
                System.out.println("You selected: " + options[choice - 1]);
            }
            switch (choice) {
                case 1: {
                    Scanner firstScan = new Scanner(System.in);
                    System.err.println("How many shares would you like to buy?");
                    double shares = scanner.nextDouble();

                    Scanner secondScan = new Scanner(System.in);
                    System.err.println("How much is each share?");
                    double price = scanner.nextDouble();
                    company.buy(shares, price);
                    String totalCapital = company.getCapital();
                    System.out.println("Your capital is now: " + totalCapital);
                    break;
                }
                case 4: {
                    String totalCapital = company.getCapital();
                    System.out.println("Your total capital is: " + totalCapital);
                    break;
                }
                case 3: {
                    String shares = company.getShares();
                    System.out.println("You have a total of " + shares + " in your portfolio!");
                    break;
                }
                case 2: {
                    String s = company.getShares();
                    Double shareDouble = Double.valueOf(s);
                    if (shareDouble <= 0) {
                        System.err.println("Sorry, you do not have any shares to sell!");
                        continue;
                    }
                    Scanner firstScan = new Scanner(System.in);
                    System.out.println("How many shares would you like to sell?");
                    double shares = scanner.nextDouble();
                    if (shares > shareDouble) {
                        System.err.println("You are trying to sell " + shares + " shares and you only have " + shareDouble + " shares.");
                        dashedBox.displayOptionsInBox(options);
                    } else {
                        Scanner secondScan = new Scanner(System.in);
                        System.out.println("How much are you selling each share?");
                        double price = scanner.nextDouble();
                        company.sell(shares, price);
                        String totalShares = company.getShares();
                        System.out.println("Your capital is now: " + totalShares);
                        break;
                    }
                }
                default:
                    break;
            }
            System.out.println("");
        }
    }
}
