package ed.trabalho.json;

/**
 * Class for receiving data from JSON input. Populated with gson.
 */
public class GrafoSocial {

    private Pessoa[] grafoSocial;

    /**
     * Returns the converted JSON data as GrafoSocial instance.
     *
     * @return array of Pessoa with brute info
     */
    public Pessoa[] getResult() {
        return this.grafoSocial;
    }
}
