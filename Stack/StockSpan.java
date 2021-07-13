import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int arr[]={4,4,7,6,3,4,6,1,9};
        int[] output=solve(arr);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]+" ");
        }
      }

      public static int[] solve(int[] arr) {
        int[] span = new int[arr.length];
    
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
    
        for (int i = 1; i < arr.length; i++) {
          while(st.size() > 0 && arr[i] > arr[st.peek()]){
            st.pop();
          }
    
          if(st.size() == 0){
            span[i] = i + 1;
          } else {
            span[i] = i - st.peek();
          }
    
          st.push(i);
        }
    
        return span;
      }
}
