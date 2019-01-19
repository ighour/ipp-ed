/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.form.model;

import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.EmptyCollectionException;

/**
 * Extends PersonViewEdit frame to create a person before loading data.
 * @author igu
 */
public class PersonCreate extends PersonViewEdit {
  /**
   * Create an "empty" person.
   * Using the last person id found plus one.
   * If list is empty, put ID 1.
   */
  public final void setPerson(){
    //Need to load store before
    if(this.store == null){
      this.message("Error creating person. Store was not loaded yet.");
      return;
    }
    
    //Get id
    int id;
    try {
      id = this.store.getPeopleById().last().getId() + 1;
      
    } catch (EmptyCollectionException ex) {
      id = 0;
    }
    
    //Create person
    Person newPerson = new Person(id, "", 0, "", 0);
    
    //Add to store
    try {
      this.store.getPeopleById().add(newPerson);
      this.store.getPeopleByEmail().add(newPerson);
      this.store.getNetwork().addVertex(newPerson);
    }
    catch(Exception e){
      //Removes from list and graph (if needed)
      try {
        this.store.getPeopleById().remove(newPerson);
      } catch (EmptyCollectionException | ElementNotFoundException ex) {}
      
      try {
        this.store.getPeopleByEmail().remove(newPerson);
      } catch (EmptyCollectionException | ElementNotFoundException ex) {}
      
      try {
        this.store.getNetwork().removeVertex(newPerson);
      } catch (ElementNotFoundException ex) {}

      this.message("Error adding new user.");
      return;
    }
    
    //Populate as PersonViewEdit class
    super.setPerson(newPerson);
  }
}
