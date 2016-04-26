package com.sitajaf;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sample magic square of order 3");
        int[][] nums = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        for (int[] num : nums) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }
}
