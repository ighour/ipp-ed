package ed.trabalho.resources.form.intermediate;

import ed.trabalho.model.Person;
import ed.trabalho.resources.Base;
import ed.trabalho.resources.view.PeopleListView;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.interfaces.DynamicArrayContract;

/**
 * Form to list company users with desired user reachable in graph.
 */
public class CompanyPeopleAndPersonContactsForm extends Base {

    /**
     * Creates new form
     */
    public CompanyPeopleAndPersonContactsForm() {
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

        submitButton = new javax.swing.JButton();
        inputCompanyName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelPersonId2 = new javax.swing.JLabel();
        labelPersonId3 = new javax.swing.JLabel();
        inputUserEmail = new javax.swing.JTextField();
        inputUserID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        submitButton.setText("Search");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        inputCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCompanyNameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Company Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("User");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel4.setText("(ID or email)");

        labelPersonId2.setText("ID");

        labelPersonId3.setText("Email");

        inputUserEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUserEmailActionPerformed(evt);
            }
        });

        inputUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUserIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelPersonId2)
                                        .addComponent(labelPersonId3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(33, 33, 33)
                                    .addComponent(inputCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(submitButton)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPersonId2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPersonId3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
      //Can use only one of input per person (ID OR Email)
      if (inputUserID.getText().isEmpty() && inputUserEmail.getText().isEmpty()) {
          this.message("Need to insert user email or ID.");
          return;
      } else if (!inputUserID.getText().isEmpty() && !inputUserEmail.getText().isEmpty()) {
          this.message("Need to inser user email or ID, not both.");
          return;
      } else if (inputCompanyName.getText().isEmpty()) {
          this.message("Need to insert company name.");
          return;
      }

      //Search user
      Person user;

      try {
          //By id
          if (!inputUserID.getText().isEmpty()) {
              user = this.findUserById(Integer.parseInt(inputUserID.getText()));
          } //By email
          else {
              user = this.findUserByEmail(inputUserEmail.getText());
          }
      } catch (ElementNotFoundException e) {
          this.message("User was not found.");
          return;
      }

      //Get users list by company name
      String companyName = inputCompanyName.getText();

      //Creates result list
      DynamicArrayContract<Person> resultList = this.getListOfUsersFromCompanyWithRelationToUser(user, companyName);

      if (resultList.size() == 0) {
          this.message("There is no one from company '" + companyName + "' who can achieve user '" + user.toString() + "' at graph.");
      } else {
          //Show result in new frame
          PeopleListView view = new PeopleListView();
          view.setTitle("Company People x Person Contacts");
          view.setDesc("List of users who work(ed) in company '" + companyName + "' and can achieve user '" + user.toString() + "' in graph.");
          view.loadPeople(resultList);
          view.pack();
          view.setVisible(true);
      }
  }//GEN-LAST:event_submitButtonActionPerformed

  private void inputUserEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUserEmailActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_inputUserEmailActionPerformed

  private void inputUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUserIDActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_inputUserIDActionPerformed

  private void inputCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCompanyNameActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_inputCompanyNameActionPerformed

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
            java.util.logging.Logger.getLogger(CompanyPeopleAndPersonContactsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyPeopleAndPersonContactsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyPeopleAndPersonContactsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyPeopleAndPersonContactsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyPeopleAndPersonContactsForm().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputCompanyName;
    private javax.swing.JTextField inputUserEmail;
    private javax.swing.JTextField inputUserID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelPersonId2;
    private javax.swing.JLabel labelPersonId3;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
