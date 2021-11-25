package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 압축 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        Stack<Integer> len = new Stack<>();
        Stack<Integer> mul = new Stack<>();

        int cnt=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                cnt-=1;
                int mulNum = str.charAt(i-1)-'0';
                len.add(cnt);
                mul.add(mulNum);
                cnt=0;
            }
            else if(c==')'){
                int val = mul.pop();
                int plus = len.pop();
                val*=cnt;
                cnt = plus + val;
            }
            else  cnt++;     //숫자
        }
        System.out.print(cnt);
    }

}
