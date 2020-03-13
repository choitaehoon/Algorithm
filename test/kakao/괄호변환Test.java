package kakao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 괄호변환Test {

    @ParameterizedTest
    @MethodSource("provideTest")
    public void test(String word, String expected) {
        assertThat(괄호변환.solution(word)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of("(()())()", "(()())()"),
                Arguments.of(")(", "()"),
                Arguments.of("()))((()", "()(())()")
        );
    }

}