package Stack;

import java.util.Stack;

public class SheldonCooperAndStrings {

    static  String removeDuplicatesLetters(String s){
        int []freq=buildFreq(s);
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            freq[ch-'a']--;
            if (st.contains(ch)){
                    continue;
            }

            while (!st.isEmpty() && st.peek() >ch && freq[st.peek()-'a']>0){
                st.pop();
            }

            st.push(ch);
        }

        StringBuilder result=new StringBuilder();
        while (!st.isEmpty()){
            result.append(st.pop());

        }
        return  result.reverse().toString();
    }

    private static int[] buildFreq(String s) {
        int[] freq=new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        return freq;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatesLetters("cbacdcbc"));
    }
}
