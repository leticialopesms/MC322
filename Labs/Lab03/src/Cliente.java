import java.util.ArrayList;

public class Cliente {
    // Propriedades
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;


    // Construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)
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

    public ArrayList<Veiculo> getListaVeiculos(){
        return this.listaVeiculos;
    }


    // - Funções da classe Cliente
    
    public Boolean inserirVeiculo(Veiculo veiculo) {
        /* Insere em listaVeiculos o veículo dado como parâmetro.
        Se o veículo já estiver cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (listaVeiculos.contains(veiculo))
            return false;
        listaVeiculos.add(veiculo);
        return true;
    }
    
    public Boolean removerVeiculo(Veiculo veiculo) {
        /* Insere em listaVeiculos o veículo dado como parâmetro.
        Se o veículo já estiver cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (listaVeiculos.contains(veiculo))
            return false;
        listaVeiculos.add(veiculo);
        return true;
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo v : listaVeiculos) 
            if (v.getPlaca().equals(placa))
                return v;
        return null;
    }

    public String listarVeiculos() {
        /* Retorna uma string com uma lista de veículos do cliente. */
        if (listaVeiculos.size() == 0)
            return "Não há veículos cadastrados para " + this.nome + ".\n";
        String lista = "------------------------------\n" +
                       "Veículos de " + this.nome + ":\n" +
                       "------------------------------\n";
        for (Veiculo v : listaVeiculos)
            lista += v.toString() + "------------------------------\n";
        return lista;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
               "Endereço: " + this.endereco + "\n";
    }
}