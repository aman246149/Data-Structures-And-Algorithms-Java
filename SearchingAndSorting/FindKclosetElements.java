


/*
find k closet elements in java using priority queue
LeetCode 658

*/


class Solution {
    public class pair implements Comparable <pair>{
        int val;
        int gap;
        
        pair(int val,int gap){
            this.val=val;
            this.gap=gap;
        }
        
        public int compareTo(pair obj){
            if(this.gap==obj.gap){
                return this.val-obj.val;
            }else{
                return this.gap-obj.gap;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        PriorityQueue<pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(new pair(arr[i],Math.abs(arr[i]-x)));
            }else{
                if(pq.peek().gap>Math.abs(arr[i]-x)){
                    pq.remove();
                    pq.add(new pair(arr[i],Math.abs(arr[i]-x)));
                }
            }
        }
        
        while(pq.size()>0){
            pair rem=pq.remove();
            ans.add(rem.val);
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
}