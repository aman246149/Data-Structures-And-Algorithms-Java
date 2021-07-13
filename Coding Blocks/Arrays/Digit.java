package Arrays;

import java.io.*;
import java.util.*;

public class Digit{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }

        int n2=sc.nextInt();
        int arr2[]=new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }


        int n1back=arr1.length-1;
        int n2back= arr1.length-1;

        while(n2back>0){
            int diff=Math.abs(arr2[n2back]-arr1[n1back]);
            System.out.println(diff);
            n2back--;
        }

    }

}