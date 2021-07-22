
import java.io.*;
import java.util.*;


/*
perform different operatiion on stack
1. push
2. pop
3. peekMax
4. popMax
5. popTop
6. top
*/

 class Max {
  public static class MaxStack {

Stack<Integer> data,max;

    public MaxStack() {
        data=new Stack<>();
        max=new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        
        int m=x;
        if(max.size()>0){
           m= Math.max(m,max.peek());
        }
        max.push(m);
    }

    public int pop() {
        max.pop();
      return data.pop();
    }

    public int top() {
      return data.peek();
    }

    public int peekMax() {
      return max.peek();
    }

    public int popMax() { //pop max element
        int tbr=max.peek(); //take max element from max stack
        
        Stack<Integer> buffer=new Stack<>(); //create buffer stack
        while(data.peek()!=tbr){
            int res=pop(); //pop function pop max and data 
            buffer.push(res);
        }
        
        pop();   //pop max element here
        
        while(buffer.size()>0){
        int res=  buffer.pop();
        push(res);  //push data in original stack
        }
        
      return tbr;  //return popmax element
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();

    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}
