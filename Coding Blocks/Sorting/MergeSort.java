package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int arr[]={1,5,4,2,89,34,6,12};
        mergesort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.println(a);
        }
    }

    private static void mergesort(int[] arr, int l, int r) {
        if(l<r){
           int mid=(l+r)/2;
           mergesort(arr,l,mid);
           mergesort(arr,mid+1,r);
           merge(arr,l,mid,r);
        }
    }

   static void merge(int arr[], int beg, int mid, int end)
    {

        int l = mid - beg + 1;
        int r = end - mid;

        int LeftArray[] = new int [l];
        int RightArray[] = new int [r];

        for (int i=0; i<l; ++i)
            LeftArray[i] = arr[beg + i];

        for (int j=0; j<r; ++j)
            RightArray[j] = arr[mid + 1+ j];


        int i = 0, j = 0;
        int k = beg;
        while (i<l&&j<r)
        {
            if (LeftArray[i] <= RightArray[j])
            {
                arr[k] = LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<l)
        {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<r)
        {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

}
