package Leetcode;

import java.util.HashMap;
import java.util.Map;

class WordFilter {
    public static void main(String[] args) {
        String str="amanisahero";
        for (int i = 0; i < str.length(); i++) {
            str=str.substring(i)+"#"+str.substring(str.length()-1-i);
            System.out.println(str);
        }
    }


}