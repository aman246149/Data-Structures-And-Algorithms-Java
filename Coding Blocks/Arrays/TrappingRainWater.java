package Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr ={1,8,6,2,5,4,8,3,7};
        //Brute Force Approach
//
//        int lmax=arr[0];
//        int rmax=arr[arr.length-1];
//        int water=0;
//
//        for (int i = 1; i < arr.length-1; i++) {
//
//
//            for (int j = i; j > 0; j--) {
//                if (arr[j]>=lmax)
//                    lmax=arr[j];
//            }
//            for (int j = i; j < arr.length; j++) {
//                if (arr[j]>=rmax)
//                    rmax=arr[j];
//            }
//
//            water=water+Math.min(lmax,rmax)-arr[i];
////            System.out.println(water);
//        }
//
//        System.out.println(water);

        //Optimised Approach
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];

       left[0]=arr[0];
       int lmax=arr[0];
       right[arr.length-1]=arr[arr.length-1];
       int rmax=arr[arr.length-1];

       int result=0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<lmax){
                left[i]=lmax;
            }else{
                left[i]=arr[i];
                lmax=arr[i];
            }
        }

        for (int i = arr.length-2; i >=0; i--) {
            if (arr[i]<rmax){
                right[i]=rmax;
            }else{
                right[i]=arr[i];
                rmax=arr[i];
            }
        }


        for (int i = 0; i < arr.length ; i++) {
            result+=Math.min(left[i],right[i])-arr[i];
        }

        System.out.println(result);
    }
}
