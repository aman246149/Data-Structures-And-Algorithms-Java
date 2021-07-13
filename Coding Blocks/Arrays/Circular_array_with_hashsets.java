package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Circular_array_with_hashsets {
    public static void main(String[] args) {
        int[] arr ={-1,-1,-1,2,-2};
        System.out.println(circularArrayLoop(arr));
    }

    private static boolean circularArrayLoop(int[] arr) {

        int length= arr.length;

        for (int start = 0; start < length; start++) {

            Set<Integer> checked=new HashSet<>();
            int cur=start,count=0,sign=arr[start] >0 ?1:-1;

            System.out.println(cur);
            System.out.println(start);
            while (!checked.contains(cur) && arr[cur]*sign>0){
                checked.add(cur);
                cur = ((cur + arr[cur]) % length + length) % length;
                ++count;
                if (cur == start && count > 1) return true;

            }

        }

        return  false;
    }
}
