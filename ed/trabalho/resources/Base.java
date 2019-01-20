/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources;

import ed.trabalho.store.BaseStore;
import ed.trabalho.store.StoreVisualization;
import ed.trabalho.store.StoreNoWeight;
import javax.swing.JOptionPane;

/**
 * Base for every frame.
 * @author igu
 */
public abstract class Base extends javax.swing.JFrame {
  /**
   * Stores with all application data.
   */
  protected BaseStore store;
  
  /**
   * Initiates with Store singleton.
   */
  public Base(){
    this.store = BaseStore.getInstance();
  }
  
  /**
   * Show a message.
   * @param message 
   */
  protected void message(String message){
    JOptionPane.showMessageDialog(null, message);
  }
}
