package partitionSubsetEqualSum;

//recursion method
class PartitionSubset{
      public static void main(String[] args) {
            // int arr[]={3,1,5,9,12};
            int arr[]={1,5,11,5};
            int n=arr.length;
            if (findPartition(arr, n)==true) {
                  System.out.println("equal partition");
            }else{
                  System.out.println("not divided");
            }
      }

    private static boolean findPartition(int[] arr, int n) {
            int sum=0;
            for (int i = 0; i < n; i++) {
                  sum=sum+arr[i];
            }

            if (sum%2!=0) {
                  return false;
            }

            return isSubSetSum(arr,n,sum/2);
    }

private static boolean isSubSetSum(int[] arr, int n, int sum) {
      if (sum==0) {
            return true;
      }

      if (n==0 ) {
            return false;
      }

       if (arr[n-1]>sum) {
             return isSubSetSum(arr, n-1, sum);
       }

       return isSubSetSum(arr, n-1, sum) || isSubSetSum(arr, n-1, sum-arr[n-1]);
}
}