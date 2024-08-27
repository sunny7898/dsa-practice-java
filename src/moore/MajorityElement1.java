package moore;

public class MajorityElement1 {
    public int majorityElement(int[] arr) {
        int n = arr.length;

        int majorityElement = arr[0];
        int votes = 1;

        for (int i = 1; i < n; i++) {
            votes = (arr[i] == majorityElement) ? votes + 1 : votes - 1;

            if (votes == 0) {
                majorityElement = arr[i];
                votes = 1;
            }
        }

        // Note: since the question mentioned that there will be a majority element, hence we skipped the
        // post-validation for the found majority element, otherwise that is a must step.
        // because even if there is no majority element, the votes can still end +ve.

        return majorityElement;
    }
}
