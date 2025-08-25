package partition;

public class NextGreaterPermutation {
    // private void generatePermutations(int[] nums, int start, List<List<Integer>> permutations) {
    //     if (start == nums.length) {
    //         List<Integer> permutation = new ArrayList<>();
    //         for (int num : nums) {
    //             permutation.add(num);
    //         }
    //         permutations.add(permutation);
    //     } else {
    //         for (int i = start; i < nums.length; i++) {
    //             swap(nums, i, start);
    //             generatePermutations(nums, start + 1, permutations);
    //             swap(nums, i, start);
    //         }
    //     }
    // }
    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    private void reverse(int[] nums, int start, int end){
        while(start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {

        // Brute force:

        /*
            Time Complexity:
            Permutation Generation: O(n!)
            Sorting: O(n!×n)
            Finding Index: O(n!)

            Total Space Complexity:
            Permutations Storage: O(n×n!) (dominant factor)
            Recursion Stack: O(n)
            Thus, the overall space complexity of this brute force approach is O(n×n!).

            Generate all permutations
            Sort all permutations
            Search for the give permutation
            Check the next permutation, if there is none, first permutation is the answer

            List<List<Integer>> permutations = new ArrayList<>();
            generatePermutations(nums, 0, permutations);

            // Sort all generated permutations
            Collections.sort(permutations, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });

            // Find the current permutation in the sorted list
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }

            int index = permutations.indexOf(currentPermutation);

            // Get the next permutation, or the first one if current is the last
            List<Integer> nextPermutation;
            if (index == permutations.size() - 1) {
                nextPermutation = permutations.get(0);
            } else {
                nextPermutation = permutations.get(index + 1);
            }

            // Copy the result back into the input array
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nextPermutation.get(i);
            }
        */

        // Optimized: O(n)
        int n = nums.length;
        // Step 1: Finding the pivot
        int pivotIdx = -1;
        for (int i = n-2; i >= 0; i--){
            if (nums[i] < nums[i + 1]) {
                pivotIdx = i;
                break;
            }
        }
        /*
            If no pivot, means array is at the last permutation. Ex: 1,2,3,4,5
            the next greater would simply be the reverse of it
        */
        if (pivotIdx == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        // Step 2: Finding the next successor
        for (int i = n-1; i >= pivotIdx; i--) {
            if (nums[i] > nums[pivotIdx]) {
                swap(nums, i, pivotIdx);
                break;
            }
        }

        // Step 3: Reverse from pivotIdx + 1 to n because even after swap, the graph is still same
        reverse(nums, pivotIdx+1, n-1);
    }
}
