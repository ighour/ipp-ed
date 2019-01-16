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
public class CargosProfissionais {
  private int ano;

  public int getAno() {
    return ano;
  }

  public String getCargo() {
    return cargo;
  }

  public String getEmpresa() {
    return empresa;
  }
  private String cargo;
  private String empresa;
}
