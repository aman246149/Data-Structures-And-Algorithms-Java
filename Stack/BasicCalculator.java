import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String str="(1+(4+5+2)-3)+(6+8)";
        int sum=0;
        int sign=1;
        Stack<Integer> st=new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (Character.isDigit(ch)) { //case 1
                // case 1.2 
                // ho sakta ha ki hampa koi multivalue 
                // digit aaya jaise ki
                // 123456 uss case ma hum 
                int val=0;
                while (i<str.length() && Character.isDigit(str.charAt(i))) {
                    val=val*10+(str.charAt(i)-'0'); //2*10+1=21
                    i++;
                }
                i--; //because our loop i goes 1 step forward
                val=val*sign;
                sign=1;
                sum+=val;
            }else if (ch=='(') {     //case 2
                st.push(sum);
                st.push(sign);
                sum=0;
                sign=+1;
            } else if(ch==')'){   //case 3 
                sum*=st.pop();  //this part containing sign
                sum+=st.pop();  //this.part containing value
            }else if (ch=='-') { //case 4
                sign*=-1;      //multiplying sign with -1
                            
            }

        }
        System.out.println(sum);
    }
}
