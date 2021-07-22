import java.util.Stack;

/*
Largest Rectangle in Histogram
    
why we store index in this problem
1-> Bacially in this we have to find the largest rectangle in histogram.so largest area will be difference in index * height.
2-> So if we store index in this problem then we can find the largest rectangle in histogram.
3-> so we create left array for storing index of left side of rectangle.
3.1-> todo clear the stack
4-> we create right array for storing index of right side of rectangle.
5-> find max area.
6-> by simply using  for a particualr index we calulate its width =rightlimit-leftlimit+1
7-> than we calculate area by using area=width*arr[i];  where arr[i] is height of rectangle.]
8->than calulate max area. maxarea=Math.max(area,maxarea);



*/

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};

        int max=largestRectangleArea(arr);
        System.out.println(max);
    }

    private static int largestRectangleArea(int[] arr) {
        int maxarea=0;
        Stack<Integer> st=new Stack<>();
        int[] leftpart=new int[arr.length];
        int[] rightpart=new int[arr.length];

        //calculating leftpart
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                leftpart[i]=0;
            }else{
                leftpart[i]=st.peek()+1;
            }
            st.push(i);
        }

        st.clear();

        //calculating right part
        for (int i = arr.length-1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            if(st.empty()){
                rightpart[i]=arr.length-1;
            }else{
                rightpart[i]=st.peek()-1;
            }
            st.push(i);
        }

        //calculating max area
        for(int i=0;i<arr.length;i++)
        {
            int width = rightpart[i] - leftpart[i] +1;
            int area = width*arr[i];
            maxarea = Math.max(maxarea,area);
        }


        return maxarea;
    }
}
