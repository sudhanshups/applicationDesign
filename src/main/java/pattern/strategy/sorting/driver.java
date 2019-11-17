package pattern.strategy.sorting;
/*
28/07/19-8:25PM
*/

public class driver {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 3};
        SortingAlgo obj = new SortingAlgo();
        IComparator pComp = new LesserComprataor();
        obj.sort(arr, pComp);

        for (int var = 0; var < 5; ++var) {
            System.out.print(arr[var] + " ");
        }
        System.out.println();

        pComp = new GreaterComprataor();
        obj.sort(arr, pComp);
        for (int var = 0; var < 5; ++var) {
            System.out.print(arr[var] + " ");
        }
        System.out.println();

        obj.sort(arr, null);
        for (int var = 0; var < 5; ++var) {
            System.out.print(arr[var] + " ");
        }
        System.out.println();
    }
}
