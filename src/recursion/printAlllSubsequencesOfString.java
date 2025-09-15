package recursion;

public class printAlllSubsequencesOfString {
    private static void printF(String input, String subseq, int idx) {
        if (idx == input.length()){
            System.out.println(subseq);
            return;
        }

        // Strings are immutable.
        // Strings in Java are immutable, so "subseq + input.charAt(idx)" creates a new string object.
        // Choice 1: include current character
        printF(input, subseq + input.charAt(idx), idx + 1);

        // Choice 2: exclude current character
        printF(input, subseq, idx + 1);
    }

    public static void printSubsequences(String input) {
        printF(input, "", 0);
    }

    // To modify string - subseq
    private static void printF(String input, StringBuilder subseq, int idx) {
        if (idx == input.length()) {
            System.out.println(subseq.toString());
            return;
        }
        // Include current char
        subseq.append(input.charAt(idx));
        printF(input, subseq, idx + 1);

        // Backtrack (undo last append)
        subseq.deleteCharAt(subseq.length() - 1);
        // Exclude current char
        printF(input, subseq, idx + 1);
    }

    public static void printSubsequencesStringModified(String input) {
        printF(input, new StringBuilder(), 0);
    }
}
