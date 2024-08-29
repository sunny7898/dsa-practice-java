package recursion;

import java.util.ArrayList;

/*
    You are given a string 'STR' containing lowercase English letters from a to z inclusive.
    Your task is to find all non-empty possible subsequences of 'STR'.
*/
public class PrintAllSubsequences {
    private static void printSub(int i, int[] arr, ArrayList<Integer> list) {
        if (i == arr.length) {
            System.out.println(list.toString());
            return;
        }
        list.add(arr[i]);
        printSub(i + 1, arr, list);
        list.remove(list.size() - 1);
        printSub(i + 1, arr, list);
    }
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        ArrayList<Integer> list = new ArrayList<>();
        printSub(0, arr, list);
    }

    private static ArrayList<String> getAllSubsequences (String str, String res, int i){
        if (i >= str.length()) {
            ArrayList<String> ans = new ArrayList<>();
            if (!res.isEmpty()) {  // Exclude the empty subsequence
                ans.add(res);
            }
            return ans;
        }

        ArrayList<String> part1 = getAllSubsequences(str, res + str.charAt(i), i + 1);
        ArrayList<String> part2 = getAllSubsequences(str, res, i + 1);

        part1.addAll(part2);
        return part1;
    }
    public static ArrayList<String> subsequences(String str) {
        return getAllSubsequences(str, "", 0);
    }
}
