import java.util.Stack;

public class DuplicateBRackets {
    public static void main(String[] args) {
        String str="(a + b) + ((c + d))";
        System.out.println(isDuplicate(str));
    }

    private static boolean isDuplicate(String str) {
        Stack<Character> st=new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (ch==')') {
                while (!st.isEmpty()) {
                    char lh=st.pop();
                    if (lh=='(') {
                        break;
                    }
                }
            }else{
                st.push(ch);
            }
        }

        if (st.isEmpty()) {
            return false;
        }
        else return true;
        
    }
}
