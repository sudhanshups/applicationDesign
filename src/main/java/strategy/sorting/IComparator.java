package strategy.sorting;/* 
28/07/19-7:38 PM
*/

public interface IComparator {
    boolean compare(int a, int b);
};

class LesserComprataor implements IComparator {
    public boolean compare(int a, int b) {
        if (a > b)
            return true;
        else
            return false;
    }
};

class GreaterComprataor implements IComparator {
    public boolean compare(int a, int b) {
        if (a < b)
            return true;
        else
            return false;
    }
};


