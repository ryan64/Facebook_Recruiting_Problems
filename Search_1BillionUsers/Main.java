package Search_1BillionUsers;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here
    int billion = 1000000000;

    public boolean growthRateCalc(float[] growthRates, int mid){
        double totalUsers = 0;
        for (int i = 0; i < growthRates.length; i++){
            totalUsers = totalUsers + Math.pow(growthRates[i], mid);
        }
        return (int) totalUsers >= billion;
    }

    int getBillionUsersDay(float[] growthRates) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (growthRateCalc(growthRates, mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
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
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        int expected_1 = 79;
        int output_1 = getBillionUsersDay(test_1);
        check(expected_1, output_1);

        float[] test_2 = {1.01f, 1.02f};
        int expected_2 = 1047;
        int output_2 = getBillionUsersDay(test_2);
        check(expected_2, output_2);


        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}
