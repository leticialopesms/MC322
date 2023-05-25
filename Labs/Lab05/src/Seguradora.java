import java.util.ArrayList;

public class Seguradora {
    // Atributos (Propriedades)
    private final String CNPJ;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;


    // Construtor
    public Seguradora(String CNPJ, String nome, String telefone, String email, String endereco) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSeguros = new ArrayList<Seguro>();
        this.listaClientes = new ArrayList<Cliente>();
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public String getCNPJ() {
        return CNPJ;
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

    public ArrayList<Seguro> getlistaSeguros() {
        return listaSeguros;
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
            calcularPrecoSeguroCliente(cliente);
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(Cliente cliente) {
        /* Remove de ListaClientes o cliente dado como parâmetro.
        Remove de listaSeguros todos os sinistros associados a este cliente.
        Se o cliente não for cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (listaClientes.contains(cliente)) {
            listaClientes.remove(cliente);
            // for (Sinistro s : listaSeguros)
            //     if (s.getCliente().equals(cliente))
            //         listaSeguros.remove(s);
            // return true;
            // ******************************VERIFICAR******************************
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
            for (Cliente c : listaClientes)
                if (c instanceof ClientePF)
                    lista += c.toString() + "------------------------------\n";
        }
        else if (tipoCliente.equals("PJ")) {
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ)
                    lista += c.toString() + "------------------------------\n";
            }
        }
        else return "--- Tipo Inválido! ---";
        return lista;
    }

    public Cliente buscarCliente(String identificacao) {
        /* Busca, na lista de clientes da seguradora, o cliente cujo CPF ou CNPJ 
        é igual à identificação dada como parâmetro.
        Retorna o cliente que atende ao critério.
        Caso contrário, retorna null. */
        identificacao = identificacao.replaceAll("[^0-9]", "");
        for (Cliente c : listaClientes) {
            if (c instanceof ClientePF) {
                String cpf = ((ClientePF)c).getCPF().replaceAll("[^0-9]", "");
                if (cpf.equals(identificacao))
                    return c;
            }
            else if (c instanceof ClientePJ) {
                String cnpj = ((ClientePJ)c).getCNPJ().replaceAll("[^0-9]", "");
                if (cnpj.equals(identificacao))
                    return c;
            }
        }
        return null;
    }

    public Boolean transferirSeguro(Cliente doador, Cliente recebedor) {
        /* Transfere o seguro de um cliente para o outro. */
        Boolean clienteRemovido = removerCliente(doador);
        if (!clienteRemovido)
            return false;
        for (Veiculo v : doador.getListaVeiculos()) {
            recebedor.inserirVeiculo(v);
        }
        cadastrarCliente(recebedor);
        return true;
    }


    public boolean removerSinistro(Sinistro sinistro){
        /* Remove um sinistro da listaSeguros.
        Se o sinistro estiver na lista, remove-o e retorna True.
        Caso contrário, retorna False. */
        if (listaSeguros.contains(sinistro)) {
            listaSeguros.remove(sinistro);
            return true;
        }
        return false;
    }

    public void calcularPrecoSeguroCliente(Cliente cliente) {
        /* Calcula o preço do seguro do cliente dado como parâmetro.
        Atualiza o atributo valorSeguro do cliente.
        Retorna o valor cobrado pela seguradora.
        Chamar essa função:
        * A cada cadastro de cliente;
        * A cada alteração da dataNascimento do clientePF;
        * A cada alteração da qtdeFuncionarios do clientePJ;
        * A cada cadastro/remoção de veículo;
        * A cada geração/exclusao de sinistro. */
        // ******************************VERIFICAR******************************
        
    }

    public double calcularReceita() {
        /* Calcula o balanço de seguros de todos os clientes.
        Itera sobre os valores de seguro de cada cliente da
        Seguradora e retona a soma de todos. */
        double receita = 0;
        for (Cliente c : listaClientes) {
            receita += c.getValorSeguro();
        }
        return receita;

    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
               "Telefone: " + this.telefone + "\n" +
               "Email: " + this.email + "\n" +
               "Endereço: " + this.endereco + "\n";
    }
}