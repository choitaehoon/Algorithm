package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main_12 {

    static Map<Integer, String> hm = new HashMap<>();

    static {
        hm.put(1, "I");
        hm.put(5, "V");
        hm.put(10, "X");
        hm.put(50, "L");
        hm.put(100, "C");
        hm.put(500, "D");
        hm.put(1000, "M");
    }

    public String intToRoman(int num) {
        String res = "";
        int x = num;
        int mul = 1;
        String e = "";

        while(x > 0){
            int dummy = x % 10;

            if(dummy * mul >= 1 * mul && dummy * mul <= 3 * mul){
                for(int i=0; i < dummy; i++){
                    res = hm.get(1 * mul) + res;
                }

            } else if(dummy * mul == 4 * mul){
                res = hm.get(1 * mul) + hm.get(5 * mul) + res;

            } else if(dummy * mul >= 5*mul && dummy * mul <= 8*mul){
                e += hm.get(5 * mul);
                for(int i = 5; i < dummy; i++)
                    e += hm.get(1 * mul);
                res = e + res;
                e = "";

            } else if(dummy * mul == 9 * mul){
                res = hm.get(1 * mul) + hm.get(10 * mul) + res;

            } else if(dummy * mul == 10 * mul){
                res = hm.get(10 * mul) + res;

            }

            x /= 10;
            mul *= 10;
        }

        return res;
    }

}
