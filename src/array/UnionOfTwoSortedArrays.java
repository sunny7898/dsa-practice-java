package array;

import java.util.*;

public class UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {

        // Brute force:
//        Set<Integer> set = new HashSet<>();
//        for (int num : arr1) set.add(num);
//        for (int num : arr2) set.add(num);
//
//        List<Integer> result = new ArrayList<>(set);
//        Collections.sort(result);
//        return result;

        // Better:
        // Set<Integer> set = new HashSet<>();
        // If linkedhashset, the order would be preserved but not sorted
        // // Set<Integer> set = new LinkedHashSet<>();
        //
        // // Insert all elements of arr1 and arr2 into the set
        // for (int num : arr1) set.add(num);
        // for (int num : arr2) set.add(num);
        //
        // // Convert the set to a list and sort it
        // List<Integer> union = new ArrayList<>(set);
        // Collections.sort(union);
        //
        // return union;
        //

        // Best:
        ArrayList<Integer> union = new ArrayList<>();

        // Traverse both arrays using two pointers
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                // Add arr1[i] if it's not a duplicate
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                // Add arr2[j] if it's not a duplicate
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            } else {
                // Both elements are the same
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1 if any
        while (i < n) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements from arr2 if any
        while (j < m) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }
}
