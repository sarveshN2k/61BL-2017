public class InsertionSort {
    
    // Precondition: elements 0 through k-1 of list are in increasing order.
    // Postcondition: elements 0 through k of list are in increasing order.
    public static void insert (int list[], int k) {
        InsertionSort.isOK(list,k-1);
        int key = list[k];
        int inx = k - 1;
        while (inx >= 0 && list[inx] > key) {
            list[inx + 1] = list[inx];
            inx--;
        }
        list[inx + 1] = key;
        InsertionSort.isOK(list,k);
    }
    
    // Does nothing when elements 0 through k of list are sorted in
    // increasing order.
    // Throws an IllegalStateException otherwise.
    public static void isOK (int[] list, int k) {
        int low = list[0];
        for (int i = 0; i < k && i < list.length ; i++) {
            if (low > list[i]) {
                throw new IllegalStateException();
            }
            low = list[i];
        }

    }

    public static int[] insertionSort(int[] list) {
        int[] rtn = new int[list.length];
        for (int k = 0; k < list.length; k++) {
            rtn[k] = list[k];
        }
        for (int k = 0; k < rtn.length; k++) {
            insert(rtn, k);
            try {
                isOK(rtn, k);
            } catch (IllegalStateException e) {
                System.err.println("inconsistency at position " + k);
            }
        }
        return rtn;
    }
    
    public static void main (String[] args) {
        int[] list = {3, 1, 7, 4, 5, 9, 2, 8, 6};
        list = insertionSort(list);
        for (int k = 0; k < list.length; k++) {
            System.out.print(list[k]);
        }
        System.out.println();
    }

}
