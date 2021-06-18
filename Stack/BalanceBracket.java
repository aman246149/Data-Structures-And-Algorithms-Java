import java.util.Stack;

public class BalanceBracket {
    public static void main(String[] args) {
        String str="[(a + b) + {(c + d) * (e / f)]} ";
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
           char ch= str.charAt(i);

           if (ch==']' || ch==')' || ch=='}') {
                    while (!st.isEmpty()) {
                        char ls=st.pop();
                        if (ls=='[' ||ls== '(' ||ls== '{') {
                            break;
                        }
                    }
                   
               
           } else{
            st.push(ch);
        }
        }
        System.out.println(st);
        if (st.isEmpty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
