package kakao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class n진수게임Test {

    @ParameterizedTest
    @MethodSource("provideCode")
    public void testCode(int n, int t, int m, int p, String expected) {
        assertEquals(n진수게임.solution(n, t, m, p), expected);
    }

    private static Stream<Arguments> provideCode() {
        return Stream.of(
                Arguments.of(2, 4, 2, 1, "0111"),
                Arguments.of(16, 16, 2, 1, "02468ACE11111111"),
                Arguments.of(16, 16, 2, 2, "13579BDF01234567")
        );
    }
}