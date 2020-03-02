package kakao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class 압축Test {

    @ParameterizedTest
    @MethodSource("provideTest")
    public void testCode(String msg, int ... expected) {
        assertArrayEquals(압축.solution(msg), expected);
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of("KAKAO", new int[]{11, 1, 27, 15}),
                Arguments.of("TOBEORNOTTOBEORTOBEORNOT", new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}),
                Arguments.of("ABABABABABABABAB", new int[]{1, 2, 27, 29, 28, 31, 30})
        );
    }
}