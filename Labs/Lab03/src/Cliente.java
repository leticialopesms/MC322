import java.util.ArrayList;

public class Cliente {
    // Propriedades
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;


    // Construtor
    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
    }


    // Getters (acessors) e Setters (mutators)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }


    // Funções da Classe

    // Fazer função para validar CNPJ
    
    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
               "Endereço: " + this.endereco + "\n" +
               "Lista de Veículos: " + getListaVeiculos() + "\n";
    }

}
