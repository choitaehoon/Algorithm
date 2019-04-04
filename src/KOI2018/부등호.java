package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 부등호 {

    public static String[] maxInequality;
    public static int[] ascending = {9,8,7,6,5,4,3,2,1,0};
    public static String[] minInequality;
    public static int[] descendingOrder = {0,1,2,3,4,5,6,7,8,9};
    public static int givenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        maxInequality = buffer.readLine().split(" ");
        minInequality = maxInequality.clone();

        getAscending(0);
        for (int i=0; i<=givenNumber; ++i)
            System.out.print(ascending[i]);

        System.out.println();

        getdescendingOrder(0);
        for (int i=0; i<=givenNumber; ++i)
            System.out.print(descendingOrder[i]);
    }

    public static void getAscending(int index) {
        if (index < 0  || index >= givenNumber)
            return;
        else {
            if (maxInequality[index].equals("<") && ascending[index] > ascending[index+1]) {
                swap(index,index+1,ascending);
                getAscending(index-1);
            }
            getAscending(index+1);
        }
    }

    public static void getdescendingOrder(int index) {
        if (index < 0  || index >= givenNumber)
            return;

        else {
            if (minInequality[index].equals(">") && descendingOrder[index] < descendingOrder[index+1]) {
                swap(index,index+1,descendingOrder);
                getdescendingOrder(index-1);
            }
            getdescendingOrder(index+1);
        }
    }

    public static void swap(int i,int j, int ...array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
