package GreedyAlgorithms_SlowSums;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int getTotalTime(int[] arr) {
        // Write your code here
        Arrays.sort(arr, 0, arr.length);

        int[] reversedArr = new int[arr.length];
        int j = arr.length;
        int currPenalty = 0;
        int totalPenalty = 0;

        for (int i = 0; i < arr.length; i++) {
            reversedArr[j - 1] = arr[i];
            j = j - 1;
        }

        for (int i = 0; i < reversedArr.length - 1; i++){
            currPenalty = reversedArr[i] + reversedArr[i+1];
            reversedArr[i] = 0;
            reversedArr[i+1] = currPenalty;
            totalPenalty = totalPenalty + currPenalty;
        }

       return totalPenalty;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        check(expected_2, output_2);

        int[] arr_3 = {8, 7, 1, 2, 9, 3};
        int expected_3 = 127;
        int output_3 = getTotalTime(arr_3);
        check(expected_3, output_3);

        int[] arr_4 = {7, 8, 1, 7, 8, 7};
        int expected_4 = 144;
        int output_4 = getTotalTime(arr_4);
        check(expected_4, output_4);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}
