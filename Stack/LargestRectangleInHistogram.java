import java.util.Stack;

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
