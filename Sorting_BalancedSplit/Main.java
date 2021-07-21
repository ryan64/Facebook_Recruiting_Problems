package Sorting_BalancedSplit;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class BalancedSplit {

    // Add any helper functions you may need here

    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        int sumOfArrElements = 0;
        int sumOfSubArrayElements = 0;

        int aTotal = 0;
        int bTotal = 0;

        List<Integer> aList = new ArrayList<Integer>();
        List<Integer> bList = new ArrayList<Integer>();

        //summation of every element in array
        for (int i = 0; i < arr.length; i++){
            sumOfArrElements = sumOfArrElements + arr[i];
        }

        //check if summation arr can be split evenly into A and B.
        if ((sumOfArrElements % 2) != 0) {
            return false;
        }

        sumOfSubArrayElements = sumOfArrElements / 2;

        //check that current element in array does not exceed sum of subarray and that the total of all elements in subarray a is less than or equal to sum of subarray.
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < sumOfSubArrayElements){
                aTotal += arr[i];
                if (aTotal <= sumOfSubArrayElements){
                    aList.add(arr[i]);
                }
                else {
                    bList.add(arr[i]);
                }
            }
            else {
                bList.add(arr[i]);
            }
        }

        //intialize biggest element in a and smallest element in b with the first element in each respective list.
        int aBiggestElement = aList.get(0);
        int bSmallestElement = bList.get(0);

        //iterate through list a and find biggest element.
        for (int i = 1; i < aList.size(); i++){
            if (aBiggestElement < aList.get(i)){
                aBiggestElement = aList.get(i);
            }
        }

        //iterate through list b and find smallest element.
        for (int i = 1; i < bList.size(); i++){
            if (bSmallestElement > bList.get(i)){
                bSmallestElement = bList.get(i);
            }
        }

        //verify that every element in subarray a is less than every element in subarray b.
        if (aBiggestElement < bSmallestElement){
            return true;
        }
        else {
            return false;
        }
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        check(expected_1, output_1);

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here
        int arr_3[] = {1, 5, 7, 1};
        boolean expected_3 = true;
        boolean output_3 = balancedSplitExists(arr_3);
        check(expected_3, output_3);

        int arr_4[] = {12, 7, 6, 7, 6};
        boolean expected_4 = false;
        boolean output_4 = balancedSplitExists(arr_4);
        check(expected_4, output_4);
    }

    public static void main(String[] args) {
        new BalancedSplit().run();
    }
}
