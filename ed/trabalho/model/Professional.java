/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.model;

/**
 * Professional model.
 * Represent a professional information of a Person.
 * @author igu
 */
public class Professional {
  /**
   * Year of professional activity.
   */
  private int year;
  
  /**
   * Company name.
   */
  private String company;
  
  /**
   * Role name at company.
   */
  private String role;

  /**
   * Instantiate with parameters.
   * @param year
   * @param company
   * @param role 
   */
  public Professional(int year, String company, String role) {
    this.year = year;
    this.company = company;
    this.role = role;
  }

  /**
   * Get year of professional activity.
   * @return 
   */
  public int getYear() {
    return year;
  }

  /**
   * Get company name.
   * @return 
   */
  public String getCompany() {
    return company;
  }

  /**
   * Get role name at company.
   * @return 
   */
  public String getRole() {
    return role;
  }

  /**
   * Set year.
   * @param year 
   */
  public void setYear(int year) {
    this.year = year;
  }

  /**
   * Set company.
   * @param company 
   */
  public void setCompany(String company) {
    this.company = company;
  }

  /**
   * Set role.
   * @param role 
   */
  public void setRole(String role) {
    this.role = role;
  }
    
  /**
   * Return a string representation of a Professional work
   * @return a string representation of a Professional work
   */
  @Override
  public String toString() {
      return this.company + " / " + this.role + " / "+ this.year;
  }

}
