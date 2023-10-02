import java.util.ArrayList;

public class recursionhard {

    // Print all permutations of a String
    public static void printPerm(String str, String permutation) {
        if (str.length() == 0) {
            System.out.println(permutation);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPerm(newStr, permutation + currChar);
        }
    }
    // Count total paths in a maze to move from (0,0) to (n-1, m-1)

    public static int countPaths(int i, int j, int n, int m) {
        if (i == n - 1 || j == m - 1) {
            return 1;
        }
        int downPaths = countPaths(i + 1, j, n, m);
        int rightPaths = countPaths(i, j + 1, n, m);

        return downPaths + rightPaths;
    }

    // Place tiles of size 1 *m on a floor of n*m

    public static int placeTiles(int n, int m) {
        if (n == m) {
            return 2;
        } else if (n < m) {
            return 1;
        }
        int vertPlacements = placeTiles(n - m, m);
        int horPlacements = placeTiles(n - 1, m);
        return vertPlacements + horPlacements;
    }

    // Ways to call n guests single or in pairs
    public static int callGuests(int n) {
        if (n <= 1) {
            return 1;
        }
        int ways1 = callGuests(n - 1);
        int ways2 = (n - 1) * callGuests(n - 2);
        return ways1 + ways2;
    }

    // Print all subsets of set of n natural numbers

    public static void printSubsets(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }

    public static void Subset(int n, ArrayList<Integer> subset) {
        if (n == 0) {
            printSubsets(subset);
            return;
        }

        // add element
        subset.add(n);
        Subset(n - 1, subset);
        // don't add element
        subset.remove(subset.size() - 1);
        Subset(n - 1, subset);

    }

    public static void main(String[] args) {
        ArrayList<Integer> subset = new ArrayList<>();
        int n = 5;
        Subset(n, subset);

    }

}
