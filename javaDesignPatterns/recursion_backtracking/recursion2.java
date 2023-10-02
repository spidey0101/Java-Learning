import java.util.HashSet;

public class recursion2 {
    public static void printNumb(String s, int n) {
        if (n == 0) {
            // System.out.println(s.charAt(n));
            return;
        }
        System.out.println(s.charAt(n - 1));
        printNumb(s, n - 1);

    }

    public static void subsequences(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }
        char curr = str.charAt(idx);
        subsequences(str, idx + 1, newString + curr);
        subsequences(str, idx + 1, newString);

    }

    public static void uniqueSubsequences(String str, int idx, String newString, HashSet<String> set) {
        if (idx == str.length()) {
            if (set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char curr = str.charAt(idx);
        uniqueSubsequences(str, idx + 1, newString + curr, set);
        uniqueSubsequences(str, idx + 1, newString, set);
    }

    public static void main(String[] args) {
        String s = "aaa";
        HashSet<String> set = new HashSet<>();
        uniqueSubsequences(s, 0, "", set);
    }
}
