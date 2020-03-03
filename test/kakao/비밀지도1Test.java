package kakao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class 비밀지도1Test {

    @ParameterizedTest
    @MethodSource("provideTest")
    public void test(int n, int [] arr1, int[] arr2, String[] expect) {
        assertArrayEquals(비밀지도1.solution(n, arr1, arr2), expect);
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}, new String[]{"#####","# # #", "### #", "#  ##", "#####"}),
                Arguments.of(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}, new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "})
        );
    }
}