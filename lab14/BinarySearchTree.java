import sun.reflect.generics.tree.Tree;

/** A class implementing a BST.
  * @author CS 61BL Staff.
  */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	/** Constructs an empty BST. */
	public BinarySearchTree() {
		//YOUR CODE HERE
		root = null;
	}

	/** BST Constructor.
         *  @param root node to use for constructing new BST.
         */
	public BinarySearchTree(TreeNode root) {
		//YOUR CODE HERE
		this.root = root;
	}
	
	/** Method for checking if BST has a given key.
         *  @param  key to search for
         *  @return true if this BST contains key
         *          false if this BST does not contain key
         */ 
	public boolean contains(T key) {
		if (this.root == null) {
			return false;
		}
		return containsHelper(this.root, key);
	}

	public boolean containsHelper(TreeNode node, T key) {
		if (node == null){
			return false;
		} else if (key.compareTo(node.item) == 0) {
			return true;
		} else if (key.compareTo(node.item) > 0) {
			return containsHelper(node.right, key);
		} else {
			return containsHelper(node.left, key);
		}
	}
	
	/** Adds a node for KEY iff it isn't in the BST already. 
         *  @param key to be added
         */
	public void add(T key) {
		if (this.contains(key)) {
			return;
		} else {
			if (this.root == null) {
				this.root = new TreeNode(key);
			} else {
				addHelper(this.root, key);
			}
		}
	}

	public void addHelper(TreeNode node, T key) {
		if (key.compareTo(node.item) > 0) {
			if (node.right == null) {
				node.right = new TreeNode(key);
			}
			addHelper(node.right, key);
		} else if (key.compareTo(node.item) < 0){
			if (node.left == null) {
				node.left = new TreeNode(key);
			}
			addHelper(node.left, key);
		} else {

			System.out.println("Key is Equal to the node");

		}
	}
	
	/** Deletes a node from the BST. 
         *  @param  key to be deleted
         *  @return key that was deleted
         */
	public T delete(T key) {
		TreeNode parent = null;
		TreeNode curr = root;
		TreeNode delNode = null;
		TreeNode replacement = null;
		boolean rightSide = false;
		
		while (curr != null && !curr.item.equals(key)) {
			if (((Comparable<T>) curr.item).compareTo(key) > 0) {
				parent = curr;
				curr = curr.left;
				rightSide = false;
			} else {
				parent = curr;
				curr = curr.right;
				rightSide = true;
			}
		}
		delNode = curr;
		if (curr == null) {
			return null;
		}
		
		if (delNode.right == null) {
			if (root == delNode) {
				root = root.left;
			} else {
				if (rightSide) {
					parent.right = delNode.left;
				} else {
					parent.left = delNode.left;
				}
			}
		} else {
			curr = delNode.right;
			replacement = curr.left;
			if (replacement == null) {
				replacement = curr;
			} else {
				while (replacement.left != null) {
					curr = replacement;
					replacement = replacement.left;
				}
				curr.left = replacement.right;
				replacement.right = delNode.right;
			}
			replacement.left = delNode.left;
			if (root == delNode) {
				root = replacement;
			} else {
				if (rightSide) {
					parent.right = replacement;
				} else {
					parent.left = replacement;
				}
			}
		}
		return delNode.item;
	}

	public static void main(String[] args) {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("E");
		tree.add("C");
		tree.add("D");
		tree.add("A");
		tree.add("B");
		tree.add("B");
		tree.add("F");


		print(tree, "tree");
	}
}
