import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;

public class Graph implements Iterable<Integer>{

    private LinkedList<Edge>[] adjLists;
    private int vertexCount;
    private int startVertex;

    // Initialize a graph with the given number of vertices and no edges.
    public Graph(int numVertices) {
        adjLists = new LinkedList[numVertices];
        startVertex = 0;
        for (int k = 0; k < numVertices; k++) {
            adjLists[k] = new LinkedList<Edge>();
        }
        vertexCount = numVertices;
    }

    // Change the vertex the iterator will start DFS from
    public void setStartVertex(int v){
        if (v < vertexCount && v >= 0){
            startVertex = v;
        } else {
            throw new IllegalArgumentException("Cannot set iteration start vertex to " + v + ".");
        }
    }


    // Add to the graph a directed edge from vertex v1 to vertex v2.
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, null);
    }

    // Add to the graph an undirected edge from vertex v1 to vertex v2.
    public void addUndirectedEdge(int v1, int v2) {
        addUndirectedEdge(v1, v2, null);
    }

    // Add to the graph a directed edge from vertex v1 to vertex v2,
    // with the given edge information. If the edge already exists,
    // replaces the current edge with a new edge with edgeInfo.
    public void addEdge(int v1, int v2, Object edgeInfo) {
        //your code here
        //WRITE A CASE FOR IF THE EDGE FROM V1 To 2 ALREADY EXISTS
        if (isAdjacent(v1, v2)){
            adjLists[v1].remove(v1);
            adjLists[v1].add(new Edge(v1, v2, edgeInfo));
        }
        adjLists[v1].add(new Edge(v1, v2, edgeInfo));
    }

    // Add to the graph an undirected edge from vertex v1 to vertex v2,
    // with the given edge information. If the edge already exists,
    // replaces the current edge with a new edge with edgeInfo.
    public void addUndirectedEdge(int v1, int v2, Object edgeInfo) {
        //your code here
        addEdge(v1, v2, edgeInfo);
        addEdge(v2, v1, edgeInfo);
    }

    // Return true if there is an edge from vertex "from" to vertex "to";
    // return false otherwise.
    public boolean isAdjacent(int from, int to) {
        //your code here
        for (Edge e : adjLists[from]) {
            if (e.to == to) {
                return true;
            }
        }
        return false;
    }

    // Returns a list of all the neighboring  vertices 'u'
    // such that the edge (VERTEX, 'u') exists in this graph.
    public List<Integer> neighbors(int vertex) {
        // your code here
        List<Integer> toReturn = new ArrayList<>();
        for (Edge e : adjLists[vertex]) {
            toReturn.add(e.to);
        }
        return toReturn;
    }

    // Return the number of incoming vertices for the given vertex,
    // i.e. the number of vertices v such that (v, vertex) is an edge.
    public int inDegree(int vertex) {
        HashSet<Edge> seen = new HashSet<>();
        int count = 0;
        for (int i = 0; i < adjLists.length; i++) {
            for (Edge e : adjLists[i]) {
                if (!seen.contains(e) && e.to == vertex) {
                    count++;
                }
                seen.add(e);
            }
        }
        return count;
    }

    public Iterator<Integer> iterator(){
        return new TopologicalIterator();
    }

    // A class that iterates through the vertices of this graph, starting with a given vertex.
    // Does not necessarily iterate through all vertices in the graph: if the iteration starts
    // at a vertex v, and there is no path from v to a vertex w, then the iteration will not
    // include w
    private class DFSIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private HashSet<Integer> visited;

        public DFSIterator(Integer start) {
            //your code here
            fringe = new Stack<>();
            visited = new HashSet<>();
            fringe.push(start);
            //visited.add(start);
        }

        public boolean hasNext() {
            //your code here
            if (fringe.isEmpty()) {
                return false;
            }
            if (visited.contains(fringe.peek())) {
                fringe.pop();
                return hasNext();
            }
            return true;
        }

        public Integer next() {
            //your code here
            Integer toReturn = fringe.pop();
            visited.add(toReturn);
            for (Edge e : adjLists[toReturn]) {
                if (!visited.contains(e.to)) {
                    fringe.push(e.to);
                }
            }
            return toReturn;
        }

        //ignore this method
        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    // Return the collected result of iterating through this graph's
    // vertices as an ArrayList, starting from STARTVERTEX.
    public ArrayList<Integer> visitAll(int startVertex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new DFSIterator(startVertex);

        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    // Returns true iff there exists a path from STARVETEX to
    // STOPVERTEX. Assumes both STARTVERTEX and STOPVERTEX are
    // in this graph. If STARVERTEX == STOPVERTEX, returns true.
    public boolean pathExists(int startVertex, int stopVertex) {
        // your code here

        for (Integer value : visitAll(startVertex)) {
            if (value == stopVertex) {
                return true;
            }
        }
        return false;
    }


    // Returns the path from startVertex to stopVertex.
    // If no path exists, returns an empty arrayList.
    // If startVertex == stopVertex, returns a one element arrayList.
    public ArrayList<Integer> path(int startVertex, int stopVertex) {
        // return new ArrayList<Integer>();
        // you supply the body of this method
        ArrayList<Integer> toReturn = new ArrayList<>();
        Iterator<Integer> iter = new DFSIterator(startVertex);
        Stack<Integer> stack = new Stack<>();
        stack.add(iter.next());
        if (!pathExists(startVertex, stopVertex)) {
            return new ArrayList<>();
        }
        while (iter.hasNext()) {
            Integer next = iter.next();
            while (true) {
                if (isAdjacent(stack.peek(), next)) {
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.add(next);
            if (next == stopVertex) {
                break;
            }
        }
        for (Integer i : stack) {
            toReturn.add(i);
        }
        return toReturn;
    }

    public ArrayList<Integer> topologicalSort() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new TopologicalIterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    private class TopologicalIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;

        // more instance variables go here

        public TopologicalIterator() {
            fringe = new Stack<Integer>();
            // more statements go here
            for (int i = 0; i < adjLists.length; i++) {
                for (Edge e : adjLists[i]) {
                    if (inDegree(e.from) == 0 && !fringe.contains(e.from)) {
                        fringe.push(e.from);
                    }
                }
            }
        }

        public boolean hasNext() {
            return !fringe.isEmpty();
        }

        public Integer next() {
            Integer toReturn = fringe.pop();
            //System.out.println("popped " + toReturn + " from " + fringe.toString());
            for (int neighbor : neighbors(toReturn)) {
                if (inDegree(neighbor) == 1) {
                    fringe.push(neighbor);
                }
            }
            adjLists[toReturn] = new LinkedList<>();

            return toReturn;
            // you supply the real body of this method
        }

        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    private class Edge {

        private Integer from;
        private Integer to;
        private Object edgeInfo;

        public Edge(int from, int to, Object info) {
            this.from = new Integer(from);
            this.to = new Integer(to);
            this.edgeInfo = info;
        }

        public Integer to() {
            return to;
        }

        public Object info() {
            return edgeInfo;
        }

        public String toString() {
            return "(" + from + "," + to + ",dist=" + edgeInfo + ")";
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> result;

        Graph g1 = new Graph(5);
        g1.addUndirectedEdge(0, 1);
        g1.addUndirectedEdge(0, 2);
        g1.addUndirectedEdge(1, 2);
        g1.addUndirectedEdge(2, 0);
        g1.addUndirectedEdge(2, 3);
        g1.addUndirectedEdge(4, 3);
        System.out.println(g1.visitAll(0));

    }

}
