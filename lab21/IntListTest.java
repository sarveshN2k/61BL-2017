import static org.junit.Assert.*;

/**
 * Created by cjjang on 8/1/17.
 */
public class IntListTest {
    @org.junit.Test
    public void insertionSort() throws Exception {
        IntList test = new IntList();
        test.addToFront(3);
        test.addToFront(4);
        test.addToFront(2);
        test.addToFront(1);
        test.addToFront(10);
        System.out.println("Before:" + test);
        //10,1,2,4,3
        test.insertionSort();
        System.out.println("After" + test);
    }

    @org.junit.Test
    public void selectionSort() throws Exception {
    }

    @org.junit.Test
    public void quicksort() throws Exception {
    }

    @org.junit.Test
    public void mergeSort() throws Exception {
    }
