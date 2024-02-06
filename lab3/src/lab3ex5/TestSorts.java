package lab3ex5;

public class TestSorts {
    public static void main(String[] args) {
        Chocolate[] chocolates = {
                new Chocolate(10, "Mars"),
                new Chocolate(5, "Snickers"),
                new Chocolate(7, "Twix")
        };
        Time[] times = {
                new Time(23, 59, 59),
                new Time(12, 0, 0),
                new Time(0, 0, 0)
        };

        System.out.println("Before Bubble Sort (chocolates):");
        printArray(chocolates);

        Sort.bubbleSort(chocolates);

        System.out.println("After Bubble Sort (chocolates):");
        printArray(chocolates);

        System.out.println("Before Quick Sort (times):");
        printArray(times);

        Sort.quickSort(times);

        System.out.println("After Quick Sort (times):");
        printArray(times);
    }
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
        System.out.println();
    }
}
