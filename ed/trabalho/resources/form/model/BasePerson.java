/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.form.model;

import ed.trabalho.resources.Base;
import ed.trabalho.model.Person;

/**
 * Base for person frame.
 * @author igu
 */
public abstract class BasePerson extends Base {
  /**
   * Person information.
   */
  protected Person person;
  
  /**
   * Get the current person.
   * To manipulate in forms.
   * @return 
   */
  public Person getPerson(){
    return this.person;
  }
  
  /**
   * Loads all the skills of a certain person.
   */
  public abstract void loadSkill();
  
  /**
   * Loads all the professional information of a certain person.
   */
  public abstract void loadProfessional();
  
  /**
   * Loads all the contacts of a certain person.
   */
  public abstract void loadContacts();
  
  /**
   * Loads all the mentions of a certain person.
   */
  public abstract void loadMentions();
    
  /**
   * Loads all the academic information of a certain person.
   */
  public abstract void loadAcademic();
}
