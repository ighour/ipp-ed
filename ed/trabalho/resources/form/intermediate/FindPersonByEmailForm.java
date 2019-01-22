/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.form.intermediate;

import ed.trabalho.model.Person;
import ed.trabalho.resources.Base;
import ed.trabalho.resources.form.model.PersonViewEdit;
import estg.ed.exceptions.ElementNotFoundException;

/**
 * Form to retrieve Person info by email input.
 * @author igu
 */
public class FindPersonByEmailForm extends Base {
  /**
   * Creates new form FindPersonByIdForm
   */
  public FindPersonByEmailForm() {
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
    inputPersonEmail = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    labelPersonId.setText("Email");

    submitButton.setText("Buscar");
    submitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitButtonActionPerformed(evt);
      }
    });

    inputPersonEmail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        inputPersonEmailActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(46, 46, 46)
        .addComponent(labelPersonId)
        .addGap(42, 42, 42)
        .addComponent(inputPersonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
        .addComponent(submitButton)
        .addGap(47, 47, 47))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(50, 50, 50)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelPersonId)
          .addComponent(inputPersonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(submitButton))
        .addContainerGap(73, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void inputPersonEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPersonEmailActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_inputPersonEmailActionPerformed

  private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
    //Check input is valid
    if(inputPersonEmail.getText().isEmpty()){
      this.message("Email cannot be empty.");
      return;
    }
    
    //Search by Email
    try {
      Person result = this.findUserByEmail(inputPersonEmail.getText());
      
      //Open person view
      PersonViewEdit personView = new PersonViewEdit();
      personView.setTitle("User: " + result.getEmail() + " (Email)");
      personView.setPerson(result);
      personView.pack();
      personView.setVisible(true);
      
      //Close frame
      this.dispose();
    }
    catch(ElementNotFoundException e){
      this.message("User was not found.");
    }
    catch(NullPointerException e){
      this.message("JSON file was not loaded.");
    }
    catch(Exception e){
      this.message("Invalid parameter.");
    }
  }//GEN-LAST:event_submitButtonActionPerformed

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
      java.util.logging.Logger.getLogger(FindPersonByEmailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FindPersonByEmailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FindPersonByEmailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FindPersonByEmailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FindPersonByEmailForm().setVisible(false);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField inputPersonEmail;
  private javax.swing.JLabel labelPersonId;
  private javax.swing.JButton submitButton;
  // End of variables declaration//GEN-END:variables
}
