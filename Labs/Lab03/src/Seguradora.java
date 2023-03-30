import java.util.ArrayList;

public class Seguradora {
    // Propriedades
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> ListaSinistros;
    private ArrayList<Cliente> ListaClientes;

    // Construtor
    public Seguradora(String nome, String telefone, String email, String endereco,
                      ArrayList<Sinistro> ArrayListaSinistros, ArrayList<Cliente> ArrayListaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.ListaSinistros = ArrayListaSinistros;
        this.ListaClientes = ArrayListaClientes;
    }

    // Métodos
    // Getters (acessors) e Setters (mutators)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return ListaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> ArrayListaSinistros) {
        this.ListaSinistros = ArrayListaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return ListaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> ArrayListaClientes) {
        this.ListaClientes = ArrayListaClientes;
    }

    // Funções da Seguradora
    public boolean cadastrarCliente(Cliente cliente) {
        // Terminar
        return false;
    }

    public boolean removerCliente(String cliente) {
        // Terminar
        return false;
    }

    public ArrayList<Cliente> ArrayListarClientes(String tipoCliente) {
        // Verificar
        return ListaClientes;
    }

    public boolean gerarSinistro() {
        //Terminar
        return false;
    }

    public boolean visualizarSinistro(String cliente) {
        // Terminar
        return false;
    }

    public ArrayList<Sinistro> ArrayListarSinistros() {
        // Verificar
        return ListaSinistros;
    } 
}
