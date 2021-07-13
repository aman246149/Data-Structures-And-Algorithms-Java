package Recursion;

import java.util.ArrayList;

public class GetSubsequence {
    public static void main(String[] args) {
        String str="abc";
        System.out.println(gss(str));
    }

    private static ArrayList<String> gss(String str) {
        if (str.length()==0){
            ArrayList<String > result=new ArrayList<>();
            result.add("");
            return result;
        }
        char ch= str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> comingString=gss(ros);
            ArrayList<String> ans= new ArrayList<>();

        for(String r: comingString){
            ans.add(" "+r);
            ans.add(ch+r);
        }
            return ans;
    }
}
