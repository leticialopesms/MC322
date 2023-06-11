import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    // Atributos (Propriedades)
    private final String CPF;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;


    // Construtor
    public ClientePF(String nome, String telefone, String endereco, String email, 
                     String cpf, String genero, String educacao, LocalDate dataNascimento) {
        super(nome, telefone, endereco, email);
        this.CPF = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }


    // Métodos
    // - Getters (acessors) and Setters (mutators)

    public String getCPF() {
        return CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    

    // - Funções da Classe ClientePF
    
    public int calculaIdade() {
        /* Calcula a idade do ClientePF.
        Utiliza métodos da classe LocalDate. */
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();
        return idade;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        /* Adiciona na listaVeiculos o veiculo dado como parâmetro.
        Se o veiculo já for cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (!listaVeiculos.contains(veiculo)) {
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(Veiculo veiculo) {
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
        /* Retorna uma string com uma lista de veículos do cliente. */
        if (listaVeiculos.size() == 0)
            return "Não há veículos cadastrados para " + super.getNome() + ".\n";
        String lista = "------------------------------\n" +
                       "Veículos de " + super.getNome() + ":\n" +
                       "------------------------------\n";
        for (Veiculo v : listaVeiculos)
            lista += v.toString() + "------------------------------\n";
        return lista;
    }

    public Veiculo buscarVeiculo(String placa) {
        /* Busca em listaVeiculos o veículo que tem a placa dada como parâmetro.
        Retorna o veículo se ele estiver cadastrado na lista.
        Caso contrário, retorna null. */
        for (Veiculo v : listaVeiculos) 
            if (v.getPlaca().equals(placa))
                return v;
        return null;
    }

    @Override
    public String toString() {
        return super.toString() +
               "CPF: " + this.CPF + "\n" +
               "Gênero: " + this.genero + "\n" +
               "Educação: " + this.educacao + "\n" +
               "Data de Nascimento: " + this.dataNascimento + "\n";
    }
}
