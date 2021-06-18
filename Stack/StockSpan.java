import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int arr[]={4,4,7,6,3,4,6,1,9};

        Stack<Integer> st=new Stack<>();
        int newarr[]=new int[arr.length];

        st.push(0);
        newarr[0]=1;
        for (int i = 1; i < arr.length; i++) {
           
            int top=st.peek();
            if (top>arr[i]) {
                newarr[i]=i-top;
            }else{
                
            }
        }
    }
}
