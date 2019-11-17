package pattern.strategy.sorting;
/*
28/07/19-8:25 PM
*/

public class SortingAlgo {
    IComparator m_pComparator;

    void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }

    SortingAlgo() {
        m_pComparator = new LesserComprataor();
    }

    void sort(int[] arr, IComparator comparator) {
        if (comparator == null)
            comparator = m_pComparator;

        boolean isSwapped = true;
        int x = 0;//total swaps
        while (isSwapped) {
            isSwapped = false;
            x++;
            for (int i = 0; i < arr.length - x; i++) {
                if (comparator.compare(arr[i], arr[i + 1])) {
                    //swap
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    isSwapped = true;
                }
            }
        }
    }
};
