/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.store;

import ed.trabalho.exceptions.UserIsAlreadyMentionedException;
import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 * Stores all data of application.
 * Uses 1/mentions (of contact) as edge weight.
 * @author igu
 */
public class StoreMentions extends BaseStore {
  /**
   * Instantiates the store.
   * Avoids outside instanciation.
   */
  protected StoreMentions(){
    super();
  };
  
  /**
   * Inner class containing the instance.
   */
  protected static class Singleton {
    protected static final StoreMentions INSTANCE = new StoreMentions();
  }
  
  /**
   * Add a mention to an user.
   * Add to user mention list.
   * Updates weights on edges.
   * @param from user reference
   * @param to user to add
   * @throws ElementNotFoundException user was not found
   * @throws ed.trabalho.exceptions.UserIsAlreadyMentionedException user is already a mention
   */
  @Override
  public void addUserMention(Person from, Person to) throws ElementNotFoundException, UserIsAlreadyMentionedException{
    super.addUserMention(from, to);
    
    this.updateEdgesByMention(to);
  }
  
  /**
   * Remove a mention from an user.
   * Remove from user mention list.
   * Updates weights on edges.
   * @param from user reference
   * @param index index of user to remove from user mention list
   */
  @Override
  public void removeUserMention(Person from, int index){
    Person to = from.getMentionList().get(index);
    
    super.removeUserMention(from, index);
    
    this.updateEdgesByMention(to);
  }
  
  private void updateEdgesByMention(Person to){
    //Get new user To count of mentions
    int count = 0;
    
    Iterator it = this.peopleById.iterator();
    while(it.hasNext()){
      Person m = (Person) it.next();
      
      //Has mentioned the user
      if(m.isMention(to))
        count++;
    }
    
    //Check connected users
    it = this.peopleById.iterator();
    while(it.hasNext()){
      Person c = (Person) it.next();
      
      //Update edge
      if(c.isContact(to))
        try {
          this.network.addEdge(c, to, count);
        } catch (ElementNotFoundException ex) {}
    }
  }
  
  /**
   * Implements the weight when adding and edge.
   * Uses 1/mentions (from To person).
   * @param from first user
   * @param to last user
   * @throws estg.ed.exceptions.ElementNotFoundException user was not found
   */
  @Override
  protected void addNetworkEdge(Person from, Person to) throws ElementNotFoundException {
    this.network.addEdge(from, to, 1 / (double) to.getMentions());
  }
}
