package medium;

import java.util.Arrays;
import java.util.List;

//다시 점검
public class Main638 {

    public static void main(String[] args) {
        System.out.println(shoppingOffers(
                Arrays.asList(2, 3, 4),
                Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)),
                Arrays.asList(0, 0, 0)
        ));
//        System.out.println(shoppingOffers(
//                Arrays.asList(2, 5),
//                Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)),
//                Arrays.asList(3, 2)
//        ));
    }

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minSum = Integer.MAX_VALUE;
        for (List<Integer> value : special) {
            int valueSize = value.size() - 1;
            int valueSum = 0;
            boolean isCheck = false;

            for (int i = 0; i < valueSize; ++i) {
                int specialNumber = value.get(i);
                int needsNumber = needs.get(i);
                int priceNumber = price.get(i);

                if (specialNumber < needsNumber) {
                    valueSum += (needsNumber - specialNumber) * priceNumber;
                } else if (specialNumber > needsNumber) {
                    isCheck = true;
                    break;
                }

            }

            if (isCheck)
                continue;

            valueSum += value.get(valueSize);

            if (valueSum <= 0)
                valueSum = 0;

            minSum = Math.min(minSum, valueSum);
        }

        return minSum == Integer.MAX_VALUE ? 0 : minSum;
    }


}
