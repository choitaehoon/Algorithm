public class Main {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("a").append("c").append("e").append("q").append("u");
        builder.delete(2,3);
        String temp = builder.toString();
        System.out.println(temp);
    }
}