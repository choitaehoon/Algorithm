package 투포인터;

public class Main_392 {

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;

        if(s.equals(t))
            return true;

        for(int i=0;i<t.length();i++){

            if(t.charAt(i)==s.charAt(0)){
                return isSubsequence(s.substring(1),t.substring(i+1));
            }
        }

        return false;
    }

}
