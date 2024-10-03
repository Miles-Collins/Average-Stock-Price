package com.main;

public class DashedBox {

    public void displayOptionsInBox(String[] options) {
        // Determine the maximum width for the box
        int maxLength = 0;
        for (String option : options) {
            if (option.length() > maxLength) {
                maxLength = option.length();
            }
        }
        int boxWidth = maxLength + 4; // Padding for the box

        // Print the top dashed line for the entire box
        printDashedLine(boxWidth);

        // Print each option within the same box
        for (String option : options) {
            int padding = maxLength - option.length();
            System.out.println("| " + option + " ".repeat(padding) + " |");
        }

        // Print the bottom dashed line for the entire box
        printDashedLine(boxWidth);
    }

    // Method to print dashed line of a given width
    private void printDashedLine(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
