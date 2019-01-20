/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.form.intermediate;

import ed.trabalho.adt.SocialNetwork;
import ed.trabalho.model.Person;
import ed.trabalho.resources.Base;
import ed.trabalho.resources.view.PeopleListView;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.EmptyCollectionException;
import estg.ed.exceptions.NotComparableException;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import estg.ed.list.OrderedArrayList;
import java.util.Iterator;

/**
 * Form to retrieve reachable users from another user.
 * @author igu
 */
public class NotReachableUsersByUserForm extends Base {
  /**
   * Creates new form FindPersonByIdForm
   */
  public NotReachableUsersByUserForm() {
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

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    labelPersonId.setText("ID");

    submitButton.setText("Search");
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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(59, 59, 59)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        .addContainerGap(33, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(submitButton)
        .addGap(142, 142, 142))
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
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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
           
    //Show users not reachable
    try {
      //Get reachable users
      NetworkADT<Person> resultGraph = (SocialNetwork) this.store.getMstNetwork(from);

      //Create result list
      OrderedListADT<Person> resultList = new OrderedArrayList();
      Iterator it = this.store.getPeopleByIdIterator();
      while(it.hasNext()){
        Person p = (Person) it.next();
        resultList.add(p);
      }
      
      //Remove reachable users from list
      Iterator reachable = resultGraph.iteratorBFS(from);
      while(reachable.hasNext()){
        Person p = (Person) reachable.next();
        resultList.remove(p);
      }
      
      //Show result in new frame
      PeopleListView view = new PeopleListView();
      view.setTitle("Not Reachable Users");
      view.setDesc("List of users who were not reachable from user '" + from.toString() + "'");
      view.loadPeople(resultList);
      view.pack();
      view.setVisible(true);
    }
    catch(ElementNotFoundException | NotComparableException | EmptyCollectionException e){
      this.message("Error processing action.");
    }
  }//GEN-LAST:event_submitButtonActionPerformed

  private void inputFromEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFromEmailActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_inputFromEmailActionPerformed

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
      java.util.logging.Logger.getLogger(NotReachableUsersByUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(NotReachableUsersByUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(NotReachableUsersByUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(NotReachableUsersByUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new NotReachableUsersByUserForm().setVisible(false);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField inputFromEmail;
  private javax.swing.JTextField inputFromID;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel labelPersonId;
  private javax.swing.JLabel labelPersonId1;
  private javax.swing.JButton submitButton;
  // End of variables declaration//GEN-END:variables
}
