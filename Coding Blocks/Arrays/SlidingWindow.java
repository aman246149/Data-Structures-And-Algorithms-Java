package Arrays;

public class SlidingWindow {
    //bruteforce method
//    public static void main(String[] args) {
//        int k=3;
//        int arr[]={4,5,1,3,2,7,6};
//        int msf=0;
//        int csum=0;
//
//        for (int i = 0; i < arr.length-k+1 ; i++) {
//            for (int j = i; j < (k+i) ; j++) {
//                csum=csum+arr[j];
//                System.out.println(j);
//
//            }
//            System.out.println("sum after j" + csum);
//            if (csum>msf){
//                msf=csum;
//                csum=0;
//            }else{
//                csum=0;
//            }
//
//        }
//        System.out.println("ans is"+msf);
//    }

    //optimize method

    public static void main(String[] args) {
        int k=3;
        int arr[]={4,5,1,3,2,7,6};
        int sum=0;
        int maxsum=0;
        for (int i = 0; i < k; i++) {
            sum=sum+arr[i];
        }
        maxsum=sum;
        for (int i = k; i < arr.length; i++) {
            sum=sum+arr[i]-arr[i-k];
            if (sum>maxsum){
                maxsum=sum;
            }
        }
        System.out.println(maxsum);
    }



}
