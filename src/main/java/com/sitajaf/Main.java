package com.sitajaf;

import com.sitajaf.exceptions.MagicSquareException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MagicSquareGenerator magicSquareGenerator = new MagicSquareGenerator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press ctrl+c to quit!\n");

        while (true) {
            System.out.println("Enter an odd number to generate a square:");
            try {
                int order = Integer.parseInt(scanner.next());
                int[][] square = magicSquareGenerator.generate(order);
                for (int[] row : square) {
                    for (int column = 0; column < square.length; column++) {
                        System.out.print(row[column] + "\t");
                    }
                    System.out.println("\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");

            } catch (MagicSquareException e) {
                System.out.println(e.getMessage());
            }


        }

    }
}
