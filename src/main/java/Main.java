import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IncorrectValueException {
        Scanner scanner = new Scanner(System.in);
        Integer[] books = {14, 16, 19, 32, 32, 32, 56, 69, 72};

        System.out.println("Введите размер новой книги:");
        int book = scanner.nextInt();
        System.out.printf("Книг на полке с количеством страниц больше %d: %d", book, detAmountLargerBooks(books, book));
    }

    public static int detAmountLargerBooks(Integer[] books, int book) throws IncorrectValueException {
        if (book <= 0) {
            throw new IncorrectValueException();
        }
        if (book >= books[books.length - 1]) {
            return 0;
        }
        int left = 0;
        int right = books.length - 1;
        int middle;
        while (left < right) {
            middle = (left + right) / 2;
            if (book >= books[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return books.length - left;
    }
}
