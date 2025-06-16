package subarray;

public class PrintAllSubarrays {

    public static void printSubarrays(int[] arr) {
        int n = arr.length;

        /* Brute force approach - 3 loops */
        /*
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + (k < j ? ", " : ""));
                }
                System.out.println("]");
            }
        }
        */

        /* Better approach - 2 loops */
        for (int i = 0; i < n; i++) {
            StringBuilder subarray = new StringBuilder();
            for (int j = i; j < n; j++) {
                subarray.append(arr[j]).append((", "));

                // Print the current subarray
                System.out.println("[" + subarray.substring(0, subarray.length() - 2) + "]");
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Example size of array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // Filling array with natural numbers
        }

        printSubarrays(arr);
    }
}
