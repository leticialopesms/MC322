import java.util.ArrayList;

public class Frota {
    // Atributos (Propriedades)
    private final String code;
    private ArrayList<Veiculo> listaVeiculos;
    
    
    // Construtor
    public Frota(String code) {
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }
    

    // Métodos
    // - Getters (acessors) e Setters (mutators)
    
    public String getCode() {
        return code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }


    // - Funções da classe Frota

    public boolean adicionarVeiculoFrota(Veiculo veiculo) {
        /* Adiciona na listaVeiculos o veiculo dado como parâmetro.
        Se o veiculo já for cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (!listaVeiculos.contains(veiculo)) {
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean removerVeiculoFrota(Veiculo veiculo) {
        /* Remove de listaVeiculos o veiculo dado como parâmetro.
        Se o veiculo não estiver cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (listaVeiculos.contains(veiculo)) {
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    public String listarVeiculos() {
        /* Retorna uma string com uma lista de veículos da frota. */
        if (listaVeiculos.size() == 0)
            return "A frota de código " + this.code + " não tem veículos cadastrados.\n";
        String lista = "------------------------------\n" +
                       "Veículos da Frota " + this.code + ":\n" +
                       "------------------------------\n";
        for (Veiculo v : listaVeiculos)
            lista += v.toString() + "------------------------------\n";
        return lista;
    }

    public Veiculo buscarVeiculo(String placa) {
        /* Busca, na lista de veículos, o veículo que tem a placa
        dada como parâmetro.
        Retorna o veículo se ele estiver cadastrado na lista.
        Caso contrário, retorna null. */
        for (Veiculo v : listaVeiculos) 
            if (v.getPlaca().equals(placa))
                return v;
        return null;
    }

    @Override
    public String toString() {
        return "Code: " + this.code + "\n" +
               "Quantidade de veículos na frota: " + this.listaVeiculos.size() + "\n" +
               listarVeiculos() + "\n";
    }
}
