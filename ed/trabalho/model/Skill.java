/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.model;

/**
 * Skill model.
 * Represent a skill of a Person.
 * @author igu
 */
public class Skill {
  /**
   * Skill name.
   */
  private final String skill;

  /**
   * Instantiate with parameters.
   * @param skill 
   */
  public Skill(String skill) {
    this.skill = skill;
  }

  /**
   * Get skill name.
   * @return 
   */
  public String getSkill() {
    return skill;
  }
}
