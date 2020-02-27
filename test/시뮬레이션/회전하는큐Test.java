package 시뮬레이션;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class 회전하는큐Test {

    @ParameterizedTest
    @MethodSource("provideText")
    public void test(int n, List<Integer> list, int expect) {
        final int result = 회전하는큐.solution(n,list);

        assertEquals(result, expect);
    }

    private static Stream<Arguments> provideText() {
        return Stream.of(
                Arguments.of(10, new ArrayList<>(Arrays.asList(1,2,3)), 0),
                Arguments.of(10, new ArrayList<>(Arrays.asList(2,9,5)), 8),
                Arguments.of(32, new ArrayList<>(Arrays.asList(27, 16, 30, 11, 6, 23)), 59),
                Arguments.of(10, new ArrayList<>(Arrays.asList(1, 6, 3, 2, 7, 9, 8, 4, 10, 5)), 14)
        );
    }

}