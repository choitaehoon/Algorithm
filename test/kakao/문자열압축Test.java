package kakao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 문자열압축Test {

    @ParameterizedTest
    @MethodSource("provideText")
    public void test(String text, int expected) {
        assertThat(문자열압축.solution2(text)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideText() {
        return Stream.of(
                Arguments.of("aabbaccc", 7),
                Arguments.of("ababcdcdababcdcd", 9),
                Arguments.of("abcabcdede", 8),
                Arguments.of("abcabcabcabcdededededede", 14),
                Arguments.of("xababcdcdababcdcd", 17)
        );
    }
}