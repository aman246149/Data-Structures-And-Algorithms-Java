import java.util.Stack;

/*
create output array
push from last
arr[i] > st.peek()  matlab current element is greater than previous element
update output array

if current element  greater than previous element
than pop from stack till 
case1 stack is empty
case2 stack is not empty means stack top is greater than current element
*/

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