import java.util.Date;

public class Sinistro {
    // Atributos (Propriedades)
    private static int registros = 100000;
    private final int ID;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;


    // Construtor
    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.ID = gerarID();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public int getID() {
        return ID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    // - Funções da classe Sinistro

    public int gerarID() {
        /* Gera um número a partir do atributo de classe 'registros'.
        Tem, pelo menos, 6 dígitos. */
        registros++;
        return registros;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + "\n" +
               "data: " + this.data + "\n" +
               "Endereço: " + this.endereco + "\n" +
               "- Seguradora -\n" + this.seguradora + "\n" +
               "- Veículo -\n" + this.veiculo + "\n" +
               "- Cliente -\n" + this.cliente + "\n";
    }
}