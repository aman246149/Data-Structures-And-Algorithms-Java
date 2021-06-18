public class ClimbingStairPathWithJumps {
    public static void main(String[] args) {
        climbwithjump(10);
    }

    static void climbwithjump(int n){
        int dp[]=new int[n+1];

        int arr[]={3,3,0,2,1,2,4,2,0,0};
        
        dp[n]=1;

        for (int i = n-1; i >=0; i--) {
          if(arr[i]>0){
            for (int j = 1; j <=arr[i] && i+j<dp.length; j++) {
                dp[i]+=dp[i+j];
            }
          }
        }

        System.out.println(dp[0]);
    }
}



   