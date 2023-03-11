import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MainTests {

    static Integer[] books;

    @BeforeAll
    public static void createArray() {
        books = new Integer[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
    }

    public static Stream<Arguments> addTestDetAmountLargerBooksWithParameters() {
        return Stream.of(Arguments.of(16, 7), Arguments.of(73, 0),
                Arguments.of(32, 3), Arguments.of(7, 9));
    }

    @Test
    public void testDetAmountLargerBooks() throws IncorrectValueException {
        int book = 16;
        int expected = 7;

        int result = Main.detAmountLargerBooks(books, book);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testDetAmountLargerBooksWithZero() throws IncorrectValueException {
        int book = 73;
        int expected = 0;

        int result = Main.detAmountLargerBooks(books, book);

        assertThat(expected, equalTo(result));
    }

    @ParameterizedTest
    @MethodSource("addTestDetAmountLargerBooksWithParameters")
    public void testDetAmountLargerBooksWithParameters(int book, int expected) throws IncorrectValueException {

        int result = Main.detAmountLargerBooks(books, book);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testInitialArray1() {
        assertThat(books, not(emptyArray()));
    }

    @Test
    public void testInitialArray2() {
        assertThat(books, arrayWithSize(9));
    }

    @Test
    public void testDetAmountLargerBooksWithException() {
        int book = -2;
        Class<IncorrectValueException> expected = IncorrectValueException.class;

        Executable executable = () -> Main.detAmountLargerBooks(books, book);

        Assertions.assertThrows(expected, executable);
    }
}
