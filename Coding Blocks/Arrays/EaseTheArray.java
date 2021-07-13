package Arrays;

public class EaseTheArray {
    public static void main(String[] args) {
        int[] arr={0,2,2,2,0,6,6,0,0,8};
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1])
            {
                arr[i]=2*arr[i];
                arr[i+1]=0;
            }
        }
        //perform swapping

        int count=0;
        for(int j=0;j< arr.length;j++)
        {
            if(arr[j]!=0)
            {
                arr[count++]=arr[j];
            }
        }
        while(count<arr.length)
        {
            arr[count]=0;
            count++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
