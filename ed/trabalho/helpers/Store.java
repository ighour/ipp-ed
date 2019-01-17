/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.helpers;

import ed.trabalho.adt.PersonEmailOrderedList;
import ed.trabalho.adt.PersonIdOrderedList;
import ed.trabalho.adt.ReverseNetwork;
import ed.trabalho.model.Person;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import java.util.Iterator;

/**
 * Stores all data of application.
 * Also some helper functions interacting with network and lists.
 * @author igu
 */
public class Store {
  /**
   * Network with people obtained from JSON input.
   */
  private NetworkADT<Person> network;
  
  /**
   * People ordered list by id.
   */
  private OrderedListADT<Person> peopleById;
  
  /**
   * People ordered list by email.
   */
  private OrderedListADT<Person> peopleByEmail;
  
  /**
   * Instantiates the store with network and people lists.
   */
  public Store(){
    this.network = new ReverseNetwork<>();
    this.peopleById = new PersonIdOrderedList();
    this.peopleByEmail = new PersonEmailOrderedList();
  }

  /**
   * Get Network.
   * @return 
   */
  public NetworkADT<Person> getNetwork() {
    return network;
  }

  /**
   * Get people list ordered by id.
   * @return 
   */
  public OrderedListADT<Person> getPeopleById() {
    return peopleById;
  }

  /**
   * Get people list ordered by email.
   * @return 
   */
  public OrderedListADT<Person> getPeopleByEmail() {
    return peopleByEmail;
  }
  
  /**
   * Clears all data from store.
   * By creating new network and lists.
   */
  public void clearStore(){
    this.network = new ReverseNetwork<>();
    this.peopleById = new PersonIdOrderedList();
    this.peopleByEmail = new PersonEmailOrderedList();
  }
  
  /**
   * Check if graph is complete.
   * @return 
   */
  public boolean graphIsComplete(){
    //Total amount of people (vertices) in graph
    int peopleCount = this.peopleById.size();
    
    Iterator it = this.peopleById.iterator();
    
    //Compare to contacts number of each Person
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      //Is not connected to everyone else
      if(p.getContactList().size() < peopleCount - 1)
        return false;
    }
    
    return true;
  }
  
}
