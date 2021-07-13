import java.util.Stack;

class CovertInfixIntoPostAndPre{
    public static void main(String[] args) {
        
        String input="a*(b-c+d)/e";
        //creating three stack 
        Stack<String> post=new Stack<>();
        Stack<String> pre=new Stack<>();
        Stack<Character> ops=new Stack<>();

        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);

            if (ch=='(') {  //agar bracket empty ha
                ops.push(ch);
            }else if ((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')) {
              //agar hamara character belong karta ha inma sa kahi 
            
              post.push(ch+"");
              pre.push(ch+"");
            }else if(ch==')'){//agar closing bracket aagaya toh

                while (ops.peek()!='(') {
                    char op=ops.pop();

                    String postv2=post.pop();
                    String postv1=post.pop();
                    String postv=postv1+postv2+op;
                    post.push(postv);

                    String prev2=pre.pop();
                    String prev1=pre.pop();
                    String pretv=op+prev1+prev2;
                    pre.push(pretv);
                }
                ops.pop();
            }else if(ch=='+' || ch=='-' || ch=='*' || ch== '/'){
                 //agar inma sa koi operator aagaya toh

                 while (ops.size()>0 &&  ops.peek()!='('  && precedence(ch)<=precedence(ops.peek()) ) {
                    char op=ops.pop();

                    String postv2=post.pop();
                    String postv1=post.pop();
                    String postv=postv1+postv2+op;
                    post.push(postv);

                    String prev2=pre.pop();
                    String prev1=pre.pop();
                    String pretv=op+prev1+prev2;
                    pre.push(pretv);
                }
                ops.push(ch);
            }

        }

        while (ops.size()>0 ) {
       char op=ops.pop();

       String postv2=post.pop();
       String postv1=post.pop();
       String postv=postv1+postv2+op;
       post.push(postv);

       String prev2=pre.pop();
       String prev1=pre.pop();
       String pretv=op+prev1+prev2;
       pre.push(pretv);
   }

   System.out.println(post.pop());
   System.out.println(pre.pop());
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