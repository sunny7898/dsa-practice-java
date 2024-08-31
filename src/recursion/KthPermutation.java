package recursion;

import java.util.ArrayList;

public class KthPermutation {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        String ans = "";
        k = k - 1;
        while (true) {

            // Finding the Starting from - number
            int startingNum = k / fact;
            ans = ans + numbers.get(startingNum);

            // Get the remaining array
            numbers.remove(startingNum);
            if (numbers.isEmpty()) break;

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}
