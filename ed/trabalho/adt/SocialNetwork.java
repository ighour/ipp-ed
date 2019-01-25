package ed.trabalho.adt;

import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.graph.Network;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.PriorityQueueADT;
import estg.ed.tree.binary.ArrayPriorityMinQueue;

/**
 * Implements a directional network with an adjacency matrix. Add methods to
 * retrieve adjacency matrix and vertices to generate network view with Jung.
 *
 * @param <T> generic
 */
public class SocialNetwork<T> extends Network<T> implements NetworkADT<T> {

    /**
     * Instantiates network. Uses Double.NEGATIVE_INFINITY as default value when
     * no edge exists between vertices. Because sometimes the edge value can be
     * POSITIVE_INFINITY (0 visualizations = 1/0).
     */
    public SocialNetwork() {
        super();
        this.NO_EDGE_VALUE = Double.NEGATIVE_INFINITY;
    }

    /**
     * Returns a minimum spanning tree of the network from desired element.
     * Preference is to less weighted edge. Uses recursion. Similar to iterator
     * BFS, but using greedy technic to select next vertex instead. Returns a
     * instance of SocialNetwork, instead of Network.
     *
     * @param vertex vertex to start
     * @return an instance of SocialNetwork with minimum spawning tree
     * @throws estg.ed.exceptions.ElementNotFoundException element was not found
     */
    @Override
    public NetworkADT<T> mstNetwork(T vertex) throws ElementNotFoundException {
        //Get index
        int index = this.getIndex(vertex);

        //Index is invalid
        if (index < 0) {
            throw new ElementNotFoundException("Vertex was not found!");
        }

        //Generate result graph
        NetworkADT<T> resultGraph = new SocialNetwork<>();

        //Generate a priority min queue to store the weighted edges
        PriorityQueueADT<Integer> traverseQueue = new ArrayPriorityMinQueue<>();

        //Get size
        int size = this.vertices.size();

        //Generate visited boolean array
        boolean[] visited = new boolean[size];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        //Generate antecessor boolean array
        int[] antecessor = new int[size];
        for (int i = 0; i < antecessor.length; i++) {
            antecessor[i] = -1;
        }

        //Enqueue first item
        traverseQueue.enqueue(index, 0);

        //Iterate
        this.iterateMST(resultGraph, traverseQueue, visited, antecessor);

        //Return result
        return resultGraph;
    }

    /**
     * Get the network adjacency matrix. To use in Jung Graph Visualization and
     * copying data between networks.
     *
     * @return the adjacency matrix of graph
     */
    public DynamicArrayContract<DynamicArrayContract<Double>> adjacencyMatrix() {
        return this.adjMatrix;
    }

    /**
     * Get the network vertices. To use in Jung Graph Visualization and copying
     * data between networks.
     *
     * @return the vertices of graph
     */
    public DynamicArrayContract<T> vertices() {
        return this.vertices;
    }
}
