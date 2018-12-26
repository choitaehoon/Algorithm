package 완전탐색1;

import java.util.Scanner;

public class Code_6603
{
    static int n;
    static int a[];
    static void go(int index, int cnt, String ans){
        if(index==n){
            if(cnt==6)
                System.out.println(ans);
            return;
        }
        go(index+1, cnt+1, ans+a[index]+" ");
        go(index+1, cnt, ans);
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(true){
            n = in.nextInt();
            if(n==0) break;
            a = new int[n];
            for(int i=0; i<n; i++)
                a[i] = in.nextInt();
            go(0,0,"");
            System.out.println();
        }
    }
}