package Sorting;

public class CountSort {
    public static void main(String[] args) {
        int [] arr={1,3,2,3,4,1,6,4,3};

        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
//        System.out.println(max);
        int newArraySize=max-1;

        int countArr[]=new int[newArraySize];

        int count=0;
        for (int i = 0; i < newArraySize; i++) {
           countArr[arr[i]]++;
        }

        for(int a:countArr){
            System.out.print(a);
        }
    }
}
