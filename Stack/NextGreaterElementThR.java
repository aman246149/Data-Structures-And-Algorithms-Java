import java.util.Stack;

public class NextGreaterElementThR {
    public static void main(String[] args) {
        int arr[]={2,5,9,3,1,12,6,8,7};
        int data[]=solve(arr);
        for (int i : data) {
          System.out.print(i+" ");
        }
        
    }

    public static int[] solve(int[] arr) {
        int[] nge = new int[arr.length];
    
        Stack<Integer> st = new Stack<>();
    
        nge[arr.length - 1] = -1;
        st.push(arr[arr.length - 1]);
        for(int i = arr.length - 2; i >= 0; i--){
          while(st.size() > 0 && arr[i] >= st.peek()){
            st.pop();
          }     
          if(st.size() > 0){
            nge[i] = st.peek();
          } else {
            nge[i] = -1;
          }
          
          st.push(arr[i]);
        }
    
        return nge;
      }

}