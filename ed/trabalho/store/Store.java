/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.store;

import ed.trabalho.adt.PersonEmailOrderedList;
import ed.trabalho.adt.PersonIdOrderedList;
import ed.trabalho.adt.SocialNetwork;
import ed.trabalho.exceptions.UserIsAlreadyAContactException;
import ed.trabalho.exceptions.UserIsAlreadyAddedException;
import ed.trabalho.exceptions.UserIsAlreadyMentionedException;
import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.EmptyCollectionException;
import estg.ed.exceptions.NotComparableException;
import java.util.Iterator;

/**
 * Stores all data of application.
 * Add methods to handle network, list and peoples.
 * Singleton pattern to use same store everytime.
 * @author igu
 */
public class Store extends BaseStore {
  /**
   * Instantiates the store.
   * Avoids outside instanciation.
   */
  protected Store(){
    super();
  };
  
  /**
   * Inner class containing the instance.
   */
  protected static class Singleton {
    protected static final Store INSTANCE = new Store();
  }
  
  /**
   * Returns the unique instance of Store.
   * @return 
   */
  public static Store getInstance(){
    return Singleton.INSTANCE;
  }
  
  /**
   * Get minimum spawning tree of network by an user.
   * @param person
   * @return
   * @throws ElementNotFoundException 
   */
  public SocialNetwork getMstNetwork(Person person) throws ElementNotFoundException{
    return (SocialNetwork) this.network.mstNetwork(person);
  }
  
  /**
   * Get iterator shortest path between users.
   * @param from
   * @param to
   * @return
   */
  public Iterator getIteratorShortestPath(Person from, Person to) {
    return this.network.iteratorShortestPath(from, to);
  }
  
  /**
   * Returns number of people in graph and lists.
   * @return 
   */
  public int getPeopleCount(){
    return this.peopleById.size();
  }
  
  /**
   * Get the next valid id for creating an user.
   * @return 
   */
  public int getNextValidId(){
    int id;
    try {
      id = this.peopleById.last().getId() + 1;
      
    } catch (EmptyCollectionException ex) {
      id = 0;
    }
    
    return id;
  }
  
  /**
   * Returns the iterator for peopleById list.
   * @return 
   */
  public Iterator getPeopleByIdIterator(){
    return this.peopleById.iterator();
  }
  
  /**
   * Search an user by id.
   * Uses binary search on peopleById list.
   * @param id
   * @return
   * @throws ElementNotFoundException 
   */
  public Person searchUserById(int id) throws ElementNotFoundException{
    return ((PersonIdOrderedList)this.peopleById).searchById(id);
  }
  
  /**
   * Search an user by email.
   * Uses binary search on peopleByEmail list.
   * @param email
   * @return
   * @throws ElementNotFoundException 
   */
  public Person searchUserByEmail(String email) throws ElementNotFoundException{
    return ((PersonEmailOrderedList)this.peopleByEmail).searchByEmail(email);
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
  
  /**
   * Add an user to store.
   * Add vertex to network.
   * Add to peopleById and peopleByEmail lists.
   * @param p
   * @throws UserIsAlreadyAddedException
   * @throws NotComparableException 
   */
  public void addUser(Person p) throws UserIsAlreadyAddedException, NotComparableException{
    try {
      //Check if is already added
      ((PersonIdOrderedList)this.peopleById).searchById(p.getId());
    
    } catch (ElementNotFoundException ex) {
      //Add user
      this.network.addVertex(p);
      this.peopleById.add(p);
      this.peopleByEmail.add(p);
      return;
    }
         
    //User already exists
    throw new UserIsAlreadyAddedException("User '" + p.toString() + "' is already added.");
  }
  
  /**
   * Add a contact to an user.
   * Add to user contact list.
   * Create edge in network between users.
   * @param from
   * @param to
   * @throws ElementNotFoundException 
   * @throws ed.trabalho.exceptions.UserIsAlreadyAContactException 
   */
  public void addUserContact(Person from, Person to) throws ElementNotFoundException, UserIsAlreadyAContactException{
    //Is already a contact
    if(from.isContact(to))
      throw new UserIsAlreadyAContactException("User '" + to.toString() + "' is already a contact of '" + from.toString() + "'.");
    
    //Add to contacts
    from.getContactList().add(to, from.getContactList().size());
    
    //Add edge to network
    this.network.addEdge(from, to, 1 / (double) to.getVisualizations());
  }
  
  /**
   * Remove user from contact list.
   * Remove from user contact list.
   * Remove edge in network between users.
   * @param from
   * @param index
   */
  public void removeUserContact(Person from, int index){
    //Get contact
    Person contact = from.getContactList().get(index);

    //Remove from contacts
    from.getContactList().remove(index);
    
    try {
      //Remove edge from network
      this.network.removeEdge(from, contact);
    } catch (ElementNotFoundException ex) {}
  }
  
  /**
   * Add a mention to an user.
   * Add to user mention list.
   * @param from
   * @param to
   * @throws ElementNotFoundException 
   * @throws ed.trabalho.exceptions.UserIsAlreadyMentionedException 
   */
  public void addUserMention(Person from, Person to) throws ElementNotFoundException, UserIsAlreadyMentionedException{
    //Is already a contact
    if(from.isMention(to))
      throw new UserIsAlreadyMentionedException("User '" + to.toString() + "' is already mentioned by '" + from.toString() + "'.");
    
    //Add to mentions
    from.getMentionList().add(to, from.getMentionList().size());
  }
  
  /**
   * Remove a mention from an user.
   * Remove from user mention list.
   * @param from
   * @param index
   */
  public void removeUserMention(Person from, int index){
    //Remove from mentions
    from.getMentionList().remove(index);
  }
  
  /**
   * Update user email.
   * Removes and insert again in peopleByEmail list to sync index.
   * @param person
   * @param email 
   */
  public void updateUserEmail(Person person, String email){
    //Update email
    person.setEmail(email);
    
    try {
      //Remove from list
      this.peopleByEmail.remove(person);
    } catch (EmptyCollectionException | ElementNotFoundException ex) {}
    
    try {
      //Add to list
      this.peopleByEmail.add(person);
    } catch (NotComparableException ex) {}
  }
  
  /**
   * Update user visualizations.
   * Update network edges (relation with contacts) using new visualization count.
   * @param person
   * @param visualizations 
   */
  public void updateUserVisualizations(Person person, int visualizations){
    //Update visualizations
    person.setVisualizations(visualizations);
    
    //Update edges on network
    Iterator list = this.peopleById.iterator();
    while(list.hasNext()){
      Person p = (Person) list.next();

      //Current Person is a contact of P
      //Update edge weight
      if(p.isContact(person))
        try {
          this.network.addEdge(p, person, visualizations);
      } catch (ElementNotFoundException ex) {}
    }
  }
}
