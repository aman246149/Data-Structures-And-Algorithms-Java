package Arrays;

import java.util.HashMap;
import java.util.Map;

public class WordDistance {

    public static void main(String[] args) {
        String[] str ={"kartik","bhaiya","teaches","coading"};
        String w1="kartik";
        String w2="teaches";
        int w1index=0;
        int w2index=0;
        Map<String ,Integer> map=new HashMap<>();
        for (int i = 0; i < str.length; i++) {
           map.put(str[i],i);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(w1)){
                w1index=map.get(w1);
            }

            if (map.containsKey(w2)){
                w2index=map.get(w2);
            }
        }

        int ans=Math.abs(w1index-w2index);
        System.out.println(ans);
    }
}
