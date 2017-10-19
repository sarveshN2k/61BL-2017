<<<<<<< HEAD
=======

import java.util.*;

>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
/** A class that runs Kruskal's algorithm on a Graph. Given a graph G, Kruskal's
 *  algorithm constructs a new graph T such that T is a spanning tree of G and
 *  the sum of its edge weights is less than the sum of the edge weights for
 *  every possible spanning tree T* of G. This is called the Minimum Spanning
 *  Tree (MST).
 *
 *  @author
 */
public class Kruskal {

<<<<<<< HEAD
    /** Returns the MST of INPUT using a naive isConnected implementation. */
    public static Graph minSpanTree(Graph input) {
        // TODO implement!
        return null;
=======

    /** Returns the MST of INPUT using a naive isConnected implementation. */
    public static Graph minSpanTree(Graph input) {
        Graph newGraph = new Graph();
        for (Integer v : input.getAllVertices()) {
            newGraph.addVertex(v);
        }
        PriorityQueue<Edge> edgesQueue = new PriorityQueue<Edge>(Edge::compareTo);
        for (Edge e : input.getAllEdges()) {
            edgesQueue.add(e);
        }
        while (!edgesQueue.isEmpty()) {
            Edge shortest = edgesQueue.poll();
            if (!isConnected(newGraph, shortest.getDest(), shortest.getSource())) {
                newGraph.addEdge(shortest);
            }
        }
        return newGraph;

>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }

    /** Returns the MST of INPUT using the Union Find data structure. */
    public static Graph minSpanTreeFast(Graph input) {
<<<<<<< HEAD
        // TODO implement!
        return null;
=======
        Graph newGraph = new Graph();
        int maxVertex = 0;
        for (Integer v : input.getAllVertices()) {
            newGraph.addVertex(v);
            if (v > maxVertex) {
                maxVertex = v;
            }
        }
        UnionFind treeUnion = new UnionFind(maxVertex + 1);
        PriorityQueue<Edge> inEdges = new PriorityQueue<>((Edge::compareTo));
        for (Edge e : input.getAllEdges()) {
            inEdges.add(e);
        }
        while (!inEdges.isEmpty()) {
            Edge shortest = inEdges.poll();
            if (!treeUnion.isConnected(shortest.getDest(), shortest.getSource())) {
                newGraph.addEdge(shortest);
                treeUnion.union(shortest.getDest(), shortest.getSource());
            }

        }
        return newGraph;
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
    }

    /** A naive implementation of BFS or DFS to check if two nodes are
     *  connected. */
    public static boolean isConnected(Graph g, int v1, int v2) {
<<<<<<< HEAD
        // TODO implement!
=======
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> fringe = new Stack<>();
        fringe.add(v1);
        while (!fringe.isEmpty()) {
            int node = fringe.pop();
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            if (node == v2) {
                return true;
            }
            TreeSet<Edge> edges = g.getEdges(node);
            for (Edge edge : edges) {
                fringe.push(edge.getSource());
                fringe.push(edge.getDest());
            }
        }
>>>>>>> 9d49c1547c2a4aae6bb37d5bd4baa87b630321f8
        return false;
    }
}
