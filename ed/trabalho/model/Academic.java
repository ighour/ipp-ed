/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.model;

/**
 * Academic model.
 * Represent a academic information of a Person.
 * @author igu
 */
public class Academic {
  /**
   * Year of academic activity.
   */
  private final int year;
  
  /**
   * Description of activity.
   */
  private final String description;

  /**
   * Instantiate with parameters.
   * @param year
   * @param description 
   */
  public Academic(int year, String description) {
    this.year = year;
    this.description = description;
  }
  
  /**
   * Get year of academic activity.
   * @return 
   */
  public int getYear() {
    return year;
  }

  /**
   * Get description of academic activity.
   * @return 
   */
  public String getDescription() {
    return description;
  }
}
