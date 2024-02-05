
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class StringHelperTests {

    @ParameterizedTest
    @MethodSource("ProvideStringsForIsNullOrWhitespaceTesting")
    public void IsNullOrWhitespace(String text, boolean expected){
        assertEquals(expected, StringHelper.IsNullOrWhitespace(text));
    }
    @ParameterizedTest
    @MethodSource("ProvideStringsForRemoveCarriageReturns")
    public void RemoveCarriageReturns(String text, String expected){
        assertEquals(expected, StringHelper.RemoveReturns(text));
    }

    private static Stream<Arguments> ProvideStringsForIsNullOrWhitespaceTesting(){
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("     ", true),
                Arguments.of("Not Empty", false),
                Arguments.of("     Not Empty", false),
                Arguments.of("Not Empty       ", false),
                Arguments.of("     Not Empty     ", false)
        );
    }

    private static Stream<Arguments> ProvideStringsForRemoveCarriageReturns(){
        String expected = "This is a line. This is another line. Finally the last line.";

        Arguments textBlock = Arguments.of("""
        This is a line.
        This is another line.
        Finally the last line.""", expected);

        Arguments carriageReturnWindows = Arguments.of("This is a line.\r\nThis is another line.\r\nFinally the last line.", expected);
        Arguments carriageReturnOlderMacintosh = Arguments.of("This is a line.\rThis is another line.\rFinally the last line.", expected);
        Arguments newlines = Arguments.of("This is a line.\nThis is another line.\nFinally the last line.", expected);
        Arguments mixAnMatch = Arguments.of("This is a line.\r\nThis is another line.\rFinally the last line.\n", expected);

        return Stream.of(
                textBlock,
                carriageReturnWindows,
                carriageReturnOlderMacintosh,
                newlines,
                mixAnMatch
        );
    }
}
