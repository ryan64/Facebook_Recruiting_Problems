package Strings_RotationalCipher;

import java.util.*;
import java.lang.*;

class Main {

    // Add any helper functions you may need here


    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        char[] inputAsChar = input.toCharArray();
        char[] resultAsChar = new char[input.length()];

        for (int i = 0; i < inputAsChar.length; i++) {

            if (Character.isLetter(inputAsChar[i]) && Character.isUpperCase(inputAsChar[i])){
                int alphaDigit = inputAsChar[i] - 'A' + 1;
                int newAlphaDigit = (alphaDigit + rotationFactor) % 26;

                if (newAlphaDigit == 0){
                    newAlphaDigit = alphaDigit + rotationFactor;
                }

                int asciiAlphaDigit = newAlphaDigit + 64;
                resultAsChar[i] = (char) asciiAlphaDigit;
            }

            else if (Character.isLetter(inputAsChar[i])) {
                int alphaDigit = inputAsChar[i] - 'a' + 1;
                int newAlphaDigit = (alphaDigit + rotationFactor) % 26;

                if (newAlphaDigit == 0){
                    newAlphaDigit = alphaDigit + rotationFactor;
                }

                int asciiAlphaDigit = newAlphaDigit + 96;
                resultAsChar[i] = (char) asciiAlphaDigit;
            }

            else if (Character.isDigit(inputAsChar[i])) {
                int digit = Character.getNumericValue(inputAsChar[i]);
                int newDigit = (digit + rotationFactor) % 10;
                char convertedDigit = Character.forDigit(newDigit, 10);
                resultAsChar[i] = convertedDigit;
            }

            else {
                resultAsChar[i] = inputAsChar[i];
            }
        }
        return String.valueOf(resultAsChar);
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here
        String input_3 = "Rzan9";
        int rotationFactor_3 = 3;
        String expected_3 = "Ucdq2";
        String output_3 = rotationalCipher(input_3, rotationFactor_3);
        check(expected_3, output_3);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
