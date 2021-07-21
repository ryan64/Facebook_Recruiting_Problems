package Stacks_BalancedBrackets;

import java.util.*;
// Add any extra import statements you may need here


class Main {
    // Add any helper functions you may need here
    boolean isBalanced(String s) {
        Stack<Character> balancer = new Stack<Character>();

        for (int i = 0; i < s.length(); i++){
            char currentBracket = s.charAt(i);
            char compareAgainst;

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '['){
                balancer.push(currentBracket);
                continue;
            }

            if (balancer.isEmpty()){
                return false;
            }

            if (currentBracket == ')'){
                compareAgainst = balancer.pop();
                if (compareAgainst == '{' || compareAgainst == '[')
                    return false;
            }

            if (currentBracket == '}'){
                compareAgainst = balancer.pop();
                if (compareAgainst == '(' || compareAgainst == '[')
                    return false;
            }

            if (currentBracket == ']'){
                compareAgainst = balancer.pop();
                if (compareAgainst == '(' || compareAgainst == '{')
                    return false;
            }
        }
        return (balancer.isEmpty());
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
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
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        // Add your own test cases here
        String s_3 = "[]{}()";
        boolean expected_3 = true;
        boolean output_3 = isBalanced(s_3);
        check(expected_3, output_3);

        String s_4 = "{(})";
        boolean expected_4 = false;
        boolean output_4 = isBalanced(s_4);
        check(expected_4, output_4);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}