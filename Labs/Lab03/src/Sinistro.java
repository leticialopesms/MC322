import java.util.Date;
import java.util.Random;

public class Sinistro {
    // Propriedades
    private int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;


    // Construtor
    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = setId();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)
    public int getId() {
        return id;
    }

    public int setId() {
        /* Gera números aleatórios de 6 dígitos.
        Intervalo =[100.000 , 999.999].
        Ainda é necessário resolver o problema de possíveis repetições.*/
        Random num = new Random();
        int id = num.nextInt(899999) + 100000;
        return id;
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

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
               "data: " + this.data + "\n" +
               "Endereço: " + this.endereco + "\n" +
               "- Seguradora -\n" + this.seguradora + "\n" +
               "- Veículo -\n" + this.veiculo + "\n" +
               "- Cliente -\n" + this.cliente + "\n";
    }
}



// Pensar em mudar o setID para relacionar o id com a data de criação do sinistro