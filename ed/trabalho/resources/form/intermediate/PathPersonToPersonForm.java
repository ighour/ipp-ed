/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.form.intermediate;

import ed.trabalho.adt.SocialNetwork;
import ed.trabalho.helpers.Viewer;
import ed.trabalho.model.Person;
import ed.trabalho.resources.Base;
import ed.trabalho.store.BaseStore;
import estg.ed.exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 * Form to retrieve from and to people to calculate minimal path in graph.
 * @author igu
 */
public class PathPersonToPersonForm extends Base {
  /**
   * Creates new form FindPersonByIdForm
   */
  public PathPersonToPersonForm() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    labelPersonId = new javax.swing.JLabel();
    submitButton = new javax.swing.JButton();
    inputFromID = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    labelPersonId1 = new javax.swing.JLabel();
    inputFromEmail = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    labelPersonId2 = new javax.swing.JLabel();
    labelPersonId3 = new javax.swing.JLabel();
    inputToEmail = new javax.swing.JTextField();
    inputToID = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    labelPersonId.setText("ID");

    submitButton.setText("Calcular Menor Caminho");
    submitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitButtonActionPerformed(evt);
      }
    });

    inputFromID.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        inputFromIDActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel1.setText("Usuário de Origem");

    jLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
    jLabel2.setText("(ID ou email)");

    labelPersonId1.setText("Email");

    inputFromEmail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        inputFromEmailActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel3.setText("Usuário de Destino");

    jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
    jLabel4.setText("(ID ou email)");

    labelPersonId2.setText("ID");

    labelPersonId3.setText("Email");

    inputToEmail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        inputToEmailActionPerformed(evt);
      }
    });

    inputToID.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        inputToIDActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(submitButton)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(59, 59, 59)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addGap(27, 27, 27)
            .addComponent(jLabel4))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(labelPersonId2)
              .addComponent(labelPersonId3))
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(inputToEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputToID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(27, 27, 27)
            .addComponent(jLabel2))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(labelPersonId)
              .addComponent(labelPersonId1))
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(inputFromEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputFromID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(153, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(22, 22, 22)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelPersonId)
          .addComponent(inputFromID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelPersonId1)
          .addComponent(inputFromEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabel4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelPersonId2)
          .addComponent(inputToID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelPersonId3)
          .addComponent(inputToEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(25, 25, 25)
        .addComponent(submitButton)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
    //Can use only one of input per person (ID OR Email)
    if(inputFromID.getText().isEmpty() && inputFromEmail.getText().isEmpty()){
      this.message("Need to insert ID or Email of From user.");
      return;
    }
    else if(!inputFromID.getText().isEmpty() && !inputFromEmail.getText().isEmpty()){
      this.message("Need to insert ID or Email of From user, not both.");
      return;
    }
    else if(inputToID.getText().isEmpty() && inputToEmail.getText().isEmpty()){
      this.message("Need to insert ID or Email of To user.");
      return;
    }
    else if(!inputToID.getText().isEmpty() && !inputToEmail.getText().isEmpty()){
      this.message("Need to insert ID or Email of To user, not both.");
      return;
    }
    
    //Search from
    Person from;
    
    try{
      //By id
      if(!inputFromID.getText().isEmpty()){
        int fromID = Integer.parseInt(inputFromID.getText());
        from = this.store.searchUserById(fromID);
      }
      
      //By email
      else {
        String fromEmail = inputFromEmail.getText();
        from = this.store.searchUserByEmail(fromEmail);
      }
    }
    catch(ElementNotFoundException e){
      this.message("From user was not found.");
      return;
    }
    
    //Search to
    Person to;
    
    try{
      //By id
      if(!inputToID.getText().isEmpty()){
        int toID = Integer.parseInt(inputToID.getText());
        to = this.store.searchUserById(toID);
      }
      
      //By email
      else {
        String toEmail = inputToEmail.getText();
        to = this.store.searchUserByEmail(toEmail);
      }
    }
    catch(ElementNotFoundException e){
      this.message("To user was not found.");return;
    }
    
    //Get path
    Iterator it = this.store.getIteratorShortestPath(from, to);
    
    //There is no path
    if(it.hasNext() == false){
      this.message("There is no path between From and To users.");
      return;
    }
    
    //Construct a graph to show the path with the Jung
    try {
      SocialNetwork resultGraph = new SocialNetwork();
      Person last = null;
      
      //Populate the view graph with users in minimum path
      while(it.hasNext()){
        Person p = (Person) it.next();

        resultGraph.addVertex(p);

        //There is a user before -> add an edge
        if(last != null){
          resultGraph.addEdge(last, p, 1 / (double) p.getVisualizations());
        }

        last = p;
      }
      
      //Show as Jung Graph
      Viewer resultView = new Viewer();
      resultView.create(resultGraph, BaseStore.getStoreType());
      resultView.showFrame("Minimal Path Graph");
    }
    catch(ElementNotFoundException e){
      this.message("Error processing action.");
    }
  }//GEN-LAST:event_submitButtonActionPerformed

  private void inputFromEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFromEmailActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_inputFromEmailActionPerformed

  private void inputToEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputToEmailActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_inputToEmailActionPerformed

  private void inputToIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputToIDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_inputToIDActionPerformed

  private void inputFromIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFromIDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_inputFromIDActionPerformed

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
      java.util.logging.Logger.getLogger(PathPersonToPersonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PathPersonToPersonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PathPersonToPersonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PathPersonToPersonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PathPersonToPersonForm().setVisible(false);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField inputFromEmail;
  private javax.swing.JTextField inputFromID;
  private javax.swing.JTextField inputToEmail;
  private javax.swing.JTextField inputToID;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel labelPersonId;
  private javax.swing.JLabel labelPersonId1;
  private javax.swing.JLabel labelPersonId2;
  private javax.swing.JLabel labelPersonId3;
  private javax.swing.JButton submitButton;
  // End of variables declaration//GEN-END:variables
}
