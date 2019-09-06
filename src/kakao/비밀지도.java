package kakao;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class 비밀지도 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6,new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
    }

    public static String[] solution(int n, int [] arr1, int[] arr2) {
        String[] array = new String[n];

        for (int i=0; i<n; ++i) {
            String arr1Value = spaceSet(Integer.toBinaryString(arr1[i]), n);
            String arr2Value = spaceSet(Integer.toBinaryString(arr2[i]), n);

            System.out.println(Integer.toBinaryString(arr1[i] | arr2[i]));

            StringBuilder builder = new StringBuilder();

            for (int j=0; j<arr1Value.length(); ++j) {
                if (arr1Value.charAt(j) == '0' && arr2Value.charAt(j) == '0') {
                    builder.append(" ");
                    continue;
                }
                builder.append("#");
            }

            array[i] = builder.toString();
        }

        return array;
    }

    //자리수 맞추기
    private static String spaceSet(String binary1, int n){
        StringBuilder builder = new StringBuilder(binary1);

        while (builder.length() != n)
            builder.insert(0,"0");

        return builder.toString();
    }

//    public String[] solution(int n, int[] arr1, int[] arr2) {
//        List<String> list = new ArrayList<>();
//
//        for (int i=0; i<n; ++i) {
//
//            StringBuilder compare1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
//            StringBuilder compare2 = new StringBuilder(Integer.toBinaryString(arr2[i]));
//
//            StringBuilder builder = new StringBuilder();
//
//            while (compare1.length() != n)
//                compare1.insert(0,"0");
//
//            while (compare2.length() != n)
//                compare2.insert(0,"0");
//
//            for (int j=0; j<n; ++j) {
//                if (compare1.toString().charAt(j) == '0' && compare2.toString().charAt(j) == '0') {
//                    builder.append(" ");
//                    continue;
//                }
//                builder.append("#");
//            }
//
//            list.add(builder.toString());
//        }
//
//        String[] answer = new String[list.size()];
//
//        for (int i=0; i<list.size(); ++i)
//            answer[i] = list.get(i);
//
//        return answer;
//    }
}
