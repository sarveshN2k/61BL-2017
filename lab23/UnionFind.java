<<<<<<< HEAD
=======


import java.util.ArrayList;

>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
/** A simple implementation of the UnionFind abstract data structure with path
 *  compression. This UnionFind structure only holds integers and there are two
 *  critical operations: union and find. When unioning two elements, the element
 *  contained in a tree of smaller size is placed as a subtree to the root
 *  vertex of the larger tree. Meanwhile finding an element implements path
 *  compression. When we find a particular vertex, that vertex and the 
 *  other vertices from that vertex to the root are automatically
 *  connected to the root of that tree.
 *
 *  Using the union find data structure allows for a fast implementation of
 *  Kruskal's algorithm as well as other set based operations.
 *
 *  @author
 *  @since
 */
public class UnionFind {

    /** Instance variables go here? */
<<<<<<< HEAD

=======
    int[] vertices;
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8

    /** Returns a UnionFind data structure holding N vertices. Initially, all
     *  vertices are in disjoint sets. */
    public UnionFind(int n) {
<<<<<<< HEAD
        // TODO implement
=======
        vertices = new int[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = -1;
        }
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }

    /** Returns the size of the set V1 belongs to. */
    public int sizeOf(int v1) {
<<<<<<< HEAD
        // TODO implement
        return -1;
=======
        if (vertices[v1] < 0) {
            return -vertices[v1];
        } else {
            return sizeOf(vertices[v1]);
        }
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }

    /** Returns the parent of v1. If v1 is the root of a tree, 
     *  returns the negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        // TODO implement
<<<<<<< HEAD
        return -1;
=======
        return vertices[v1];
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }

    /** Returns true if nodes V1 and V2 are connected. */
    public boolean isConnected(int v1, int v2) {
<<<<<<< HEAD
        // TODO implement
        return false;
=======
        return find(v1) == find(v2);
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }

    /** Returns the root of the set VERTEX belongs to. Path-compression, where the
     *  vertices along the search path from VERTEX to its root and VERTEX are linked
     *  directly to the root, is employed allowing for fast search-time. */
    public int find(int vertex) {
<<<<<<< HEAD
        // TODO implement
        return -1;
=======
        if (vertex >= vertices.length || vertex < 0) {
            throw new IllegalArgumentException("vertex is :" + vertex + ", length is :" + vertices.length);
        }
        int curr = vertex;
        while (vertices[curr] >= 0) {
            curr = vertices[curr];
        }
        if (vertices[vertex] >= 0) {
            vertices[vertex] = curr;
        }
        return curr;
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }

    /** Connects two elements V1 and V2 together in the UnionFind structure. V1
     *  and V2 can be any element and a union-by-size heuristic is used.
     *  If the sizes are equal, tie break by connecting the first to the second.
     *  Union-ing a vertex with itself or vertices already connected should not 
     *  change anything. */
    public void union(int v1, int v2) {
<<<<<<< HEAD
        // TODO implement
=======
        if (isConnected(v1, v2) || v1 == v2) {
            return;
        }
        int root1, root2;
        root1 = find(v1);
        root2 = find(v2);
        if (sizeOf(root1) <= sizeOf(root2)) {  // True
            vertices[root2] -= sizeOf(root1);
            vertices[root1] = root2;
        } else {
            vertices[root1] -= sizeOf(root2);
            vertices[root2] = root1;
        }
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }
}
