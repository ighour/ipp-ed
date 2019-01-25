package ed.trabalho.json;

/**
 * Class for receiving data from JSON input. Populated with gson.
 */
public class CargosProfissionais {

    private int ano;
    private String cargo;
    private String empresa;

    public int getAno() {
        return ano;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmpresa() {
        return empresa;
    }
}