package Stack;

import java.util.Stack;

public class ShriRam_Arrow_Algo {
    public static void main(String[] args) {
        int arr[]={1,-1,2,-5,7,-6,-5,3,-5,10};

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if (!st.isEmpty() && st.peek()>0 && arr[i]<0){
                boolean flag=true;

                while (!st.isEmpty() && st.peek()>0 && arr[i]<0){
                    if (Math.abs(st.peek())==Math.abs(arr[i])){
                        st.pop();
                        flag=false;
                        break;
                    }else if (Math.abs(st.peek())<Math.abs(arr[i])){
                        st.pop();
                        flag=true;
                    } else if (Math.abs(st.peek())>Math.abs(arr[i])){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    st.push(arr[i]);
                }

            }else{
                st.push(arr[i]);
            }
        }

        Stack<Integer> ans=new Stack<>();

        while (!st.isEmpty())
        {
            ans.push(st.peek());
            st.pop();
        }

        while (!ans.isEmpty()){
            System.out.println(ans.peek());
            ans.pop();
        }

    }
}
