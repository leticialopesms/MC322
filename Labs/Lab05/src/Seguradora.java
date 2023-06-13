import java.util.ArrayList;

public class Seguradora {
    // Atributos (Propriedades)
    private final String CNPJ;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;


    // Construtor
    public Seguradora(String CNPJ, String nome, String telefone, String endereco, String email) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
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
    
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }


    // - Funções da classe Seguradora

    // -- Seguros

    public boolean gerarSeguro(Seguro seguro) {
        /* Adiciona na listaSeguros o suguro dado como parâmetro.
        É garantido o id sempre será único.
        Retorna True. */
        seguro.setValorMensal();
        listaSeguros.add(seguro);
        return true;
    }

    public boolean cancelarSeguro(Seguro seguro) {
        /* Remove de listaSeguros o seguro dado como parâmetro.
        Se o seguro não tiver sido gerado antes, retorna False.
        Caso contrário, retorna True. */
        return listaSeguros.remove(seguro);
    }

    public Seguro buscarSeguro(int id) {
        /* Busca, na lista de seguros da seguradora, o seguro cujo
        ID é igual ao id dado como parâmetro.
        Se encontrar, retorna o seguro que atende ao critério (o ID é único).
        Caso contrário, retorna null. */
        for (Seguro s : listaSeguros)
            if (s.getID() == id)
                return s;
        return null;
    }

    public void atualizarSeguros() {
        /* Recalcula o valor mensal de todos os seguros cadastrados na seguradora.
        Esta função deve ser chamada sempre ao:
            - Cadastrar/Remover Veiculo;
            - Cadastrar/Atualizar Frota;
            - Alterar a quantidade de funcionários de um ClientePJ.
        */
        for (Seguro s : listaSeguros)
            s.setValorMensal();
    }

    // -- Clientes

    public boolean cadastrarCliente(Cliente cliente) {
        /* Adiciona na listaClientes o cliente dado como parâmetro.
        Se o cliente já for cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(Cliente cliente) {
        /* Remove de listaClientes o cliente dado como parâmetro.
        Remove de listaSeguros todos os seguros associados a este cliente.
        Se o cliente não for cadastrado, retorna False.
        Caso contrário, retorna True. */
        if (listaClientes.contains(cliente)) {
            listaClientes.remove(cliente);
            for (Seguro s : listaSeguros)
                if (s instanceof SeguroPF && cliente instanceof ClientePF) {
                    if (((SeguroPF)s).getCliente().equals((ClientePF)cliente))
                        listaSeguros.remove(s);
                }
                else if (s instanceof SeguroPJ && cliente instanceof ClientePJ) {
                    if (((SeguroPJ)s).getCliente().equals((ClientePJ)cliente))
                        listaSeguros.remove(s);
                }
            return true;
        }
        return false;
    }

    public String listarClientes(String tipoCliente) {
        /* Recebe "PF" (Pessoa Física) ou "PJ" (Pessoa Jurídica).
        Retorna uma string contendo apenas os clientes do tipo dado como parâmetro. */
        String lista = "--------------------------------------------------\n" +
                       "Clientes do tipo " + tipoCliente + ":\n" +
                       "--------------------------------------------------\n";
        if (tipoCliente.equals("PF")) {
            for (Cliente c : listaClientes)
                if (c instanceof ClientePF)
                    lista += c.toString() + "------------------------------\n";
        }
        else if (tipoCliente.equals("PJ")) {
            for (Cliente c : listaClientes)
                if (c instanceof ClientePJ)
                    lista += c.toString() + "------------------------------\n";
        }
        else return "--- Tipo Inválido! ---";
        return lista;
    }

    public String listarTodosClientes() {
        /* Retorna uma string contendo todos os clientes da seguradora. */
        if (listaClientes.size() == 0)
            return "Ainda não há clientes cadastrados em " + this.nome + ".\n";
        String lista = "--------------------------------------------------\n" +
                       "Clientes de " + this.nome + ":\n";
        lista += listarClientes("PF") + "\n";
        lista += listarClientes("PJ") + "\n";
        return lista;
    }

    public Cliente buscarCliente(String identificacao) {
        /* Busca, na lista de clientes da seguradora, o cliente cujo
        CPF ou CNPJ é igual à identificação dada como parâmetro.
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

    // -- Listas

    public String listarSeguros() {
        /* Retorna uma string com todos os seguros cadastrados na Seguradora. */
        if (listaSeguros.size() == 0)
            return "Ainda não há seguros gerados para " + this.nome + ".\n";
        String lista = "--------------------------------------------------\n" +
                       "Lista de Seguros de " + getNome() + ":\n" +
                       "--------------------------------------------------\n";
        for (Seguro s : listaSeguros)
            lista += s.toString() + "------------------------------\n";
        return lista;
    }

    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
        /* Retorna uma lista dos seguros de um dado cliente. */
        ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();
        for (Seguro s : listaSeguros) {
            if (s instanceof SeguroPF && cliente instanceof ClientePF) {
                if (((SeguroPF)s).getCliente().equals((ClientePF)cliente))
                    segurosCliente.add(s);
            }
            else if (s instanceof SeguroPJ && cliente instanceof ClientePJ) {
                if (((SeguroPJ)s).getCliente().equals((ClientePJ)cliente))
                    segurosCliente.add(s);
            }
        }
        return segurosCliente;
    }

    public String listarSegurosPorCliente(Cliente cliente) {
        /* Retorna uma string com todos os seguros associados ao cliente dado como parâmetro. */
        ArrayList<Seguro> segurosCliente = getSegurosPorCliente(cliente);
        if (segurosCliente.size() == 0)
            return "Ainda não há seguros gerados para " + cliente.getNome() + ".\n";
        String lista = "--------------------------------------------------\n" +
                       "Seguros de " + cliente.getNome() + ":\n" +
                       "--------------------------------------------------\n";
        for (Seguro s : segurosCliente)
            lista += s.toString() + "------------------------------\n";
        return lista;
    }

    public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
        /* Retorna uma lista dos sinistros de um dado cliente. */
        ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
        for (Seguro seguro : listaSeguros) {
            if (seguro instanceof SeguroPF && cliente instanceof ClientePF) {
                if (((SeguroPF)seguro).getCliente().equals((ClientePF)cliente))
                    for (Sinistro sinistro : seguro.getListaSinistros())
                        sinistrosCliente.add(sinistro);
            }
            else if (seguro instanceof SeguroPJ && cliente instanceof ClientePJ) {
                if (((SeguroPJ)seguro).getCliente().equals((ClientePJ)cliente))
                    for (Sinistro sinistro : seguro.getListaSinistros())
                        sinistrosCliente.add(sinistro);
            }
        }
        return sinistrosCliente;
    }

    public String listarSinistrosPorCliente(Cliente cliente) {
        /* Retorna uma string com todos os sinistros associados ao cliente dado como parâmetro. */
        ArrayList<Sinistro> sinistrosCliente = getSinistrosPorCliente(cliente);
        if (sinistrosCliente.size() == 0)
            return "Ainda não há sinistros gerados para " + cliente.getNome() + ".\n";
        String lista = "--------------------------------------------------\n" +
                       "Sinistros de " + cliente.getNome() + ":\n" +
                       "--------------------------------------------------\n";
        for (Sinistro s : sinistrosCliente)
            lista += s.toString() + "------------------------------\n";
        return lista;
    }

    public double calcularReceita() {
        /* Calcula o balanço de seguros de todos os clientes.
        Itera sobre os valores mensais de cada seguro da Seguradora
        e retona a soma de todos. */
        double receita = 0;
        for (Seguro s : listaSeguros) {
            receita += s.getValorMensal();
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
