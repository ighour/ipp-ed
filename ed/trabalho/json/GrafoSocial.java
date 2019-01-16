/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.json;

/**
 * Class for receiving data from JSON input.
 * Populated with gson.
 * @author igu
 */
public class GrafoSocial {
  private Pessoa[] grafoSocial;
  
  /**
   * Returns the converted JSON data as GrafoSocial instance.
   * @return 
   */
  public Pessoa[] getResult(){
    return this.grafoSocial;
  }
}
