//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class FixedSizeList implements SimpleList {

    /** List of elements. */
    protected int[] values;
    /** Number of array cells used by the list. */
    int count;

    /** Initializes a FixedSizeList with specified capacity. The capacity is the
     *  the actual size of the array (i.e. the max number of items it can hold).
     */
    public FixedSizeList(int capacity) {
        this.values = new int[capacity];
        this.count = 0;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.count;
    }

    /** Returns true if the list is empty, else false. */
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /** Adds the int k to the list by placing it in the first unused spot in
     *  values.
     */
    public void add(int k) {
        if (this.count == this.values.length) {
            throw new ListException("add(int k) out of space");
        }
        this.values[this.count] = k;
        this.count++;
    }

    /** Removes k from the list if it is present. If k appears multiple times,
     *  it only removes the first occurence of k.
     */
    public void remove(int k) {
        for (int i = 0; i < this.count; i++) {
            if (this.values[i] == k) {
                for (int j = i; j <= this.count - 2; j++) {
                    this.values[j] = this.values[j + 1];
                }
                this.count--;
                return;
            }
        }
        //this.count--;
    }

    /** Returns if the collection contains k. */
    public boolean contains(int k) {
        for (int i = 0; i < this.count; i++) {
            if (this.values[i] == k) {
                return true;
            }
        }
        return false;
    }

    /** Returns the integer stored at the i-th index in the list. */
    public int get(int i) {
        if (i >= this.count) {
            throw new ListException("Tried to get from bad list index");
        } else {
            return this.values[i];
        }
    }

    /** Inserts k into the list at position i by shifting each element at index
     *  i and onwards one entry to the right.
     *  Precondition: i is between 0 and count, inclusive.
     */
    public void add(int i, int k) {
        if (this.count == this.values.length) {
            throw new ListException("no more room in FixedSizeList");
        } else {
            for (int j = this.count; j > i; j--) {
                this.values[j] = this.values[j - 1];
            }
            this.values[i] = k;
        }
        this.count++;
    }

    /** Removes the entry at position i by shifting each element after position
     *  i one entry to the left.
     */
    public void removeIndex(int i) throws ListException {
        if (i >= this.count) {
            throw new ListException("Removing from non-existant index");
        } else {
            for (int j = i; j < this.count - 1; j++) {
                this.values[j] = this.values[j + 1];
            }
            this.values[this.count - 1] = 0;
            this.count--;
        }
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < this.count; i++) {
            System.out.print(" " + this.values[i]);
        }
        System.out.println(" ] " +  this.count);
    }

    public static void main(String[] args) {
        FixedSizeList list = new FixedSizeList(5);
        list.add(0);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(3,5);
        list.show();
        list.remove(5);
        list.show();
        list.remove(4);
        list.show();
        list.removeIndex(2);
        list.show();
        list.add(1,1);
        list.show();
    }

}
