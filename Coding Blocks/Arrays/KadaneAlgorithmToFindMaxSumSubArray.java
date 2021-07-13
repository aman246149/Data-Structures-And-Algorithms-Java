package Arrays;

public class KadaneAlgorithmToFindMaxSumSubArray {
    public static void main(String[] args) {
        int[] arr ={-4,1,3,-2,16,2,-8,-9,4};
        int msf=arr[0];
        int left=-1;
        int right=-1;
        int mstart=0;
        int mend=0;
        int currentsum=arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (arr[i]>currentsum+arr[i]){
                currentsum=arr[i];
                left=i;

            }
            else{
                currentsum=currentsum+arr[i];
            }
            right=i;

            if (currentsum>msf){
                msf=currentsum;
                mstart=left;
                mend=right;
            }

        }
        System.out.println(msf);
        System.out.println(mstart+" "+mend);
    }
}
