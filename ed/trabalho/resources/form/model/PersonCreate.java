/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.form.model;

import ed.trabalho.model.Person;

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
    int id = this.store.getNextValidId();
    
    //Create person
    Person newPerson = new Person(id, "", 0, "", 0);
    
    //Add to store
    try {
      this.store.addUser(newPerson);
    }
    catch(Exception e){
      this.message("Error adding new user.");
      return;
    }
    
    //Populate as PersonViewEdit class
    super.setPerson(newPerson);
  }
}
