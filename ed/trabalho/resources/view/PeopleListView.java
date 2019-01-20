/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.view;

import ed.trabalho.model.Person;
import ed.trabalho.resources.Base;
import estg.ed.exceptions.EmptyCollectionException;
import estg.ed.interfaces.BaseQueueADT;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.ListADT;

/**
 * Show a list of people.
 * @author igu
 */
public class PeopleListView extends Base {

  /**
   * Creates new
   */
  public PeopleListView() {
    initComponents();
  }
  
  /**
   * Sets the title and description labels.
   * @param desc 
   */
  public void setDesc(String desc){
    this.descLabel.setText(desc);
  }
  
  /**
   * Loads a list of people.
   * @param source
   */
  public void loadPeople(Person[] source) {
    int size = source.length;
    
    String[] list = new String[size];
    
    for(int i = 0; i < size; i++)
      list[i] = source[i].toString();
    
    this.peopleList.setListData(list); 
  }
  
  /**
   * Loads a list of people.
   * @param source
   */
  public void loadPeople(ListADT<Person> source) {
    int size = source.size();
    
    String[] list = new String[size];
    
    int count = 0;
    while(!source.isEmpty()){
      try {
        list[count] = source.removeFirst().toString();
      } catch (EmptyCollectionException ex) {}
      
      count++;
    }
    
    this.peopleList.setListData(list); 
  }
  
  /**
   * Loads a list of people.
   * @param source
   */
  public void loadPeople(DynamicArrayContract<Person> source) {
    int size = source.size();
    
    String[] list = new String[size];
    
    for(int i = 0; i < size; i++)
      list[i] = source.get(i).toString();
    
    this.peopleList.setListData(list); 
  }
  
  /**
   * Loads a list of people.
   * @param source
   */
  public void loadPeople(BaseQueueADT<Person> source) {
    int size = source.size();
    
    String[] list = new String[size];
    
    int count = 0;
    while(!source.isEmpty()){
      try {
        list[count] = source.dequeue().toString();
      } catch (EmptyCollectionException ex) {}
      
      count++;
    }
    
    this.peopleList.setListData(list); 
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTextField1 = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    peopleList = new javax.swing.JList<>();
    descLabel = new javax.swing.JLabel();

    jTextField1.setText("jTextField1");

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    peopleList.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    peopleList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(peopleList);

    descLabel.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
    descLabel.setText("Shows a list of people.");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(66, 66, 66)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane1)
          .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        .addContainerGap(72, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(42, 42, 42)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(39, 39, 39)
        .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(60, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(PeopleListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PeopleListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PeopleListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PeopleListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PeopleListView().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel descLabel;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JList<String> peopleList;
  // End of variables declaration//GEN-END:variables
}
