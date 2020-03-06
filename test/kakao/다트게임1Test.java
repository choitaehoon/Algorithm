package kakao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class 다트게임1Test {

    @ParameterizedTest
    @MethodSource("provideTest")
    public void test(String dartResult, int expected) {
        assertEquals(다트게임다시풀기1.solution(dartResult), expected);
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of("1S2D*3T", 37),
                Arguments.of("1D2S#10S", 9),
                Arguments.of("1D2S0T", 3),
                Arguments.of("1S*2T*3S", 23),
                Arguments.of("1D#2S*3S", 5),
                Arguments.of("1T2D3D#", -4),
                Arguments.of("1D2S3T*", 59)
        );
    }
}