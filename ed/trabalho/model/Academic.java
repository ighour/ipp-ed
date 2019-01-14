/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.model;

/**
 *
 * @author igu
 */
public class Academic {
  private int year;
  private String description;

  public Academic(int year, String description) {
    this.year = year;
    this.description = description;
  }
  
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
