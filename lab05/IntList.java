/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /** The integer stored by this node. */
    private int item;
    /** The next node in this IntList. */
    private IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints (1 2 3) */
    public static IntList list(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /** Returns the integer stored by this IntList. */
    public int item() {
        return item;
    }

    /** Returns the next node stored by this IntList. */
    public IntList next() {
        return next;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        if (position == 0) {
            return this.item();
        } else if (position < 0 || this.next == null) {
            throw new IllegalArgumentException();
        } else {
            return this.next().get(position - 1);
        }
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        if (this.next == null) {
            return 1;
        }
        else {
            return 1 + this.next.size();
        }
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "( 1 2 3 )".
     *
     * @return The String representation of the list.
     */
    public String toString() {

        return "( " + toStringHelper(this) + ")";

    }

    private static String toStringHelper(IntList list) {
        if (list.next == null) {
            return list.item + " ";
        }
        else {
            return list.item + " " + toStringHelper(list.next);
        }
    }
    /**
     * Returns whether this and the given list or object are equal.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass())
        {
            return false;
        } else if (this.size() != ((IntList)obj).size()) {
            return false;
        }
        else {
            return equalsHelper(this,(IntList)obj);
        }
    }

    private boolean equalsHelper(IntList list, IntList other) {
        if (list == null) {
            return true;
        } else if (list.item() != other.item())
        {
            return false;
        }
        else {
            return equalsHelper(list.next,other.next);
        }
    }

    /**
     * Adds the given item at the end of the list.
     *
     * @param item, the int to be added.
     */
    public void add(int item) {
        addHelper(this,item);
    }
    private static void addHelper(IntList list,int item) {
        if (list.next == null) {
            list.next = new IntList(item);
        }
        else {
            addHelper(list.next(),item);
        }
    }
    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        return smallestHelper(this.next,this.item);
    }

    private static int smallestHelper(IntList list,int small) {
        if (list == null) {
            return small;
        } else if (list.item < small) {
            return smallestHelper(list.next,list.item);
        } else {
            return smallestHelper(list.next,small);
        }
    }
    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        return squaredSumHelper(this,0);
    }
    private static int squaredSumHelper(IntList list,int soFar) {
        if (list == null) {
            return soFar;
        } else {
            return squaredSumHelper(list.next,soFar + list.item * list.item);
        }
    }
    /**
     * Returns a new IntList consisting of L1 followed by L2,
     * non-destructively.
     *
     * @param l1 list to be on the front of the new list.
     * @param l2 list to be on the back of the new list.
     * @return new list with L1 followed by L2.
     */
    public static IntList append(IntList l1, IntList l2) {
        if (l1 != null) {
            return new IntList(l1.item,append(l1.next(),l2));
        } else if (l2 != null) {
            return new IntList(l2.item(),append(l1,l2.next()));
        } else {
            return null;
        }
    }
}