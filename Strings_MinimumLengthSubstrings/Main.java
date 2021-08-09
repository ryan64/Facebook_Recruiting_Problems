package Strings_MinimumLengthSubstrings;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here
    private Map<Character, Integer> buildMapOfCharactersToOccurences(String s){
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            int numOfOccurrences = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), numOfOccurrences + 1);
        }

        return map;
    }

    private void addCharacterToHashTableMapping(Map<Character, Integer> map, Character c){
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1);
    }

    public int minLengthSubstring(String s, String t) {
        // Write your code here
        Map<Character, Integer> reqCharacters = buildMapOfCharactersToOccurences(t);
        Map<Character, Integer> windowCharacterMapping = new HashMap<>();

        int left = 0;
        int right = 0;

        int totalCharactersToMatch = reqCharacters.size();
        int charInWindowThatMatch = 0;

        int minimumWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindowSubstring = "";

        while (right < s.length()){
            char characterAtRightPointer = s.charAt(right);
            addCharacterToHashTableMapping(windowCharacterMapping, characterAtRightPointer);

            boolean rightCharIsRequired = reqCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsRequired) {
                boolean requirementForCharacterMet = reqCharacters.get(characterAtRightPointer).intValue()
                        == windowCharacterMapping.get(characterAtRightPointer).intValue();

                if (requirementForCharacterMet) {
                    charInWindowThatMatch++;
                }
            }

            while (charInWindowThatMatch == totalCharactersToMatch && left <= right){
                char characterAtLeftPointer = s.charAt(left);
                int windowSize = right - left + 1;

                if (windowSize < minimumWindowLengthSeenSoFar){
                    minimumWindowLengthSeenSoFar = windowSize;
                    minWindowSubstring = s.substring(left, right + 1);
                }

                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

                boolean leftCharIsRequired = reqCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsRequired){
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue()
                            < reqCharacters.get(characterAtLeftPointer).intValue();
                    if (characterFailsRequirement){
                        charInWindowThatMatch--;
                    }
                }
                left++;
            }
            right++;
        }

        if (minWindowSubstring.length() == 0){
            return -1;
        }
        return minWindowSubstring.length();
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
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        String s_3 = "dcbefebceaz";
        String t_3 = "abc";
        int expected_3 = 4;
        int output_3 = minLengthSubstring(s_3, t_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
