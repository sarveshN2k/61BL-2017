/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 * Encapsulated version.
 */
public class IntList {

    /**
     * The head of the list is the first node in the list. 
     * If the list is empty, head is null 
     */
    private IntListNode head;
    private int size;

    /**
     * IntListNode is a nested class. It can be instantiated
     * when associated with an instance of IntList.
     */
    public class IntListNode {
        int item;
        IntListNode next;

        @java.lang.Override
        public java.lang.String toString() {
            return "IntListNode{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }

        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            if (!super.equals(object)) return false;

            IntListNode that = (IntListNode) object;

            if (item != that.item) return false;
            if (next != null ? !next.equals(that.next) : that.next != null) return false;

            return true;
        }

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public IntList() {}

    public IntList(int[] initial) {
        for (int i = initial.length - 1; i >= 0; i--) {
            head = new IntListNode(initial[i], head);
        }
        size = initial.length;
    }

    /**
     * Get the value at position pos. If the position does not exist, throw an
     * IndexOutOfBoundsException.
     * @param position to get from
     * @return the int at the position in the list.
     */
    public int get(int position) {
        if (position >= size) throw new IndexOutOfBoundsException("Position larger than size of list.");
        IntListNode curr = head;
        while (position > 0) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    /* Fill in below! */

    /**
     * Insert a new node into the IntList.
     * @param x value to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(int x, int position) {
        IntListNode newHead = this.insertHelper(this.head, x, position);
        this.size += 1;
        this.head = newHead;
    }

    private IntListNode insertHelper(IntListNode original,int x, int position) {
        if (position == 0) {
            return new IntListNode(x,original);
        } else if (original == null) {
            return new IntListNode(x,null);
        } else {
            return new IntListNode(original.item,
                    insertHelper(original.next,x,position - 1));
        }
    }
    /**
     * Merge two sorted IntLists a and b into one sorted IntList containing all of their elements.
     * @return a new IntList without modifying either parameter
     */

    public static IntList merge(IntList a, IntList b) {

        return new IntList(mergeHelper(a.head,b.head,new int[a.getSize() + b.getSize()],0));
    }
    private static int[] mergeHelper(IntListNode a, IntListNode b, int[] build, int index) {
        if (a == null && b == null) {
            return build;
        } else if (a == null) {
            build[index] = b.item;
            return mergeHelper(a,b.next,build,index + 1);
        } else if (b == null) {
            build[index]  = a.item;
            return mergeHelper(a.next,b,build,index + 1);
        } else if (a.item < b.item) {
            build[index] = a.item;
            return mergeHelper(a.next,b,build,index + 1);
        } else if (b.item < a.item) {
            build[index] = b.item;
            return mergeHelper(a,b.next,build,index + 1);
        } else {
            build[index] = a.item;
            return mergeHelper(a.next,b.next,build,index + 1);
        }
    }



    /**
     * Reverse the current list recursively, using a helper method.
     */
    public void reverse() {
        IntList reversedIntList = new IntList(reverseHelper(this.head,new int[this.getSize()],this.getSize() - 1));
        this.head = reversedIntList.head;

    }
    public static int[] reverseHelper(IntListNode toReverse, int[] reversed, int index) {
        if (toReverse == null) {
            return reversed;
        } else {
            reversed[index] = toReverse.item;
            return reverseHelper(toReverse.next,reversed,index - 1);
        }
    }

    /* Optional! */

    /**
     * Remove the node at position from this list.
     * @param position int representing the index of the node to remove. If greater than the size
     *                 of this list, throw an IndexOutOfBoundsException.
     */
    public void remove(int position) {
        if (position >= size) throw new IndexOutOfBoundsException();
        // fill me in
    }
}
