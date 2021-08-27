package leetcode.string;

public class Main_917 {

    public String reverseOnlyLetters(String s) {
        StringBuilder builder = new StringBuilder();

        for (char check : s.toCharArray()) {
            if (isCharacter(check)) {
                builder.append(check);
            }
        }

        builder.reverse();

        StringBuilder result = new StringBuilder();
        int index = 0;
        for(char check : s.toCharArray()) {
            if (Character.isUpperCase(check) || Character.isLowerCase(check)) {
                result.append(builder.toString().charAt(index++));
            } else {
                result.append(check);
            }
        }

        return result.toString();
    }

    public boolean isCharacter(char check) {
        return Character.isLowerCase(check) || Character.isUpperCase(check);
    }
}
