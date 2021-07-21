import java.io.*;
import java.util.*;

//using both caluculation 1 and caluculation 2 tactic

 class Main {
  static class Pair {   //creating pair class to store previous stack and sign
    Stack<Integer> stP;
    char sign;

    Pair(Stack<Integer> st, char s) {
      stP = st;
      sign = s;
    }
  }

  public static int calculate(String s) {   //using calculate 2 tactic here
    Stack<Pair> stP = new Stack<>();       //creating new pair type stack 
    Stack<Integer> st = new Stack<>();
    int n = s.length();
    char sign = '+';
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (Character.isDigit(ch)) {
        int val = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
          val = val * 10 + (s.charAt(i) - '0');
          i++;
        }
        i--;
        cal(st, sign, val);
      } else

        if (ch == '(') {                       //handling open breaacket
          stP.push(new Pair(st, sign));         //store current stack  and sign
          sign = '+';       
          st = new Stack<>();                   //reset stack for new upcoming data
        } else if (ch == ')') {//handling closing bracket
          Pair p = stP.pop();  //pop previous data from stack
          int sum = 0;
          while (st.size() > 0)  //calcutate data 
            sum += st.pop();
          st = p.stP;  
          sign = p.sign;
          cal(st, sign, sum);
        } else if (ch != ' ') {
          sign = ch;
        }
    }

    int sum = 0;
    while (st.size() > 0)
      sum += st.pop();

    return sum;
  }

  public static void cal(Stack<Integer> st, char sign, int val) {
    if (sign == '+') {
      st.push(val);
    } else if (sign == '-') {
      st.push(-val);
    } else if (sign == '*') {
      int a = st.pop();
      int ans = a * val;
      st.push(ans);
    } else if (sign == '/') {
      int a = st.pop();
      int ans = a / val;
      st.push(ans);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int result = calculate(read.readLine());
    System.out.println(result);

  }
}

                                
                                