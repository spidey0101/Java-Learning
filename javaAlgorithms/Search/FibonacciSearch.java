public class FibonacciSearch {  
      
    public static int fibonacciSearch(int[] dp, int key) {  
        int fib2 = 0; // (m-2)th Fibonacci number  
        int fib1 = 1; // (m-1)th Fibonacci number  
        int fib = fib2 + fib1; // mth Fibonacci number  
  
        // Find the smallest Fibonacci number greater than or equal to the array length  
        while (fib < dp.length) {  
            fib2 = fib1;  
            fib1 = fib;  
            fib = fib2 + fib1;  
        }  
  
        int offset = -1; // Marks the eliminated range from front  
  
        // Perform a comparison-based search  
        while (fib > 1) {  
            int i = Math.min(offset + fib2, dp.length - 1); // Check if fib2 is a valid index  
  
            if (dp[i] < key) {  
                fib = fib1;  
                fib1 = fib2;  
                fib2 = fib - fib1;  
                offset = i;  
            } else if (dp[i] > key) {  
                fib = fib2;  
                fib1 = fib1 - fib2;  
                fib2 = fib - fib1;  
            } else {  
                return i; // Element found  
            }  
        }  
  
        if (fib1 == 1 && dp[offset + 1] == key) {  
            return offset + 1; // Compare the last element with the key  
        }  
  
        return -1; // Element not found  
    }  
  
}  