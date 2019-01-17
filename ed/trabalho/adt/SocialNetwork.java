/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.adt;

import estg.ed.graph.Network;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;

/**
 * Implements a directional network with an adjacency matrix.
 * Add methods to retrieve adjacency matrix and vertices to generate network view with Jung.
 * @param <T>
 */
public class SocialNetwork<T> extends Network<T> implements NetworkADT<T> {
  public DynamicArrayContract<DynamicArrayContract<Double>> adjacencyMatrix(){
    return this.adjMatrix;
  }
  
  public DynamicArrayContract<T> vertices(){
    return this.vertices;
  }
}