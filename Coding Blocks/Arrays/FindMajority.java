package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FindMajority {
    public static void main(String[] args) {
        int arr[]={2,2,3,1,3,2,1,1};
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i],0);
            }else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        for (Map.Entry<Integer,Integer> count:map.entrySet()) {
            if (count.getValue()> arr.length/3){
                System.out.println(count.getKey());
            }

        }
    }
}
