package bit_manipulation;

public class FindRepeatingAndMissing {
    int[] findTwoElement(int arr[], int n) {


        // Didn't used the XOR approach - try from the striver video

        // let x be repeating and y be missing

        long sumN = (long) n * (n + 1) / 2;  // Sum from 1 .... n
        long sumSquareN = (long) n * (n + 1) * (2 * n + 1) / 6; // Sum from 1^2 ... n^2

        long sumArr = 0;
        long sumSquareArr = 0;

        for (int num : arr) {
            sumArr += num;
            sumSquareArr += (long) num * num;
        }

        long sumDiff = sumArr - sumN;  // ==  x - y
        long sumSquareDiff = sumSquareArr - sumSquareN; // x ^2 - y^2

        long sumXY = sumSquareDiff / sumDiff; // x + y

        // Calculate the missing and repeating numbers
        int missing = (int) ((sumXY - sumDiff) / 2);
        int repeating = (int) ((sumXY + sumDiff) / 2);

        return new int[]{repeating, missing};
    }
}
