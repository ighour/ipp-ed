/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.store;

import ed.trabalho.exceptions.UserIsAlreadyAContactException;
import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;

/**
 * Stores all data of application.
 * Add methods to handle network, list and peoples.
 * Singleton pattern to use same store everytime.
 * Uses 1 (constant) as weight.
 * @author igu
 */
public class StoreNoWeight extends Store {
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
   * Returns the unique instance of Store.
   * @return 
   */
  public static StoreNoWeight getInstance(){
    return Singleton.INSTANCE;
  }
  
  /**
   * Add a contact to an user.
   * Add to user contact list.
   * Create edge in network between users.
   * Edges are always 1.
   * @param from
   * @param to
   * @throws ElementNotFoundException 
   * @throws ed.trabalho.exceptions.UserIsAlreadyAContactException 
   */
  @Override
  public void addUserContact(Person from, Person to) throws ElementNotFoundException, UserIsAlreadyAContactException{
    super.addUserContact(from, to);
    
    //Add edge to network (override)
    this.network.addEdge(from, to, 1);
  }
}
