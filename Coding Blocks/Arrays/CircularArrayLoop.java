package Arrays;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {


    static int next(int arr[],int i){
        return (i+arr[i]+arr.length)% arr.length;
    }

    static boolean CircularLoop(int nums[]){

//        int n=arr.length;
//        for (int i = 0; i < n; i++) {
//
//            if (arr[i]==0){
//                continue;
//            }
//
//            int slow=i,fast=i;
//
//            while(arr[slow]*arr[next(arr,slow)]>0 &&
//                    arr[fast]*arr[next(arr,fast)]>0 &&
//                    arr[fast]*arr[next(arr,next(arr,fast))]>0){
//
//                slow=next(arr,slow);
//                fast=next(arr,next(arr,fast));
//
//                if (slow==fast){
//                    //that means cycle is presenet but cycle length should be <1
//
//                    if (slow==next(arr,slow)){
//                        break;
//                    }
//                    return true;
//                }
//            }
//
//            slow=i;
//            int val=arr[slow];
//            while (val*arr[slow]>0){
//                int x=slow;
//                slow=next(arr,slow);
//                arr[slow]=0;
//            }
//        }
//
//        return  false;

        // record elements showed in all loops
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i <= nums.length - 1; i++){
            // jump elements tested before
            if(set.contains(i)) continue;

            // record elements showed in the current loop
            Set<Integer> cset = new HashSet<>();

            // record the previous index.
            int index = i, prev = i - 1;
            while(nums[i] * nums[index] > 0){
                // If the previous index is same as the current index, return false. Because the sequence's length must be greater than 1 to be a cycle.
                if(index == prev) break;
                else prev = index;

                //if the element show twice in the loop, it's cycle.
                if(cset.contains(index)) return true;
                else cset.add(index);

                //covert new index to the valid range
                index += nums[index];
                index = index % nums.length;
                if(index < 0) index += nums.length;
            }

            set.addAll(cset);
            if(set.size() == nums.length) return false;
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[]={2,-1,1,2,2};
        System.out.println(CircularLoop(arr));
    }
}
