/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources;

import ed.trabalho.helpers.Store;
import javax.swing.JOptionPane;

/**
 * Base for every frame.
 * @author igu
 */
public abstract class Base extends javax.swing.JFrame {
  /**
   * Stores with all application data.
   */
  protected Store store;
  
  /**
   * Set store access to component.
   * @param store 
   */
  public void setStore(Store store){
    this.store = store;
  }
  
  /**
   * Show a message.
   * @param message 
   */
  protected void message(String message){
    JOptionPane.showMessageDialog(null, message);
  }
}
