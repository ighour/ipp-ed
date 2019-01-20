/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.store;

import ed.trabalho.adt.PersonEmailOrderedList;
import ed.trabalho.adt.PersonIdOrderedList;
import ed.trabalho.adt.SocialNetwork;
import ed.trabalho.model.Person;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;

/**
 * Base of store.
 * Where all data of users (graph and lists) are stored.
 * @author igu
 */
public abstract class BaseStore {
  /**
   * Network with people obtained from JSON input.
   */
  protected NetworkADT<Person> network;
  
  /**
   * People ordered list by id.
   */
  protected OrderedListADT<Person> peopleById;
  
  /**
   * People ordered list by email.
   */
  protected OrderedListADT<Person> peopleByEmail;
  
  /**
   * Instantiates the store.
   * Avoids outside instanciation.
   */
  protected BaseStore(){
    this.network = new SocialNetwork<>();
    this.peopleById = new PersonIdOrderedList();
    this.peopleByEmail = new PersonEmailOrderedList();
  };
  
  /**
   * Clears all data from store.
   * By creating new network and lists.
   */
  public void clearStore(){
    this.network = new SocialNetwork<>();
    this.peopleById = new PersonIdOrderedList();
    this.peopleByEmail = new PersonEmailOrderedList();
  }
  
  /**
   * Returns the network.
   * For use in Jung Graph Viewer.
   * @return 
   */
  public SocialNetwork getNetwork(){
    return (SocialNetwork) this.network;
  }
}
