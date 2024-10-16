import java.util.Comparator;
import java.util.List;

/**
 * @course CMSC 315
 * @assignment Project 2
 * @description Class OrderedList: Provides methods to check if a list is sorted.
 * @author Adam Langbert
 * @date Sep 10, 2023
 * @java-version Java 17
 */

public class OrderedList {

    private OrderedList() {}

    public static <T extends Comparable<T>> boolean checkSorted(List<T> list) {
        return checkSorted(list, Comparator.naturalOrder());
    }

    public static <T> boolean checkSorted(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (comparator.compare(list.get(i), list.get(i + 1)) >= 0) {
                return false;
            }
        }
        return true;
    }
}
