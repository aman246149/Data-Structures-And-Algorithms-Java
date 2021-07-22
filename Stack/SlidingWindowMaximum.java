import java.util.ArrayList;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
    int windowSize=3;
    //Output: [3,3,5,5,6,7]
    
    //firstly we have to find nextgreater element 
    //index-->here index is important 
    // we have to store index in our next greater element array
    //because we have to check if that index exist in our window or not

    int nextgreaterElementIndex[]=new int[arr.length];
    Stack<Integer> st=new Stack<>();
    
    st.push(arr.length-1);
    nextgreaterElementIndex[arr.length-1]=arr.length;

    for(int i=arr.length-2;i>=0;i--){
        while (st.size()>0 && arr[i]>=arr[st.peek()]) {
            st.pop();
        }

        if(st.size()==0){
            nextgreaterElementIndex[i]=arr.length;
        }else{
            nextgreaterElementIndex[i]=st.peek();
        }

        st.push(i);
        
    }

    int j=0;

    for(int i=0;i<=arr.length-windowSize;i++){  //chalega window size sa phela tak taaki overflow na ho jaaya
        if(j<i){
            j=i;
        }

        while(nextgreaterElementIndex[j]<i+windowSize){
            j=nextgreaterElementIndex[j];
        }
        System.out.print(arr[j]+" ");
    }

      
 }
}
