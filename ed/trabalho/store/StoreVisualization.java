/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.store;

import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 * Stores all data of application.
 * Uses 1/visualization (of contact) as edge weight.
 * @author igu
 */
public class StoreVisualization extends BaseStore {
  /**
   * Instantiates the store.
   * Avoids outside instanciation.
   */
  protected StoreVisualization(){
    super();
  };
  
  /**
   * Inner class containing the instance.
   */
  protected static class Singleton {
    protected static final StoreVisualization INSTANCE = new StoreVisualization();
  }
  
  /**
   * Update user visualizations.
   * Update network edges (relation with contacts) using new visualization count.
   * @param person
   * @param visualizations 
   */
  @Override
  public void updateUserVisualizations(Person person, int visualizations){
    super.updateUserVisualizations(person, visualizations);

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
  
  /**
   * Implements the weight when adding and edge.
   * Uses 1/visualizations (from To person).
   * @param from
   * @param to 
   * @throws estg.ed.exceptions.ElementNotFoundException 
   */
  @Override
  protected void addNetworkEdge(Person from, Person to) throws ElementNotFoundException {
    this.network.addEdge(from, to, 1 / (double) to.getVisualizations());
  }
}