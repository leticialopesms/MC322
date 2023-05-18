import java.util.ArrayList;

public abstract class Cliente {
    // Atributos (Propriedades)
    private String nome;
    private String endereco;
    private double valorSeguro;
    private ArrayList<Veiculo> listaVeiculos;


    // Construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<Veiculo>();
        // O atributo valorSeguro é 
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

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
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
        /* Remove em listaVeiculos o veículo dado como parâmetro.
        Se o veículo não estiver cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (listaVeiculos.contains(veiculo)) {
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    public Veiculo buscarVeiculo(String placa) {
        /* Busca em listaVeiculos o veículo dado como parâmetro.
        Retorna o veículo se ele estiver cadastrado na lista.
        Caso contrário, retorna null. */
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

    public abstract double calculaScore();
    /* Operação abstrata.
    As subclasses implementarão o comportamento dessa operação. */

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
               "Endereço: " + this.endereco + "\n";
               // Adicionar em toString() o valor do seguro?
    }
}
