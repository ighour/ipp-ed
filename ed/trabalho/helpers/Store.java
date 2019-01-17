/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.helpers;

import ed.trabalho.model.Person;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;

/**
 * Stores all data of application.
 * @author igu
 */
public class Store {
  /**
   * Network with people obtained from JSON input.
   */
  private final NetworkADT<Person> network;
  
  /**
   * People ordered list by id.
   */
  private final OrderedListADT<Person> peopleById;
  
  /**
   * People ordered list by email.
   */
  private final OrderedListADT<Person> peopleByEmail;
  
  /**
   * Instantiates the store with network and people lists.
   * @param network
   * @param peopleById
   * @param peopleByEmail 
   */
  public Store(NetworkADT<Person> network, OrderedListADT<Person> peopleById, OrderedListADT<Person> peopleByEmail){
    this.network = network;
    this.peopleById = peopleById;
    this.peopleByEmail = peopleByEmail;
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
  
  
}
