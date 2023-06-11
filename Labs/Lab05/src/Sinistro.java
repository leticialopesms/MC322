import java.time.LocalDate;

public class Sinistro {
    // Atributos (Propriedades)
    private static int registros = 1_000_000;
    private final int ID;
    private LocalDate data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;


    // Construtor
    public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
        this.ID = gerarID();
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public int getID() {
        return ID;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }


    // - Funções da classe Sinistro

    public int gerarID() {
        /* Gera um número a partir do atributo de classe 'registros'.
        o id gerado tem, pelo menos, 7 dígitos. */
        registros++;
        return registros;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + "\n" +
               "Data: " + this.data + "\n" +
               "Endereço: " + this.endereco + "\n" + "\n" +
               "- Condutor -\n" + this.condutor + "\n" +
               "- Seguro -\n" + this.seguro + "\n";
    }
}
