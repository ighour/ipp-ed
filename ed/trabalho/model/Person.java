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
  private final String name;
  
  /**
   * Age.
   */
  private final int age;
  
  /**
   * Email.
   */
  private final String email;
  
  /**
   * Count of person visualizations.
   */
  private final int visualizations;
  
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
   * Get count of mentions.
   * @return 
   */  
  public int getMentions(){
    return this.mentionList.size();
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
    return this.name + " (ID " + this.id + ")";
  }
}
