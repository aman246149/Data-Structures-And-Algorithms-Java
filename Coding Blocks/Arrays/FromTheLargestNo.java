package Arrays;

import java.util.Comparator;
import java.util.*;

class FromTheLargestNo {
    String printLargest(String[] arr) {
        // code here

        Arrays.sort(arr,new Comparator<String>(){

            @Override
            public int compare(String x,String y){

                String xy=x+y;
                String yx=y+x;

                return xy.compareTo(yx)>0?-1:1;

            }
        });

        String s="";
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
        }

        return s;
    }
}
