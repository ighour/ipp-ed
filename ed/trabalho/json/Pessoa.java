package ed.trabalho.json;

/**
 * Class for receiving data from JSON input. Populated with gson.
 */
public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private String email;
    private FormacaoAcademica[] formacaoAcademica;
    private CargosProfissionais[] cargosProfissionais;
    private String[] skills;
    private Contact[] contacts;
    private Mencao[] mencoes;
    private int visualizacoes;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public FormacaoAcademica[] getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public CargosProfissionais[] getCargosProfissionais() {
        return cargosProfissionais;
    }

    public String[] getSkills() {
        return skills;
    }

    public int getVisualizacoes() {
        return visualizacoes;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public Mencao[] getMencoes() {
        return mencoes;
    }
}