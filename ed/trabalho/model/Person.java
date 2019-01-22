/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.model;

import estg.ed.array.DynamicArray;
import estg.ed.interfaces.DynamicArrayContract;

/**
 * Person model.
 * @author igu
 */
public class Person implements Comparable<Person> {
  /**
   * Unique id.
   */
  private final int id;
  
  /**
   * Name.
   */
  private String name;
  
  /**
   * Age.
   */
  private int age;
  
  /**
   * Email.
   */
  private String email;
  
  /**
   * Count of person visualizations.
   */
  private int visualizations;
  
  /**
   * List of academic information.
   */
  private final DynamicArrayContract<Academic> academicList;
  
  /**
   * List of professional information.
   */
  private final DynamicArrayContract<Professional> professionalList;
  
  /**
   * List of skills.
   */
  private final DynamicArrayContract<Skill> skillList;
  
  /**
   * List of contacts (list of other people).
   */
  private final DynamicArrayContract<Person> contactList;
  
  /**
   * List of mentions (list of other people).
   */
  private final DynamicArrayContract<Person> mentionList;
  
  /**
   * Instantiate a person with own attributes.
   * Only attributes referring to other people are excluded.
   * @param id
   * @param name
   * @param age
   * @param email
   * @param visualizations 
   */
  public Person(int id, String name, int age, String email, int visualizations) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
    this.visualizations = visualizations;
    this.academicList = new DynamicArray<>();
    this.professionalList = new DynamicArray<>();
    this.skillList = new DynamicArray<>();
    this.contactList = new DynamicArray<>();
    this.mentionList = new DynamicArray<>();
  }

  /**
   * Get Id.
   * @return 
   */
  public int getId() {
    return id;
  }
  
  /**
   * Get name.
   * @return 
   */
  public String getName() {
    return name;
  }

  /**
   * Get age.
   * @return 
   */
  public int getAge() {
    return age;
  }

  /**
   * Get email.
   * @return 
   */
  public String getEmail() {
    return email;
  }
  
  /**
   * Get count of visualizations.
   * @return 
   */
  public int getVisualizations() {
    return visualizations;
  }
  
  /**
   * Get list of academic information.
   * @return 
   */
  public DynamicArrayContract<Academic> getAcademicList() {
    return academicList;
  }

  /**
   * Get list of professional information.
   * @return 
   */
  public DynamicArrayContract<Professional> getProfessionalList() {
    return professionalList;
  }

  /**
   * Get list of skills.
   * @return 
   */
  public DynamicArrayContract<Skill> getSkillList() {
    return skillList;
  }

  /**
   * Get list of contacts (list of other people).
   * 
   * @return 
   */
  public DynamicArrayContract<Person> getContactList() {
    return contactList;
  }

  /**
   * Get list of mentions (list of other people).
   * @return 
   */
  public DynamicArrayContract<Person> getMentionList() {
    return mentionList;
  }

  /**
   * Set a new name.
   * @param name 
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set a new age.
   * @param age 
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Set a new email.
   * @param email 
   */
  public void setEmail(String email) {
    this.email = email;
  }
  
  /**
   * Set a new visualization count. 
   * @param visualizations
   */
  public void setVisualizations(int visualizations) {
    this.visualizations = visualizations;
  }

  /**
   * Get count of mentions.
   * @return 
   */  
  public int getMentions(){
    return this.mentionList.size();
  }
  
  /**
   * Check if desired Person is in contact list.
   * @param person
   * @return 
   */
  public boolean isContact(Person person) {
    int size = this.contactList.size();
    
    for(int i = 0; i < size; i++){
      Person contact = this.contactList.get(i);
      
      if(contact.getId() == person.getId())
        return true;
    }
    
    return false;
  }
  
  /**
   * Check if desired Person is in mention list.
   * @param person
   * @return 
   */
  public boolean isMention(Person person) {
    int size = this.mentionList.size();
    
    for(int i = 0; i < size; i++){
      Person mention = this.mentionList.get(i);
      
      if(mention.getId() == person.getId())
        return true;
    }
    
    return false;
  }
  
  /**
   * Check if desired Skill is in skills list.
   * @param targetSkill
   * @return 
   */
  public boolean hasSkill(String targetSkill) {
    int size = this.skillList.size();
    
    for(int i = 0; i < size; i++){
      Skill skill = this.skillList.get(i);
      
      if(skill.getSkill().equals(targetSkill))
        return true;
    }
    
    return false;
  }
  
  /**
   * Check if user has worked in desired company.
   * @param targetCompany
   * @return 
   */
  public boolean hasWorked(String targetCompany) {
    int size = this.professionalList.size();
    
    for(int i = 0; i < size; i++){
      Professional prof = this.professionalList.get(i);
      
      if(prof.getCompany().equals(targetCompany))
        return true;
    }
    
    return false;
  }
  
  /**
   * Check if user has worked in desired company.
   * @param targetCompany
   * @param targetRole
   * @return 
   */
  public boolean hasWorked(String targetCompany, String targetRole) {
    int size = this.professionalList.size();
    
    for(int i = 0; i < size; i++){
      Professional prof = this.professionalList.get(i);
      
      if(prof.getCompany().equals(targetCompany) && prof.getRole().equals(targetRole))
        return true;
    }
    
    return false;
  }

  /**
   * Compare to other Person.
   * Using id.
   * @param o
   * @return 
   */
  @Override
  public int compareTo(Person o) {
    if(this.id > o.id)
      return 1;
    else if(this.id < o.id)
      return -1;
    else
      return 0;
  }
  
  /**
   * Returns a string representation of a Person.
   * @return a string representation of a Person
   */
  @Override
  public String toString(){
    return "(" + this.id + ") " + this.name + " - " + this.email;
  }
}
