/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.adt;

import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.EmptyCollectionException;
import estg.ed.exceptions.VertexIsNotAccessibleException;
import estg.ed.graph.Network;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.PriorityQueueADT;
import estg.ed.interfaces.UnorderedListADT;
import estg.ed.list.UnorderedArrayList;
import estg.ed.tree.binary.ArrayPriorityMaxQueue;
import java.util.Iterator;

/**
 * Implements a directional network with an adjacency matrix.
 * Uses the inverse of weight, so more weight more priority.
 * Add methods to retrieve adjacency matrix and vertices to generate network View with Jung.
 * @author igu
 * @param <T>
 */
public class ReverseNetwork<T> extends Network<T> implements NetworkADT<T> {
  /**
   * Returns an iterator that contains the shortest path between the two vertices.
   * Similar to iterator BFS, but using cumulative path length.
   * Preference is to more weighted edge.
   * @param startVertex the starting vertex
   * @param targetVertex the ending vertex
   * @return an iterator that contains the shortest path between the two vertices
   */
  @Override
  public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
    //Get indexes
    int[] indexes = this.getIndex(startVertex, targetVertex);
    
    //Generate result list
    UnorderedListADT<T> resultList = new UnorderedArrayList<>();
    
    //If index is invalid, return result list iterator (empty)
    if(indexes[0] < 0 || indexes[1] < 0)
      return resultList.iterator();
    
    //Generate traversal priority max queue
    PriorityQueueADT<Integer> traversalQueue = new ArrayPriorityMaxQueue<>();
    
    //Generate visited boolean array
    boolean[] visited = new boolean[this.vertices.size()];
    for(int i = 0; i < visited.length; i++)
      visited[i] = false;
    
    //Generate path lengths array
    double[] pathLength = new double[this.vertices.size()];
    for(int i = 0; i < pathLength.length; i++)
      pathLength[i] = -1;
    
    //Generate antecessor array
    int[] antecessor = new int[this.vertices.size()];
    for(int i = 0; i < antecessor.length; i++)
      antecessor[i] = -1;
    
    //Enqueue first item and set as visited and set path length
    traversalQueue.enqueue(indexes[0], 0);
    pathLength[indexes[0]] = 0;
    
    //Start recursion
    this.iterateSP(traversalQueue, visited, pathLength, antecessor, indexes[1]);
    
    //Successfully achieved target
    if(antecessor[indexes[1]] != -1){
      //Add path based on antecessors
      int currentIndex = indexes[1];
      while(currentIndex != -1){
        resultList.addToFront(this.vertices.get(currentIndex));
        currentIndex = antecessor[currentIndex];
      }
    }
       
    //Return iterator
    return resultList.iterator();
  }
  
  private void iterateSP(PriorityQueueADT<Integer> traversalQueue, boolean[] visited, double[] pathLength, int[] antecessor, int target) {
    //Dequeue item
    int index;
    
    try {
      index = traversalQueue.dequeue();
      
    } catch (EmptyCollectionException ex) {
      //Stop if queue is empty
      return;
    }
    
    //Proceed in recursion if it was already visited
    if(visited[index] == true){
      this.iterateSP(traversalQueue, visited, pathLength, antecessor, target);
      return;
    }
    
    //Visit if removed from queue
    visited[index] = true;
    
    //Look for not visited neighbors to add to queue
    int size = this.vertices.size();
    for(int i = 0; i < size; i++){
      //Get current to neightbor edge relation and check if was visited
      if(this.adjMatrix.get(index).get(i) != Double.POSITIVE_INFINITY && !visited[i]){
        //Get cost
        double cost = this.adjMatrix.get(index).get(i);
        double fullCost = cost + pathLength[index];
        
        //Add neighbor to queue
        traversalQueue.enqueue(i, fullCost);
                
        //Compare costs
        //There is no old cost or new cost is greater then old cost
        if(pathLength[i] == -1 || fullCost > pathLength[i]){
          //Set newCost as used cost
          pathLength[i] = fullCost;
          
          //Updates antecessor reference
          antecessor[i] = index;
        }
      }
    }
    
    //Proceed in recursion if there is vertices in queue to visit
    if(!traversalQueue.isEmpty())
      this.iterateSP(traversalQueue, visited, pathLength, antecessor, target);
  }
  
   /**
   * Returns the weight of the shortest path in this network.
   * Similar to iteratorShortestPath(), but returns total path length instead.
   * Preference is to more weighted edge.
   * Uses recursion.
   * Throws ElementNotFoundException if vertices were not found.
   * Throws VertexIsNotAccessibleException if vertex2 is not accessible from vertex1.
   * @param vertex1 the first vertex
   * @param vertex2 the second vertex
   * @return the weight of the shortest path in this network
   * @throws estg.ed.exceptions.ElementNotFoundException
   * @throws estg.ed.exceptions.VertexIsNotAccessibleException
   */
  @Override
  public double shortestPathWeight(T vertex1, T vertex2) throws ElementNotFoundException, VertexIsNotAccessibleException {
    //Get indexes
    int[] indexes = this.getIndex(vertex1, vertex2);
    
    //Index is invalid
    if(indexes[0] < 0 || indexes[1] < 0)
      throw new ElementNotFoundException("Vertex was not found!");
    
    //Generate traversal priority max queue to use weighted edges
    PriorityQueueADT<Integer> traversalQueue = new ArrayPriorityMaxQueue<>();
    
    //Generate visited boolean array
    boolean[] visited = new boolean[this.vertices.size()];
    for(int i = 0; i < visited.length; i++)
      visited[i] = false;
    
    //Generate path lengths array
    double[] pathLength = new double[this.vertices.size()];
    for(int i = 0; i < pathLength.length; i++)
      pathLength[i] = -1;
    
    //Generate antecessor array
    int[] antecessor = new int[this.vertices.size()];
    for(int i = 0; i < antecessor.length; i++)
      antecessor[i] = -1;
    
    //Enqueue first item and set as visited and set path length
    traversalQueue.enqueue(indexes[0], 0);
    pathLength[indexes[0]] = 0;
    
    //Start recursion
    this.iterateSP(traversalQueue, visited, pathLength, antecessor, indexes[1]);
    
    //Successfully achieved target
    if(antecessor[indexes[1]] != -1)
      //Return path full weight
      return pathLength[indexes[1]];

    //Could not achieve second vertex
    throw new VertexIsNotAccessibleException("Vertex " + vertex2.toString() + " is not accessible from " + vertex1.toString() + " on network.");
  }
  
  /**
   * Returns a minimum spanning tree of the network from desired element.
   * Preference is to more weighted edge.
   * Uses recursion.
   * Similar to iterator BFS, but using greedy technic to select next vertex instead.
   * @param vertex
   * @return 
   * @throws estg.ed.exceptions.ElementNotFoundException 
   */
  @Override
  public NetworkADT<T> mstNetwork(T vertex) throws ElementNotFoundException {
    //Get index
    int index = this.getIndex(vertex);
    
    //Index is invalid
    if(index < 0)
      throw new ElementNotFoundException("Vertex was not found!");
    
   //Generate result graph
    NetworkADT<T> resultGraph = new Network<>();
        
    //Generate a priority max queue to store the weighted edges
    PriorityQueueADT<Integer> traverseQueue = new ArrayPriorityMaxQueue<>();
    
    //Get size
    int size = this.vertices.size();
    
    //Generate visited boolean array
    boolean[] visited = new boolean[size];
    for(int i = 0; i < visited.length; i++)
      visited[i] = false;
    
    //Generate antecessor boolean array
    int[] antecessor = new int[size];
    for(int i = 0; i < antecessor.length; i++)
      antecessor[i] = -1;
    
    //Enqueue first item
    traverseQueue.enqueue(index, 0);
    
    //Iterate
    this.iterateMST(resultGraph, traverseQueue, visited, antecessor);
        
    //Return result
    return resultGraph;
  }
  
  public DynamicArrayContract<DynamicArrayContract<Double>> adjacencyMatrix(){
    return this.adjMatrix;
  }
  
  public DynamicArrayContract<T> vertices(){
    return this.vertices;
  }
}