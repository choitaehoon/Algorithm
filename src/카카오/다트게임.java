package 카카오;

public class 다트게임 {
    public static void main(String[] args) {
        System.out.println(solution("1D20S#10S"));
    }

    public static int solution(String dartResult) {
        int[] arraySum = new int[3];
        int index = 0;
        int sum = 0;
        int sumSub = 0 ;
        int i =1;

        if (48 <= dartResult.charAt(1) && dartResult.charAt(1) <= 57) {
            sumSub = Integer.parseInt(String.valueOf(dartResult.charAt(0))+ dartResult.charAt(1));
            i++;
        }
        else
            sumSub = Character.getNumericValue(dartResult.charAt(0));

        for (; i<dartResult.length(); ++i) {
            if (48 <= dartResult.charAt(i) && dartResult.charAt(i) <= 57) {
                if (i+1 <= dartResult.length() && 48 <= dartResult.charAt(i+1) && dartResult.charAt(i+1) <= 57) {
                    arraySum[index++] += sumSub;
                    sumSub = Integer.parseInt(String.valueOf(dartResult.charAt(i))+ dartResult.charAt(i + 1));
                    i++;
                }
                else {
                    arraySum[index++] += sumSub;
                    sumSub = Character.getNumericValue(dartResult.charAt(i));
                }
                continue;
            }

            if (dartResult.charAt(i) == 'D')
                sumSub = (int) Math.pow(sumSub,2);
            else if (dartResult.charAt(i) == 'T')
                sumSub = (int) Math.pow(sumSub,3);
            else if (dartResult.charAt(i) == '*') {
                sumSub *= 2;
                if (index >= 1) arraySum[index-1]*= 2;
            }
            else if (dartResult.charAt(i) == '#')
                sumSub *= -1;
        }

        arraySum[2] += sumSub;
        for (int j=0; j<3; ++j)
            sum += arraySum[j];
        return sum;
    }

}
