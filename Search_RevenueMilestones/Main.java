package Search_RevenueMilestones;

import java.util.*;
// Add any extra import statements you may need here


class RevenueMilestones {

    // Add any helper functions you may need here
    private int search(int[] rev, int val) {
        int left = 0;
        int right = rev.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (val == rev[mid]) {
                return mid+1;
            }else if (val > rev[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left+1;
    }

    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int[] totalRevenuePerDay = new int[revenues.length];
        int[] daysMilestonesAchieved = new int[milestones.length];
        totalRevenuePerDay[0] = revenues[0];

        for (int i = 1; i < revenues.length; i++){
            totalRevenuePerDay[i] = totalRevenuePerDay[i-1] + revenues[i];
        }

        for (int i = 0; i < milestones.length; i++){
            daysMilestonesAchieved[i] = search(totalRevenuePerDay, milestones[i]);
        }

        return daysMilestonesAchieved;
    }
    
    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int revenues_1[] = {100, 200, 300, 400, 500};
        int milestones_1[] = {300, 800, 1000, 1400};
        int expected_1[] = {2, 4, 4, 5};
        int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
        check(expected_1, output_1);

        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        int expected_2[] = {5, 4, 2, 3, 2};
        int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
        check(expected_2, output_2);

        // Add your own test cases here
        int revenues_3[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int milestones_3[] = {100, 200, 500};
        int expected_3[] = {4, 6, 10};
        int[] output_3 = getMilestoneDays(revenues_3, milestones_3);
        check(expected_3, output_3);

    }

    public static void main(String[] args) {
        new RevenueMilestones().run();
    }
}