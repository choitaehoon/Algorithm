package medium;

public class Main1529 {

    public static void main(String[] args) {
        System.out.println(minFlips(
                "10111"
        ));
    }

    public static int minFlips(String target) {
        int state=0;
        int n=target.length();
        int c=0;
        for(int i=0;i<n;i++){
            System.out.println(state);
            if(target.charAt(i)-'0'!= state){
                c++;
                state=target.charAt(i)-'0';
            }
        }
        return c;
    }

}
