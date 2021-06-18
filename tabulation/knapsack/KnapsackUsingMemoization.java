package knapsack;

public class KnapsackUsingMemoization {
      public static void main(String[] args) {
            int w = 8;
            int wt[] = { 3, 2, 4 };
            int pr[] = { 6, 8, 7 };
            int n = wt.length - 1;
            System.out.println(knapsack(wt, pr, w, n));
      }

      static int knapsack(int wt[],int pr[],int w,int n){
            if (n<=0 || w==0) {
                  return 0;
            } 
            int dp[][]=new int[n+1][w+1];


            for (int r = 0; r < w + 1; r++) {
                  dp[0][r] = 0;
                  }
            for (int c = 0; c < n + 1; c++) {
                  dp[c][0] = 0;
                  }

            if (dp[w][n]!=0) {
                 return dp[n][w];
            }

            int result;
            if (wt[n]>w) {
                  result= knapsack(wt, pr, w, n-1);
                  return result;
            } else {
                  result= Math.max(knapsack(wt, pr, w, n-1), 
                  pr[n]+knapsack(wt, pr, w-wt[n], n-1)
                  );

                  dp[n][w]=result;

                  return result;
            }
      }
}
