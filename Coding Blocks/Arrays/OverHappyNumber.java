package Arrays;

import java.util.HashSet;
import java.util.Set;

class OverHappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        boolean ans=checkNo(set,n);
        return ans;
    }

    public boolean checkNo(Set<Integer> set,int n){
        if(n==1){
            return true;
        }

        if(set.contains(n))
        {
            return false;
        }

        set.add(n);
        n=updateno(n);

        return checkNo(set,n);
    }

    public int updateno(int n){
        int sum=0;
        while(n>0){
            int digit=0;
            digit=n%10;
            sum+=digit*digit;
            n=n/10;
        }
        return  sum;
    }
}