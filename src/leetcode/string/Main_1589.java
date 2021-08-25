package leetcode.string;

public class Main_1589 {

    public  int minOperations(String[] logs) {
        String temp = "";
        for (String word : logs) {

            if (word.equals("./")) {
                continue;
            }

            if (word.equals("../")) {
                if (temp.length() == 0)
                    continue;

                String[] store = temp.split(" ");
                temp = "";

                for (int i = 0; i < store.length - 1; ++i) {
                    if (temp.length() == 0)
                        temp = temp + store[i];
                    else
                        temp = temp + " "+ store[i];
                }

            } else {
                if (temp.length() == 0)
                    temp = temp + word.substring(0, word.length() - 1);
                else
                    temp = temp + " " + word.substring(0, word.length() - 1);
            }
        }

        if (temp.length() == 0)
            return 0;

        return temp.split(" ").length;
    }

    public int minOperations1(String[] logs) {
        int count = 0;

        for (String word : logs) {
            if (word.equals("./"))
                continue;

            if (word.equals("../")) {
                count = count == 0 ? 0 : count - 1;
            } else {
                count++;
            }
        }

        return count;
    }
}
