public class DLList {
    DLNode sentinel;
    int size;

    public class DLNode {
        Object item;
        DLNode prev, next;

        public DLNode(Object item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Construct a new DLList with a sentinel that points to itself.
     */
    public DLList() {
        sentinel = new DLNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Insert into the end of this list
     * @param o Object to insert
     */
    public void insertBack(Object o) {
        DLNode n = new DLNode(o, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }


    /**
     * Get the value at position pos. If the position does not exist, return null (the item of
     * the sentinel).
     * @param position to get from
     * @return the Object at the position in the list.
     */
    public Object get(int position) {
        DLNode curr = sentinel.next;
        while (position > 0 && curr != sentinel) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DLList(");
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            s.append(curr.item.toString());
            if (curr.next != sentinel) s.append(", ");
            curr = curr.next;
        }
        s.append(')');
        return s.toString();
    }

    /* Fill these in! */

    /**
     * Insert a new node into the DLList.
     * @param o Object to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(Object o, int position) {
        this.size += 1;
        DLNode node = this.sentinel.next;
        while (position > 0 && node != this.sentinel) {
            position--;
            node = node.next;
        }
        DLNode newNode = new DLNode(o,node.prev,node);
        node.prev.next = newNode;
        node.prev = newNode;
    }


    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     * @param o Object to insert
     */
    public void insertFront(Object o) {
        this.insert(o,0);
    }

    /**
     * Remove all copies of Object o in this list
     * @param o Object to remove
     */
    public void remove(Object o) {;
        DLNode node = this.sentinel;
        while (true) {
            if (node.item == o) {
                DLNode prev = node.prev;
                DLNode next = node.next;
                next.prev = prev;
                prev.next = next;
                this.size -= 1;

            }
            node = node.next;
            if (node == this.sentinel) {
                break;
            }
        }
    }

    /**
     * Remove a DLNode from this list. Does not error-check to make sure that the node actually
     * belongs to this list.
     * @param n DLNode to remove
     */
    public void remove(DLNode n) {
        DLNode prev = n.prev;
        DLNode next = n.next;
        next.prev = prev;
        prev.next = next;
        n.prev = null;
        n.next = null;
        size -= 1;
    }


    /**
     * Duplicate each node in this linked list destructively.
     */
    public void doubleInPlace() {
        this.size *= 2;
        for (DLNode it = this.sentinel.next; it != this.sentinel; it = it.next.next) {
            DLNode newNode = new DLNode(it.item,it,it.next);
            it.next.prev = newNode;
            it.next = newNode;
        }
    }

    /**
     * Reverse the order of this list destructively.
     */
    public void reverse() {
        DLNode node = this.sentinel;
        while (true) {
            DLNode oldNext = node.next;
            node.next = node.prev;
            node.prev = oldNext;
            node = node.prev;
            if (node == this.sentinel) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // you can add some quick tests here if you would like
    }
}
