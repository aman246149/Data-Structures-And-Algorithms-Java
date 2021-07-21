import java.util.*;

// range []
class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q=new LinkedList<>();
    }
 
    // range btw [t-3000]
    public int ping(int t) {
        q.add(t);
        int min=t-3000;
        while(q.peek()<min)q.remove();
        return q.size();
    }
}