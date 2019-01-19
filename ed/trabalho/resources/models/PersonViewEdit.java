package ed.trabalho.resources.models;

import ed.trabalho.model.Person;
import java.util.Iterator;

/**
 * View or Edit a person.
 * Also, view all person attributes.
 * @author igu
 */
public class PersonViewEdit extends PersonBase {  
  /**
   * Shows and edit a person.
   */
  public PersonViewEdit() {
    initComponents();
  }

  /**
   * Set person data to form/view. 
   * @param person
   */
  public void setPerson(Person person){
    this.person = person;
    this.inputID.setText(String.valueOf(person.getId()));
    this.inputName.setText(person.getName());
    this.inputAge.setText(String.valueOf(person.getAge()));
    this.inputEmail.setText(person.getEmail());
    this.inputVisualizacoes.setText(String.valueOf(person.getVisualizations()));
    this.inputCountMentions.setText(String.valueOf(person.getMentions()));
    this.loadSkill();
    this.loadProfessional();
    this.loadContacts();
    this.loadMentions();
    this.loadAcademic();
  }
  
  /**
   * Loads all the skills of a certain person.
   */
  @Override
  public void loadSkill() {
    int size = this.person.getSkillList().size();
    
    String[] list = new String[size];
    
    for(int i = 0; i < size; i++)
      list[i] = this.person.getSkillList().get(i).toString();
    
    this.skillList.setListData(list); 
  }
  
  /**
   * Loads all the professional information of a certain person.
   */
  @Override
  public void loadProfessional() {
    int size = this.person.getProfessionalList().size();
    
    String[] list = new String[size];
    
    for (int i = 0; i < size; i++)
      list[i] = this.person.getProfessionalList().get(i).toString();
    
    this.professionalList.setListData(list);
  }
  
  /**
   * Loads all the contacts of a certain person.
   */
  @Override
  public void loadContacts() {
    int size = this.person.getContactList().size();
    
    String[] list = new String[size];
    
    for (int i = 0; i < size; i++)
      list[i] = this.person.getContactList().get(i).toString();
    
    this.contactList.setListData(list);
  }
  
  /**
   * Loads all the mentions of a certain person.
   */
  @Override
  public void loadMentions() {
    int size = this.person.getMentionList().size();
    
    String[] list = new String[size];
    
    for (int i = 0; i < size; i++)
      list[i] = this.person.getMentionList().get(i).toString();
    
    this.mentionsList.setListData(list); 
  }
    
  /**
   * Loads all the academic information of a certain person.
   */
  @Override
  public void loadAcademic() {
    int size = this.person.getAcademicList().size();
    
    String[] list = new String[size];
    
    for (int i=0; i<size; i++)
      list[i] = this.person.getAcademicList().get(i).toString();
    
    this.academicList.setListData(list);
  }
    
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    inputName = new javax.swing.JTextField();
    inputAge = new javax.swing.JTextField();
    inputEmail = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    inputCountMentions = new javax.swing.JTextField();
    inputVisualizacoes = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    skillList = new javax.swing.JList<>();
    jLabel10 = new javax.swing.JLabel();
    submitSaveName = new javax.swing.JButton();
    submitSaveAge = new javax.swing.JButton();
    submitSaveEmail = new javax.swing.JButton();
    submitSaveVisualizations = new javax.swing.JButton();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    inputID = new javax.swing.JTextField();
    submitSkillEdit = new javax.swing.JButton();
    submitSkillCreate = new javax.swing.JButton();
    submitSkillDelete = new javax.swing.JButton();
    jScrollPane7 = new javax.swing.JScrollPane();
    academicList = new javax.swing.JList<>();
    jScrollPane8 = new javax.swing.JScrollPane();
    professionalList = new javax.swing.JList<>();
    submitProfessionalCreate = new javax.swing.JButton();
    submitProfessionalEdit = new javax.swing.JButton();
    submitProfessionalDelete = new javax.swing.JButton();
    submitAcademicCreate = new javax.swing.JButton();
    submitAcademicEdit = new javax.swing.JButton();
    submitAcademicDelete = new javax.swing.JButton();
    jScrollPane4 = new javax.swing.JScrollPane();
    mentionsList = new javax.swing.JList<>();
    jScrollPane5 = new javax.swing.JScrollPane();
    contactList = new javax.swing.JList<>();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Informações de Gestão");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("Nome");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel3.setText("Idade");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel4.setText("Email");

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel5.setText("nº Visualizações");

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setText("Informação Geral");

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel7.setText("nº Menções");

    inputCountMentions.setEditable(false);

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel8.setText("Formação Acadêmica");

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setText("Formação Profissional");

    skillList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    skillList.setToolTipText("");
    skillList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        skillListValueChanged(evt);
      }
    });
    jScrollPane3.setViewportView(skillList);

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setText("Skills");

    submitSaveName.setText("Salvar");
    submitSaveName.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSaveNameActionPerformed(evt);
      }
    });

    submitSaveAge.setText("Salvar");
    submitSaveAge.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSaveAgeActionPerformed(evt);
      }
    });

    submitSaveEmail.setText("Salvar");
    submitSaveEmail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSaveEmailActionPerformed(evt);
      }
    });

    submitSaveVisualizations.setText("Salvar");
    submitSaveVisualizations.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSaveVisualizationsActionPerformed(evt);
      }
    });

    jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel11.setText("Lista de Menções");

    jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel12.setText("Lista de Contatos");

    jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel13.setText("ID");

    inputID.setEditable(false);

    submitSkillEdit.setText("Edit");
    submitSkillEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSkillEditActionPerformed(evt);
      }
    });

    submitSkillCreate.setText("Create");
    submitSkillCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSkillCreateActionPerformed(evt);
      }
    });

    submitSkillDelete.setText("Delete");
    submitSkillDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSkillDeleteActionPerformed(evt);
      }
    });

    academicList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    academicList.setToolTipText("");
    academicList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        academicListValueChanged(evt);
      }
    });
    jScrollPane7.setViewportView(academicList);

    professionalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    professionalList.setToolTipText("");
    professionalList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        professionalListValueChanged(evt);
      }
    });
    jScrollPane8.setViewportView(professionalList);

    submitProfessionalCreate.setText("Create");
    submitProfessionalCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitProfessionalCreateActionPerformed(evt);
      }
    });

    submitProfessionalEdit.setText("Edit");
    submitProfessionalEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitProfessionalEditActionPerformed(evt);
      }
    });

    submitProfessionalDelete.setText("Delete");
    submitProfessionalDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitProfessionalDeleteActionPerformed(evt);
      }
    });

    submitAcademicCreate.setText("Create");
    submitAcademicCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitAcademicCreateActionPerformed(evt);
      }
    });

    submitAcademicEdit.setText("Edit");
    submitAcademicEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitAcademicEditActionPerformed(evt);
      }
    });

    submitAcademicDelete.setText("Delete");
    submitAcademicDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitAcademicDeleteActionPerformed(evt);
      }
    });

    mentionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    mentionsList.setToolTipText("");
    mentionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        mentionsListValueChanged(evt);
      }
    });
    jScrollPane4.setViewportView(mentionsList);

    contactList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    contactList.setToolTipText("");
    contactList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        contactListValueChanged(evt);
      }
    });
    jScrollPane5.setViewportView(contactList);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel6)
                  .addComponent(jLabel11)
                  .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                          .addComponent(jLabel13)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(268, 268, 268))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                          .addGap(42, 42, 42)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputName)
                            .addComponent(inputAge, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46)
                        .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(submitSaveName)
                      .addComponent(submitSaveEmail)
                      .addComponent(submitSaveAge))))
                .addGap(39, 39, 39))
              .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel12)
              .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                  .addComponent(jLabel7)
                  .addGap(76, 76, 76)
                  .addComponent(inputCountMentions, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                      .addGap(169, 169, 169)
                      .addComponent(inputVisualizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(submitSaveVisualizations))))))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel9)
              .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel8)
              .addGroup(layout.createSequentialGroup()
                .addComponent(submitAcademicCreate)
                .addGap(18, 18, 18)
                .addComponent(submitAcademicEdit)
                .addGap(18, 18, 18)
                .addComponent(submitAcademicDelete))))
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel10)
              .addGroup(layout.createSequentialGroup()
                .addComponent(submitProfessionalCreate)
                .addGap(18, 18, 18)
                .addComponent(submitProfessionalEdit)
                .addGap(18, 18, 18)
                .addComponent(submitProfessionalDelete))
              .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(submitSkillCreate)
                .addGap(18, 18, 18)
                .addComponent(submitSkillEdit)
                .addGap(18, 18, 18)
                .addComponent(submitSkillDelete)))))
        .addContainerGap(23, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(jLabel8))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel13)
              .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(submitSaveName))
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(inputAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(submitSaveAge))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(submitSaveEmail)))
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane7)))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(submitAcademicCreate)
              .addComponent(submitAcademicEdit)
              .addComponent(submitAcademicDelete))
            .addGap(18, 18, 18)
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(submitProfessionalCreate)
              .addComponent(submitProfessionalEdit)
              .addComponent(submitProfessionalDelete))
            .addGap(25, 25, 25)
            .addComponent(jLabel10))
          .addGroup(layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addComponent(jLabel11)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(66, 66, 66)
            .addComponent(jLabel12)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(submitSkillCreate)
              .addComponent(submitSkillEdit)
              .addComponent(submitSkillDelete)))
          .addGroup(layout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5)
              .addComponent(inputVisualizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(submitSaveVisualizations))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7)
              .addComponent(inputCountMentions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void submitSaveNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveNameActionPerformed
    try{
      if(!inputName.getText().isEmpty() && !inputName.getText().equals(this.person.getName())){
        this.person.setName(inputName.getText());
        
        this.message("Name was updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating name.");
    }
  }//GEN-LAST:event_submitSaveNameActionPerformed

  private void submitSaveAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveAgeActionPerformed
    try{
      if(!inputAge.getText().isEmpty() && !Integer.valueOf(inputAge.getText()).equals(this.person.getAge())){
        this.person.setAge(Integer.valueOf(inputAge.getText()));
        
        this.message("Age was updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating age.");
    }
  }//GEN-LAST:event_submitSaveAgeActionPerformed

  private void submitSaveEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveEmailActionPerformed
    try{
      if(!inputEmail.getText().isEmpty() && !inputEmail.getText().equals(this.person.getEmail())){
        this.person.setEmail(inputEmail.getText());
        
        //Update person index on peopleByEmail list
        this.store.getPeopleByEmail().remove(this.person);
        this.store.getPeopleByEmail().add(this.person);
        
        this.message("Email was updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating email.");
    }
  }//GEN-LAST:event_submitSaveEmailActionPerformed

  private void submitSaveVisualizationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveVisualizationsActionPerformed
    try{
      if(!inputVisualizacoes.getText().isEmpty() && !Integer.valueOf(inputVisualizacoes.getText()).equals(this.person.getVisualizations())){
        this.person.setVisualizations(Integer.valueOf(inputVisualizacoes.getText()));
        
        //Update edges on network
        Iterator list = this.store.getPeopleById().iterator();
        while(list.hasNext()){
          Person p = (Person) list.next();
          
          //Current Person is a contact of P
          //Update edge weight
          if(p.isContact(this.person))
            this.store.getNetwork().addEdge(p, this.person, Integer.valueOf(inputVisualizacoes.getText()));
        }
        
        this.message("Visualizations were updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating visualizations.");
    }
  }//GEN-LAST:event_submitSaveVisualizationsActionPerformed

    private void submitSkillCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSkillCreateActionPerformed
      SkillCreateEdit form = new SkillCreateEdit();
      form.setTitle("Create Skill");
      form.setData(this);
      form.pack();
      form.setVisible(true);
    }//GEN-LAST:event_submitSkillCreateActionPerformed

    private void submitSkillEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSkillEditActionPerformed
      if(skillList.getSelectedValue() != null){
        SkillCreateEdit form = new SkillCreateEdit();
        form.setTitle("Edit Skill");
        form.setData(this, skillList.getSelectedIndex());
        form.pack();
        form.setVisible(true);
      }
      else{
        this.message("Please select a skill first.");
      }
    }//GEN-LAST:event_submitSkillEditActionPerformed

    private void submitSkillDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSkillDeleteActionPerformed
      if(skillList.getSelectedValue() != null){
        int deleteIndex = skillList.getSelectedIndex();
        this.person.getSkillList().remove(deleteIndex);
        this.loadSkill();
        
        this.message("Skill was deleted.");
      }
      else{
        this.message("Please select a skill first.");
      }
    }//GEN-LAST:event_submitSkillDeleteActionPerformed

    private void skillListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_skillListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_skillListValueChanged

    private void academicListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_academicListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_academicListValueChanged

    private void professionalListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_professionalListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_professionalListValueChanged

    private void submitProfessionalCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProfessionalCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitProfessionalCreateActionPerformed

    private void submitProfessionalEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProfessionalEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitProfessionalEditActionPerformed

    private void submitProfessionalDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProfessionalDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitProfessionalDeleteActionPerformed

    private void submitAcademicCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAcademicCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitAcademicCreateActionPerformed

    private void submitAcademicEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAcademicEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitAcademicEditActionPerformed

    private void submitAcademicDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAcademicDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitAcademicDeleteActionPerformed

    private void mentionsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_mentionsListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mentionsListValueChanged

    private void contactListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_contactListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_contactListValueChanged

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
      java.util.logging.Logger.getLogger(PersonViewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PersonViewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PersonViewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PersonViewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PersonViewEdit().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JList<String> academicList;
  private javax.swing.JList<String> contactList;
  private javax.swing.JTextField inputAge;
  private javax.swing.JTextField inputCountMentions;
  private javax.swing.JTextField inputEmail;
  private javax.swing.JTextField inputID;
  private javax.swing.JTextField inputName;
  private javax.swing.JTextField inputVisualizacoes;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JScrollPane jScrollPane7;
  private javax.swing.JScrollPane jScrollPane8;
  private javax.swing.JList<String> mentionsList;
  private javax.swing.JList<String> professionalList;
  private javax.swing.JList<String> skillList;
  private javax.swing.JButton submitAcademicCreate;
  private javax.swing.JButton submitAcademicDelete;
  private javax.swing.JButton submitAcademicEdit;
  private javax.swing.JButton submitProfessionalCreate;
  private javax.swing.JButton submitProfessionalDelete;
  private javax.swing.JButton submitProfessionalEdit;
  private javax.swing.JButton submitSaveAge;
  private javax.swing.JButton submitSaveEmail;
  private javax.swing.JButton submitSaveName;
  private javax.swing.JButton submitSaveVisualizations;
  private javax.swing.JButton submitSkillCreate;
  private javax.swing.JButton submitSkillDelete;
  private javax.swing.JButton submitSkillEdit;
  // End of variables declaration//GEN-END:variables
}