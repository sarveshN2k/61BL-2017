<<<<<<< HEAD
=======
import jh61b.junit.In;

>>>>>>> b8bbb6bee820832148586bf664b548880259be3e
import java.util.*;

/**
 * A BinaryTree is a tree with nodes that have up to two children.
 */
public class BinaryTree {

<<<<<<< HEAD
=======
    static void optimizeNode(TreeNode t) {

        if (t.left == null) {
        } else {

            optimizeNode(t.left);
            optimizeNode(t.right);
            String operand1 = ((String)t.left.item);
            String operand2 = ((String)t.right.item);
            String operator = ((String)t.item);

            if (operator.equals("+")) {
                if (validateInt(operand1) && validateInt(operand2)) {
                    int sum = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                    t.item = Integer.toString(sum);
                    t.right = null;
                    t.left = null;
                } else {
                    return;
                }
            } else if (operator.equals("*")) {
                if (validateInt(operand1) && validateInt(operand2)) {
                    int prod = Integer.parseInt(operand1) * Integer.parseInt(operand2);
                    t.item = Integer.toString(prod);
                    t.left = null;
                    t.right = null;
                }
            }

        }
    }

    public void optimize() {
        if (this.root != null) {
            optimizeNode(this.root);
        }
    }

    public static boolean validateInt(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static BinaryTree exprTree(String s) {
        BinaryTree result = new BinaryTree();
        result.root = result.exprTreeHelper(s);
        return result;
    }
    // Return the tree corresponding to the given arithmetic expression.
    // The expression is legal, fully parenthesized, contains no blanks,
    // and involves only the operations + and *.
    private TreeNode exprTreeHelper(String expr) {
        if (expr.charAt(0) != '(') {
            return new TreeNode(expr); // you fill this in
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            for (int k = 1; k < expr.length() - 1; k++) {
                // you supply the missing code
                char kChar = expr.charAt(k);
                if (kChar == '(') {
                    nesting += 1;
                } else if (kChar == ')') {
                    nesting -= 1;
                }
                if ((kChar == '*' || kChar == '+') && nesting == 0) {
                    opPos = k;
                    break;
                }
            }

            String opnd1 = expr.substring(1, opPos);
            String opnd2 = expr.substring(opPos + 1, expr.length() - 1);
            String op = expr.substring(opPos, opPos + 1);
            System.out.println("expression = " + expr);
            System.out.println("operand 1  = " + opnd1);
            System.out.println("operator   = " + op);
            System.out.println("operand 2  = " + opnd2);
            System.out.println();
            return new TreeNode(op,exprTreeHelper(opnd1),exprTreeHelper(opnd2)); // you fill this in
        }
    }

    public static BinaryTree fibTree(int n) {
        TreeNode structure = fibStruct(n);
        fibFixValues(structure);
        return new BinaryTree(structure);
    }

    public static TreeNode fibStruct(int n) {
        if (n < 2) {
            return new TreeNode(n);
        } else {
            return new TreeNode(n,fibStruct(n - 1), fibStruct(n - 2));
        }
    }

    public static void fibFixValues(TreeNode node) {
        if ((Integer)node.item < 2) {
            return;
        } else {
            fibFixValues(node.left);
            fibFixValues(node.right);
            node.item = (Integer)node.left.item + (Integer)node.right.item;
        }
    }

    public boolean check() {
        alreadySeen = new ArrayList();
        try {
            isOK(root);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    private void isOK(TreeNode t) throws IllegalStateException {
        if (this.alreadySeen.contains(t)) {
            throw new IllegalStateException();
        } else {
            this.alreadySeen.add(t);
        }
        if (t != null && t.left != null) {
            this.isOK(t.left);
        }

        if (t != null && t.right != null) {
            this.isOK(t.right);
        }
    }
    // Contains nodes already seen in the traversal.
    private ArrayList alreadySeen;

    //Copy into BinaryTree class
    public void print() {
        if (root != null) {
            root.print(0);
        }
    }

>>>>>>> b8bbb6bee820832148586bf664b548880259be3e
    /**
     * root is the root of this BinaryTree
     */
    private TreeNode root;

    /**
     * The BinaryTree constructor
     */
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode t) {
        root = t;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * Print the values in the tree in preorder: root value first, then values
     * in the left subtree (in preorder), then values in the right subtree
     * (in preorder).
     */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }

    /**
     * Print the values in the tree in inorder: values in the left subtree
     * first (in inorder), then the root value, then values in the first
     * subtree (in inorder).
     */
    public void printInorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printInorder();
            System.out.println();
        }
    }

    /**
     * Fills this BinaryTree with values a, b, and c.
     * DO NOT MODIFY THIS METHOD.
     */
    public void fillSampleTree1() {
        root = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
    }

    /**
     * Fills this BinaryTree with values a, b, and c, d, e, f.
     * DO NOT MODIFY THIS METHOD.
     */
    public void fillSampleTree2() {
        root = new TreeNode("a", new TreeNode("b", new TreeNode("d",
            new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
    }

    /**
     * Fills this BinaryTree with the values a, b, c, d, e, f in the way that the spec pictures.
     */
    public void fillSampleTree3() {
        //YOUR CODE HERE.
        root = new TreeNode("a", new TreeNode("b"), new TreeNode("c",
                new TreeNode("d", new TreeNode("e"), new TreeNode("f")), null));
    }

    /**                                                                          
     * Fills this BinaryTree with the same leaf TreeNode.                        
     * DO NOT MODIFY THIS METHOD.                                                
     */ 
    public void fillSampleTree4() {
        TreeNode leafNode = new TreeNode("c");                                   
        root = new TreeNode("a", new TreeNode("b", leafNode, leafNode), new TreeNode("d", leafNode, leafNode));
    }
    /**
     * Like the Amoeba class, returns the height of the deepest node.
     **/
    public int height() {
        if (this.root == null){
            return 0;
        }
        return this.root.height();
    }

    public boolean isCompletelyBalanced() {
        if (this.root == null) {
            return true;
        } else if (this.root.height() == 1) {
            return true;
        } else if (this.root.balance()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates two BinaryTrees and prints them out in inorder
     */
    public static void main(String[] args) {
<<<<<<< HEAD
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.fillSampleTree1();
        print(t, "sample tree 1");
        t.fillSampleTree2();
        print(t, "sample tree 2");
=======
        /*
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.print();
        System.out.println(t.check());

        t.fillSampleTree1();
        print(t, "sample tree 1");
        t.print();
        System.out.println(t.check());

        t.fillSampleTree2();
        print(t, "sample tree 2");
        t.print();
        System.out.println(t.check());

        String expr = "((a+50)+30)";
        BinaryTree express = exprTree(expr);
        express.print();
        */

        BinaryTree tree = exprTree("((a+(5*(9+1)))+(6*5))");
        tree.print();
        System.out.println("");
        System.out.println("");
        tree.optimize();
        tree.print();


>>>>>>> b8bbb6bee820832148586bf664b548880259be3e
    }

    /**
     * Prints out the contents of a BinaryTree with a description in both
     * preorder and inorder
     * @param t           the BinaryTree to print out
     * @param description a String describing the BinaryTree t
     */
    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    /**
     * A TreeNode is a Node this BinaryTree
     * Note: this class is public in this lab for testing purposes.
     * However, in professional settings as well as the rest of
     * your labs and projects, we recommend that you keep your
     * classes private.
     */
    public static class TreeNode {

<<<<<<< HEAD
=======
        //Copy into TreeNode class
        private static final String indent1 = "    ";

        private void print(int indent) {

            if (this.left != null) {
                this.left.print(indent + 1);
            }

            println (this.item, indent);

            if (this.right != null) {
                this.right.print(indent + 1);
            }
        }

        private static void println(Object obj, int indent) {
            for (int k=0; k<indent; k++) {
                System.out.print(indent1);
            }
            System.out.println(obj);
        }

>>>>>>> b8bbb6bee820832148586bf664b548880259be3e
        /**
         * item is the item that is contained in this TreeNode
         * left is the left child of this TreeNode
         * right is the right child of this TreeNode
         */
        public Object item;
        public TreeNode left;
        public TreeNode right;

        /**
         * A TreeNode constructor that creates a node with obj as its item
         * @param  obj the item to be contained in this TreeNode
         */
        TreeNode(Object obj) {
            item = obj;
            left = null;
            right = null;
        }

        /**
         * A TreeNode constructor that creates a node with obj as its item and
         * left and right as its children
         * @param  obj   the item to be contained in this TreeNode
         * @param  left  the left child of this TreeNode
         * @param  right the right child of this TreeNode
         */
        TreeNode(Object obj, TreeNode left, TreeNode right) {
            item = obj;
            this.left = left;
            this.right = right;
        }

        public Object getItem() {
            return item;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        /**
         * Prints this TreeNode and the subtree rooted at it in preorder
         */
        private void printPreorder() {
            System.out.print(item + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
        }

        /**
         * Prints this TreeNode and the subtree rooted at it in inorder
         */
        private void printInorder() {
            if (left != null) {
                left.printInorder();
            }
            System.out.print(item + " ");
            if (right != null) {
                right.printInorder();
            }
        }

        //Add more recursive methods here!

        private int height() {
            if (this.getItem() == null){
                return 0;
            } else if (this.getLeft() == null && this.getRight() != null) {
                return 1 + this.getRight().height();
            } else if(this.getRight() == null && this.getLeft() != null) {
                return 1 + this.getLeft().height();
            } else if (this.getRight() == null && this.getLeft() == null){
                return 1;
            } else {
                int leftside = this.getLeft().height();
                int rightside = this.getRight().height();
                if (leftside < rightside) {
                    return 1 + rightside;
                } else {
                    return 1 + leftside;
                }
            }

        }
        private boolean balance() {
            if (this.getLeft().height() == this.getRight().height()) {
                return true;
            } else if (this.getRight() == null && this.getLeft() != null || this.getLeft() == null && this.getRight() != null) {
                return false;
            } else if (this.getLeft() == null && this.getRight() == null){
                return true;
            } else {
                return false;
            }
<<<<<<< HEAD

=======
>>>>>>> b8bbb6bee820832148586bf664b548880259be3e
        }
    }
}
