import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
    // Atributos (Propriedades)
    private final String CPF;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private ArrayList<Sinistro> listaSinistros;


    // Construtor
    public Condutor(String cpf, String nome, String telefone, String endereco, 
                    String email, LocalDate dataNascimento) {
        this.CPF = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = new ArrayList<Sinistro>();
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }


    // - Funções da classe Condutor

    public boolean adicionarSinistro(Sinistro sinistro) {
        /* Adiciona um novo sinistro na lista de sinistros do contudor.
        É garantido o id sempre será único. */
        this.listaSinistros.add(sinistro);
        return true;

    }

    public String listarSinistros() {
        /* Retorna uma string com todos os sinistros do condutor. */
        if (listaSinistros.size() == 0)
            return "Ainda não há sinistros para " + this.nome + ".\n";
        String lista = "------------------------------\n" +
                       "Sinistros de " + this.nome + ":\n" +
                       "------------------------------\n";
        for (Sinistro s : listaSinistros)
            lista += s.toString() + "------------------------------\n";
        return lista;
    }

    public Sinistro buscarSinistro(int id) {
        /* Busca, na lista de sinistros do condutor, o sinistro cujo
        ID é igual ao id dado como parâmetro.
        Retorna o sinistro que atende ao critério.
        Caso contrário, retorna null. */
        for (Sinistro s : listaSinistros) {
            if (s.getID() == id)
                return s;
        }
        return null;
    }

    @Override
    public String toString() {
        return "CPF: " + this.CPF + "\n" +
               "Nome: " + this.nome + "\n" +
               "Telefone: " + this.telefone + "\n" +
               "Endereço: " + this.endereco + "\n" +
               "Email: " + this.email + "\n" +
               "Data de Nascimento: " + this.dataNascimento + "\n";
    }
}
