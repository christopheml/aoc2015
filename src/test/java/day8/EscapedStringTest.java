package day8;

import java.util.List;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class EscapedStringTest {

    @Test
    void emptyString() {
        var empty = new EscapedString("\"\"");
        assertThat(empty.codeLength()).isEqualTo(2);
        assertThat(empty.contentLength()).isEqualTo(0);
        assertThat(empty.encodedLength()).isEqualTo(6);
    }

    @Test
    void simpleString() {
        var simple = new EscapedString("\"abc\"");
        assertThat(simple.codeLength()).isEqualTo(5);
        assertThat(simple.contentLength()).isEqualTo(3);
        assertThat(simple.encodedLength()).isEqualTo(9);
    }

    @Test
    void simpleEscape() {
        var withSimpleEscape = new EscapedString("\"aaa\\\"aaa\"");
        assertThat(withSimpleEscape.codeLength()).isEqualTo(10);
        assertThat(withSimpleEscape.contentLength()).isEqualTo(7);
        assertThat(withSimpleEscape.encodedLength()).isEqualTo(16);
    }

    @Test
    void hexadecimalEscape() {
        var withHexadecimalEscape = new EscapedString("\"\\x27\"");
        assertThat(withHexadecimalEscape.codeLength()).isEqualTo(6);
        assertThat(withHexadecimalEscape.contentLength()).isEqualTo(1);
        assertThat(withHexadecimalEscape.encodedLength()).isEqualTo(11);
    }

    @Test
    void fakeEscape() {
        var fakeEscape = new EscapedString("\"\\\\x64\"");
        assertThat(fakeEscape.codeLength()).isEqualTo(7);
        assertThat(fakeEscape.contentLength()).isEqualTo(4);
    }

    @Test
    void acceptance_test() {
        List<EscapedString> strings = asList(
                new EscapedString("\"\""),
                new EscapedString("\"abc\""),
                new EscapedString("\"aaa\\\"aaa\""),
                new EscapedString("\"\\x27\"")
        );

        int overhead = strings.stream().mapToInt(EscapedString::overhead).sum();
        assertThat(overhead).isEqualTo(12);

        int encodingOverhead = strings.stream().mapToInt(EscapedString::encodedOverhead).sum();
        assertThat(encodingOverhead).isEqualTo(19);
    }

}