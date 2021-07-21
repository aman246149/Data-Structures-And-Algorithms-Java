import java.util.*;
/*

Uses Sliding Window Algorithm with the help of QUEUE

*sum ma data add karenga
*q ma data add karenga
*q ka size > window ka size sa jyada ho jaaya toh 
sum ma sa que ka first element minus kardo 

calculate avg=sum/q.size()
return avg;



*/




public class MovingAverageData {
    public static class MovingAverage {
      LinkedList<Integer> q;
      int size;
      double sum;
      
      public MovingAverage(int size) {
        q = new LinkedList();
        this.size = size;
        sum = 0;
      }
  
      public double next(int val) {
        q.addLast(val);  //add in queue
        sum += val;      //add in sum
        if (q.size() > size) { //que size is greater than window size
          sum = sum-q.removeFirst(); //removing 1st element from que and sum value
        }
         
        return (double)(sum) / q.size(); //returning value after converting into double
      }
    }
}