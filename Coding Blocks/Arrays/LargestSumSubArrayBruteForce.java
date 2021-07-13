package Arrays;

public class LargestSumSubArrayBruteForce {
    public static void main(String[] args) {
        int arr[]={-4,1,3,-2,6,2,-1,-4,-7};
        int currentSum=0;
        int previousSum=0;
        int left=-1;
        int right=-1;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length; j++) {
                //important step because for every  subarray
                //we want new current sum so we can update our
                //previous sum
                    currentSum=0;
                for (int k = i; k < j; k++) {
                    currentSum=currentSum+arr[k];
                    if (currentSum>previousSum){
                        left=i;
                        right=j;
                        previousSum=currentSum;
                    }
                }
            }
        }
        System.out.println(previousSum);
        System.out.println("index are "+ left +" " + right );
    }
}
