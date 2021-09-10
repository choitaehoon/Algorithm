package leetcode.string;

import java.util.*;

public class Main_1190 {

    public static void main(String[] args) {
        System.out.println(reverseParentheses(
                "(ed(et(oc))el)"
        ));
    }

    public static String reverseParentheses(String s) {
        Stack<StringBuilder> st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(sb);
                sb=new StringBuilder();
            }
            else if(s.charAt(i)==')')
            {
                String rev=sb.reverse().toString();
                sb=st.pop();
                sb.append(rev);
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
