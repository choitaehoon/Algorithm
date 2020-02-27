package 문자열;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

class compressStringTest {

    @ParameterizedTest
    @MethodSource("provideText")
    void testCompress(String text, int expected) {

        compressString compress = new compressString();

        int length = compress.solution(text);

        assertEquals(length, expected);
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