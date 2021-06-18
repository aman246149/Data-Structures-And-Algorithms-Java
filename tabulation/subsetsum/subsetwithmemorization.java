package subsetsum;


import java.util.HashMap;
import java.util.Map;
 
class Main
{
    // Returns true if there exists a subsequence of `A[0…n]` with the given sum
    public static boolean subsetSum(int[] A, int n, int sum,
                                    Map<String, Boolean> lookup)
    {
        // return true if the sum becomes 0 (subset found)
        if (sum == 0) {
            return true;
        }
 
        // base case: no items left, or sum becomes negative
        if (n < 0 || sum < 0) {
            return false;
        }
 
        // construct a unique map key from dynamic elements of the input
        String key = n + "|" + sum;
 
        // if the subproblem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. Include the current item `A[n]` in the subset and recur
            // for the remaining items `n-1` with the decreased total `sum-A[n]`
            boolean include = subsetSum(A, n - 1, sum - A[n], lookup);
 
            // Case 2. Exclude the current item `A[n]` from the subset and recur for
            // the remaining items `n-1`
            boolean exclude = subsetSum(A, n - 1, sum, lookup);
 
            // assign true if we get subset by including or excluding
            // current item
            lookup.put(key, include || exclude);
        }
 
        // return solution to the current subproblem
        return lookup.get(key);
    }
 
    public static void main(String[] args)
    {
        // Input: a set of items and a sum
        int[] A = { 7, 3, 2, 5, 8 };
        int sum = 14;
 
        // create a map to store solutions to subproblems
        Map<String, Boolean> lookup = new HashMap<>();
 
        if (subsetSum(A, A.length - 1, sum, lookup)) {
            System.out.println("Subsequence with the given sum exists");
        }
        else {
            System.out.println("Subsequence with the given sum does not exist");
        }
    }
}