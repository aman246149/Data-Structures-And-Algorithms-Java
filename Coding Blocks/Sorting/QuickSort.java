package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int high=arr.length-1;
        quicksort(0, high,arr);

        for(int a:arr){
            System.out.println(a);
        }
    }

    static  void quicksort(int l,int h,int[] arr){
        if (l<h){
            int pivot=partition(l, h,arr);
            quicksort(l,pivot-1,arr);
            quicksort(pivot+1,h,arr);
        }
    }
    static  int partition(int l,int h,int arr[]){
        int pivot=arr[l];
        int i=l;
        int j=h;

        while (i<j){
            while (arr[i]<=pivot && i<j)i++;
            while (arr[j]>pivot && j>i)j--;

            if (i<j)
                swap(arr,i,j);

        }
        swap(arr,j,l);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
