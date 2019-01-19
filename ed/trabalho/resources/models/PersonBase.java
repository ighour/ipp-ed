/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.models;

import ed.trabalho.helpers.Store;
import ed.trabalho.model.Person;
import javax.swing.JOptionPane;

/**
 * Base for person view frame.
 * @author igu
 */
public abstract class PersonBase extends javax.swing.JFrame {
  /**
   * Person information.
   */
  protected Person person;
  
  /**
   * Stores with all application data.
   */
  protected Store store;
  
 /**
  * Show a message.
  * @param message 
  */
  protected void message(String message){
    JOptionPane.showMessageDialog(null, message);
  }
  
  /**
   * Set store access to component.
   * @param store 
   */
  public void setStore(Store store){
    this.store = store;
  }
  
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
