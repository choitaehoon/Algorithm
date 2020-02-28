package 문자열;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class 자물쇠와열쇠Test {

    @ParameterizedTest
    @MethodSource("testExample")
    public void test(int[][] key, int[][] lock, boolean expect) {
        final boolean result = 자물쇠와열쇠.solution(key, lock);

        assertEquals(result, expect);
    }

    private static Stream<Arguments> testExample() {
        return Stream.of(
                Arguments.of(new int[][]{{0,0,0}, {1,0,0}, {0,1,1}},
                             new int[][]{{1,1,1}, {1,1,0}, {1,0,1}}, true)
        );
    }
}