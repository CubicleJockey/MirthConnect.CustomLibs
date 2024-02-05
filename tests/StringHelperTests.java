
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
}
