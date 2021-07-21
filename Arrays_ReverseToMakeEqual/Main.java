package Arrays_ReverseToMakeEqual;

// Add any extra import statements you may need here

class Main {

    // Add any helper functions you may need here
    public int[] reverse(int[] arr, int start, int end) {
        int d = (end - start + 1) / 2;
        for(int i = 0; i < d; i++) {
            int t = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = t;
        }
        return arr;
    }


    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code hereRev
        int lengthOfA = array_a.length;
        int lengthOfB = array_b.length;
        int start = 0;
        int end = lengthOfA - 1;

        if (lengthOfA != lengthOfB){
            return false;
        }

        for (int i = 0; i < lengthOfA; i++){
            if (array_a[i] != array_b[i]){
                start = i;
                break;
            }
        }

        for (int i = lengthOfA - 1; i >= 0; i--){
            if (array_a[i] != array_b[i]){
                end = i;
                break;
            }
        }

        array_b = reverse(array_b, start, end);

        for (int i = 0; i < lengthOfA; i++){
            if (array_a[i] != array_b[i]){
                return false;
            }
        }
        return true;
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

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here
        int[] array_a_3 = {10, 11, 12, 13};
        int[] array_b_3 = {10, 11, 11, 14};
        boolean expected_3 = false;
        boolean output_3 = areTheyEqual(array_a_3, array_b_3);
        check(expected_3, output_3);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
