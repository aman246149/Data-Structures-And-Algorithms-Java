package TwoDarray;

import java.util.Scanner;

public class TwoDArrayConcept {
    public static void main(String[] args) {
        int [][] arr=new int[3][3];

        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                    arr[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            if(i%2==0){
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j][i]+" ");;
            }}else{
                    for (int j = arr.length-1; j >= 0; j--) {
                        System.out.print(arr[j][i]+" ");;
                }

            }
            System.out.println();
        }
    }
}
