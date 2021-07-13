package Recursion;

public class LastIndex {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,6,7,8,8};
        System.out.println(findLast(arr,0,8));

    }

    private static int findLast(int[] arr, int i, int search) {

        if (i==arr.length){
            return -1;
        }

        int lastele=findLast(arr,i+1,search);
        if (arr[i]==search){
            return i;
        }else{
            return lastele;
        }
    }
}
