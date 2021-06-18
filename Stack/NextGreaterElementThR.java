import java.util.Stack;

public class NextGreaterElementThR {
    public static void main(String[] args) {
        System.out.println("hello");
        int arr[]={2,5,9,3,1,12,6,8,7};
        int newarr[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
       
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size()>0 && arr[i]>arr[st.peek()]) {
                int pos=st.peek();
                newarr[pos]=arr[i];
                st.pop();
            }  

            st.push(i);
        }

        while (st.size()>0) {
            int pos=st.peek();
            newarr[pos]=-1;
            st.pop();
        }

        for (int i = 0; i < newarr.length; i++) {
            System.out.print(newarr[i]+ " ");
        }
        

        }
        
    }

