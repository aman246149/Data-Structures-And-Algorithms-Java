package partitionSubsetEqualSum;

// A Dynamic Programming based
// Java program to partition problem
class Solution {

      public static void main(String[] args) {
            int arr[] = { 1, 3, 3, 2, 3, 2 };
            int n = 6;

            // Function call
            if (canPartition(arr) == true)
                  System.out.println("Can be divided into two " + "subsets of equal sum");
            else
                  System.out.println("Can not be divided into " + "two subsets of equal sum");
      }
      public  static boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < n; ++i)
                  sum += nums[i];

            if (sum % 2 == 1)
                  return false;

            boolean[][] dp = new boolean[n + 1][sum / 2 + 1];

            for (int i = 0; i <= n; ++i)
                  for (int j = 0; j <= sum / 2; ++j) {
                        if (i == 0 || j == 0) // Base Case
                              dp[i][j] = false;
                        else if (nums[i - 1] > j) // SkIP case
                              dp[i][j] = dp[i - 1][j];
                        else if (nums[i - 1] == j)
                              dp[i][j] = true;
                        else
                              dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                  }
            return dp[n][sum / 2];
      }
}