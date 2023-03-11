import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MainTests {

    static int[] books;

    @BeforeAll
    public static void createArray() {
        books = new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
    }

    @Test
    public void testDetAmountLargerBooks() throws IncorrectValueException {
        int book = 16;
        int expected = 7;

        int result = Main.detAmountLargerBooks(books, book);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDetAmountLargerBooksWithZero() throws IncorrectValueException {
        int book = 73;
        int expected = 0;

        int result = Main.detAmountLargerBooks(books, book);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDetAmountLargerBooksWithException() {
        int book = -2;
        Class<IncorrectValueException> expected = IncorrectValueException.class;

        Executable executable = () -> Main.detAmountLargerBooks(books, book);

        Assertions.assertThrows(expected, executable);
    }
}
