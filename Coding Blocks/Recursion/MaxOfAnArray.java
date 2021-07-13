package Recursion;

public class MaxOfAnArray {
    public static void main(String[] args) {
        int[] arr={22,33,4,19,7};
        System.out.println(findMax(arr,0));
    }

    private static int findMax(int[] arr, int i) {
        if (i==arr.length-1){
            return arr[i];
        }

        int max=findMax(arr,i+1);
        if (max>arr[i]){
            return max;
        }else{
            return  arr[i];
        }

    }
}
