import java.util.Stack;

/*
priority dakni ha
* / KI PRIORITY SAME HA
+ - KI SAME HA
ONLY FOR SINGLE DIGIT
*/

public class InfixEvaluation {
    public static void main(String[] args) {
        String input="2+(5-3*6/2)";
        Stack<Integer> opnds=new Stack<>();
        Stack<Character> optors=new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch=input.charAt(i);

            if(ch=='('){
                optors.push(ch);
            }else if(Character.isDigit(ch)){
                opnds.push(ch-'0'); //converting char into integer
            }else if (ch==')') {//agar closing bracket ha toh tab tak pop karenga jab tak closing bracket nahi aa jaya
                while (optors.peek()!='(') {
                    char optor=optors.pop(); //jab ek pop karta ha operators ma tab do(2) pop karta ha operands ma  taaki operation perform kar paaya
                    int v2=opnds.pop();
                    int v1=opnds.pop();
                    
                    int opv=operation(v1, v2, optor);//perform operation and push it into stack so that it available for necxt operation
                    opnds.push(opv);

                }
                optors.pop();//ek pop  ( or karenga kyu ki uppar valli condition sa closing bracket nahi nikal paya tha

            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while (optors.size()>0 && optors.peek()!='(' && precedence(ch)<=precedence(optors.peek())) { 
                    // tab tak pop karenga jab tak closing bracket nahi mill jaata ya phir hamsa badi priority wala nahi mill jaata
                    
                    //ch is wanting higher priority operators to solve first

                    char optor=optors.pop(); //jab ek pop karta ha operators ma tab do(2) pop karta ha operands ma  taaki operation perform kar paaya
                    int v2=opnds.pop();
                    int v1=opnds.pop();
                    
                    int opv=operation(v1, v2, optor);//perform operation and push it into stack so that it available for necxt operation
                    opnds.push(opv);

                }
                //ch is pushing itself now
                optors.push(ch); 
                }
            }

            while (optors.size()!=0) {
                char optor=optors.pop(); //jab ek pop karta ha operators ma tab do(2) pop karta ha operands ma  taaki operation perform kar paaya
                int v2=opnds.pop();
                int v1=opnds.pop();
                
                int opv=operation(v1, v2, optor);//perform operation and push it into stack so that it available for necxt operation
                opnds.push(opv);

            }

            System.out.println(opnds.peek());

        }

    

    public static int precedence(char optor){
        if(optor=='+'){
            return 1;
        }else if(optor=='-'){
            return 1;
        }else if(optor=='*'){
            return 2;
        }else{
            return 2;
        }
    }

    public static int operation(int v1,int v2,char optor){
        if(optor=='+'){
            return v1+v2;
        }else if(optor=='-'){
            return v1-v2;
        }else if(optor=='*'){
            return v1*v2;
        }else{
            return v1/v2;
        }
    }
}
