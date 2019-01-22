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
import estg.ed.exceptions.VertexIsNotAccessibleException;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import java.util.Iterator;

/**
 * Base of store.
 * Where all data of users (graph and lists) are stored.
 * Add methods to handle network, list and peoples.
 * Singleton pattern to use same store (of type) everytime.
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
   * Selects the store type.
   * 0 (default) => 1/visualizations (of contact) is the weight.
   * 1 => 1 (constant) is the weight.
   * 2 => 1/mentions (of contact) is the weight.
   */
  protected static int storeType;
  
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
   * Returns the unique instance of Store.
   * Based on storeType.
   * @return 
   */
  public static BaseStore getInstance(){
    switch (BaseStore.storeType) {
      case 1:
        return StoreNoWeight.Singleton.INSTANCE;
      case 2:
        return StoreMentions.Singleton.INSTANCE;
      default:
        return StoreVisualization.Singleton.INSTANCE;
    }
  }
  
  /**
   * Set store type to default.
   * 1/visualizations (of contact) is the weight.
   */
  public static void setStoreTypeDefault(){
    if(BaseStore.storeType != 0)
      BaseStore.setStoreType(0);
  }
  
  /**
   * Set store type to constant.
   * 1 (constant) is the weight.
   */
  public static void setStoreTypeConstant(){
    if(BaseStore.storeType != 1)
      BaseStore.setStoreType(1);
  }
  
  /**
   * Set store type to mentions.
   * 1/mentions (of contact) is the weight.
   */
  public static void setStoreTypeMentions(){
    if(BaseStore.storeType != 2)
      BaseStore.setStoreType(2);
  }
  
  private static void setStoreType(int type){
    //Get old store
    BaseStore oldStore = BaseStore.getInstance();
    
    //Set new type
    BaseStore.storeType = type;
    
    //Get new store
    BaseStore newStore = BaseStore.getInstance();
    
    //Clear new store
    newStore.clearStore();
    
    //Copy lists and network base
    newStore.peopleById = oldStore.peopleById;
    newStore.peopleByEmail = oldStore.peopleByEmail;
    newStore.network = oldStore.network;
    
    //Change edges values
    SocialNetwork network = (SocialNetwork) newStore.network;
    DynamicArrayContract<DynamicArrayContract<Double>> matrix = network.adjacencyMatrix();
    DynamicArrayContract<Person> vertices = network.vertices();
    for(int i = 0; i < network.size(); i++){
      for(int j = 0; j < network.size(); j++){
        //Has relation
        if(matrix.get(i).get(j) != Double.NEGATIVE_INFINITY){
          //Get edge value
          double edgeValue = BaseStore.getEdgeValue(vertices.get(i), vertices.get(j));
          
          //Update
          matrix.get(i).change(edgeValue, j);
        }
      }
    }

    //Clear old store
    oldStore.clearStore();
  }
  
  private static double getEdgeValue(Person from, Person to){
    switch(BaseStore.storeType){
      //Constant
      case 1: return 1.0;
      
      //Mentions
      case 2: return 1 / (double) BaseStore.getNumberOfMentionsToUser(to);
      
      //Visualizations
      default: return 1 / (double) to.getVisualizations();
    } 
  }
  
  /**
   * Get the store type.
   * @return 
   */
  public static String getStoreType(){
    switch(BaseStore.storeType){
      //Constant
      case 1: return "CONSTANT";
      
      //Mentions
      case 2: return "MENTIONS";
      
      //Visualizations
      default: return "DEFAULT";
    }
  }
  
  /**
   * Get number of mentions to user.
   * @param user
   * @return 
   */
  public static int getNumberOfMentionsToUser(Person user){
    //Get new user To count of mentions
    int count = 0;
    
    Iterator it = BaseStore.getInstance().peopleById.iterator();
    while(it.hasNext()){
      Person m = (Person) it.next();
      
      //Has mentioned the user
      if(m.isMention(user))
        count++;
    }
    
    return count;
  }
  
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
   * Get shortest path weight between users.
   * @param from
   * @param to
   * @return
   * @throws estg.ed.exceptions.ElementNotFoundException
   * @throws estg.ed.exceptions.VertexIsNotAccessibleException
   */
  public double getShortestPathWeight(Person from, Person to) throws ElementNotFoundException, VertexIsNotAccessibleException {
    return this.network.shortestPathWeight(from, to);
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
   * Get the media of contacts on network.
   * @return 
   */
  public double getContactMedia(){
    int total = 0;
    
    if(this.peopleById.size() == 0)
      return 0;
    
    Iterator it = this.peopleById.iterator();
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      total += p.getContactList().size();
    }

    return total / (double) this.peopleById.size();
  }
  
  /**
   * Get the media of contacts on reachable part of a network by a person.
   * @param person
   * @return 
   * @throws estg.ed.exceptions.ElementNotFoundException 
   */
  public double getContactMedia(Person person) throws ElementNotFoundException{
    //Only iterates on user's spawning tree
    NetworkADT<Person> resultNetwork = this.network.mstNetwork(person);

    if(resultNetwork.size() == 0)
      return 0;
    
    int total = 0;
    
    Iterator it = resultNetwork.iteratorBFS(person);
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      total += p.getContactList().size();
    }

    return total / (double) resultNetwork.size();
  }
  
  /**
   * Get the media of mentions on network.
   * @return 
   */
  public double getMentionMedia(){
    int total = 0;
    
    if(this.peopleById.size() == 0)
      return 0;
    
    Iterator it = this.peopleById.iterator();
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      total += p.getMentions();
    }

    return total / (double) this.peopleById.size();
  }
  
  /**
   * Get the media of mentions on reachable part of a network by a person.
   * @param person
   * @return 
   * @throws estg.ed.exceptions.ElementNotFoundException 
   */
  public double getMentionMedia(Person person) throws ElementNotFoundException{
    //Only iterates on user's spawning tree
    NetworkADT<Person> resultNetwork = this.network.mstNetwork(person);

    if(resultNetwork.size() == 0)
      return 0;
    
    int total = 0;
    
    Iterator it = resultNetwork.iteratorBFS(person);
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      total += p.getMentions();
    }

    return total / (double) resultNetwork.size();
  }
  
  /**
   * Check if it is possible to achieve person To by From in graph.
   * @param from
   * @param to
   * @return
   * @throws ElementNotFoundException 
   */
  public boolean hasRelation(Person from, Person to) throws ElementNotFoundException{
    try {
      this.network.shortestPathWeight(from, to);
      return true;
      
    } catch (VertexIsNotAccessibleException ex) {
      return false;
    }
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
    this.addNetworkEdge(from, to);
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
   * @param person
   * @param visualizations 
   */
  public void updateUserVisualizations(Person person, int visualizations){
    //Update visualizations
    person.setVisualizations(visualizations);
  }
  
  /**
   * Implements the weight when adding and edge.
   * @param from
   * @param to 
   * @throws estg.ed.exceptions.ElementNotFoundException 
   */
  protected abstract void addNetworkEdge(Person from, Person to) throws ElementNotFoundException;
}
