package Arrays;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandyGirlAndBoy {
    public static void main(String[] args) {
        int arr[]={1,1,2,2,3,3};

        int n= arr.length/2;

        Set<Integer> set=new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);

        }
        int ans=Math.min(n,set.size());
        System.out.println(ans);
    }
}
