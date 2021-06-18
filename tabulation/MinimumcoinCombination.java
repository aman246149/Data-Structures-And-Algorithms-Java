
class MinimumcoinCombination{
        public static void main(String[] args) {
            int coins[]={2,3,5,6};
            int targetamt=7;

            int dp[]=new int[targetamt+1];

            dp[0]=1;

            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <dp.length; j++) {
                    dp[j]+=dp[j-coins[i]];
                }
            }

            System.out.println(dp[targetamt]);

        }        
    }
    
