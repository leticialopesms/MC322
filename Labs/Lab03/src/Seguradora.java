import java.util.ArrayList;

public class Seguradora {
    // Propriedades
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;


    // Construtor
    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaClientes = new ArrayList<Cliente>();
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)
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
        return listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }


    // - Funções da classe Seguradora

    public boolean cadastrarCliente(Cliente cliente) {
        /* Adiciona na ListaClientes o cliente dado como parâmetro.
        Se o cliente já for cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(Cliente cliente) {
        /* Remove de ListaClientes o cliente dado como parâmetro.
        Remove de listaSinistros todos os sinistros associados a este cliente.
        Se o cliente não for cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (listaClientes.contains(cliente)) {
            listaClientes.remove(cliente);
            for (Sinistro s : listaSinistros) {
                if (s.getCliente().equals(cliente)) {
                    listaSinistros.remove(s);
                }
            }
            return true;
        }
        return false;
    }

    public String listarClientes(String tipoCliente) {
        /* Recebe "PF" (Pessoa Física) ou "PJ" (Pessoa Jurídica).
        Lista apenas os clientes do tipo dado como parâmetro. */
        String lista = "------------------------------\n" +
                       "Clientes do tipo " + tipoCliente + ":\n" +
                       "------------------------------\n";
        if (tipoCliente.equals("PF")) {
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePF) {
                    lista += c.toString() + "----------\n";
                }
            }
        }
        else if (tipoCliente.equals("PJ")) {
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) {
                    lista += c.toString() + "----------\n";
                }
            }
        }
        else return "--- Tipo Inválido! ---";
        return lista;
    }

    public boolean gerarSinistro(Sinistro sinistro) {
        /* Adiciona um novo sinistro na listaSinistros.
        É garantido o id sempre será único. */
        listaSinistros.add(sinistro);
        return false;
    }

    public String visualizarSinistro(String cliente) {
        /* Retorna uma string com os sinistros, caso existam, associados ao cliente dado como parâmetro. */
        Boolean temSinistro = false;
        String sinistros_cliente = "------------------------------\n" +
                                   "Sinistros cadastrados para " + cliente + ":\n" +
                                   "------------------------------\n";
        for (Sinistro s : listaSinistros) {
            if (s.getCliente().getNome().equals(cliente)) {
                sinistros_cliente += s.toString() + "----------\n";
                temSinistro = true;
            }
        }
        if (!temSinistro) return "Não há sinistros cadastrados para: " + cliente + ".\n";
        return sinistros_cliente;
    }

    public String listarSinistros() {
    /* Retorna uma string com todos os sinistros da atual Seguradora. */
        if (listaSinistros.size() == 0) {
            return "Não há sinistros cadastrados na Seguradora " + this.nome + ".\n";
        }
        String lista = "------------------------------\n" +
                       "Sinistros da Seguradora " + this.nome + ":\n" +
                       "------------------------------\n";
        for (Sinistro s : listaSinistros) {
            lista += s.toString() + "----------\n";
        }
        return lista;
    }
}



// Pensar em validar CPF E CNPJ na função cadastrarCliente