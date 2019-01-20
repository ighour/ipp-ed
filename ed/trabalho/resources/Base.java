/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources;

import ed.trabalho.store.Store;
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
  protected Store store;
  
  /**
   * Selects the store type.
   * 0 (default) => 1/visualizations (contact) is the weight.
   * 1 => 1 (constant) is the weight.
   */
  protected static int storeType;
  
  /**
   * Initiates with Store singleton.
   */
  public Base(){
    if(Base.storeType == 1)
      this.store = StoreNoWeight.getInstance();
    else
      this.store = Store.getInstance();
  }
  
  /**
   * Changes the store type.
   * @param type 
   */
  protected void setStoreType(int type){
    //Clear old store
    this.store.clearStore();
    
    //Set new type
    if(type == 1){
      Base.storeType = type;
      this.store = StoreNoWeight.getInstance();
    }
    else{
      Base.storeType = 0;
      this.store = Store.getInstance();
    }
  }
  
  /**
   * Show a message.
   * @param message 
   */
  protected void message(String message){
    JOptionPane.showMessageDialog(null, message);
  }
}
