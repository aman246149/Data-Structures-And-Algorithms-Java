import java.util.*;


class RemoveDuplicatesLetter {
    public String removeDuplicateLetters(String s) {

         int count[] = new int[26];
        boolean added[] = new boolean[26];
        
        for(int i=s.length()-1;i>=0;i--)count[s.charAt(i)-'a']++; //count frequency of every letter
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(added[c-'a']){  // if that element is already visited
                count[c-'a']--; //decrease its count
                continue;
            }
            while(st.size() > 0 && st.peek() > c && count[st.peek()-'a'] > 0){ //if previous element is greate and it have
                //count remaining pop it from stack and make it false
                added[st.pop()-'a'] = false;
            }
            
            st.add(c);//add element in stack and make true and decrement count
            added[c-'a'] = true; //make it true
            count[c-'a']--;
        }
        
        char ch[] = new char[st.size()];
        int i = ch.length-1;
        while(i>=0)ch[i--] = st.pop();
        
        return new String(ch);
    }
}