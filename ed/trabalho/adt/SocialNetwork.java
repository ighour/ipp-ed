/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.adt;

import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.graph.Network;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.PriorityQueueADT;
import estg.ed.tree.binary.ArrayPriorityMinQueue;

/**
 * Implements a directional network with an adjacency matrix.
 * Add methods to retrieve adjacency matrix and vertices to generate network view with Jung.
 * @param <T>
 */
public class SocialNetwork<T> extends Network<T> implements NetworkADT<T> {
  /**
   * Returns a minimum spanning tree of the network from desired element.
   * Preference is to less weighted edge.
   * Uses recursion.
   * Similar to iterator BFS, but using greedy technic to select next vertex instead.
   * @param vertex
   * @return an instance of SocialNetwork
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
    NetworkADT<T> resultGraph = new SocialNetwork<>();
        
    //Generate a priority min queue to store the weighted edges
    PriorityQueueADT<Integer> traverseQueue = new ArrayPriorityMinQueue<>();
    
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