package Strings;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ConsecutiveElements {
    public static void main(String[] args) {
        String str="aabbcdd";
        Set<Character> set=new TreeSet<>();
        for (int i = 0; i <str.length(); i++) {
            set.add(str.charAt(i));
        }



        Iterator<Character> iterator = set.iterator();
        StringBuilder st= new StringBuilder();

        while(iterator.hasNext()){
            Character element = iterator.next();
            st.append(element);

        }

        System.out.println(st.toString());;

        }

}
