/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.store;

import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;

/**
 * Stores all data of application.
 * Uses 1 (constant) as weight.
 * @author igu
 */
public class StoreNoWeight extends BaseStore {
  /**
   * Instantiates the store.
   * Avoids outside instanciation.
   */
  protected StoreNoWeight(){
    super();
  };
  
  /**
   * Inner class containing the instance.
   */
  protected static class Singleton {
    protected static final StoreNoWeight INSTANCE = new StoreNoWeight();
  }
  
  /**
   * Implements the weight when adding and edge.
   * Uses 1 (constant).
   * @param from first user
   * @param to last user
   * @throws estg.ed.exceptions.ElementNotFoundException user was not found
   */
  @Override
  protected void addNetworkEdge(Person from, Person to) throws ElementNotFoundException {
    this.network.addEdge(from, to, 1);
  }
}
