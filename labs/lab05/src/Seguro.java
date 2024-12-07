import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
    // Atributos (propriedades)
    private static int registros = 100_000;
    private final int ID;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;     // Contém os sinistros gerados pelos condutores
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;
    /* O valorMensal deve ser recalculado ao:
        - Gerar Seguro                              OK
        - Atualizar/Desautorizar condutor           OK
        - Cadastrar/Remover Veiculo                 OK
        - Cadastrar/Atualizar Frota                 OK
        - Gerar sinistro (para Cliente e Condutor)  OK
        - Alterar a quantidade de funcionários de um ClientePJ
    */


    // Construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        this.ID = gerarID();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        // setValorMensal();
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public int getID(){
        return ID;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public double getValorMensal() {
        return valorMensal;
    }
    public void setValorMensal() {
        this.valorMensal = calculaValor();
    }


    // - Funções da classe Seguro

    public int gerarID() {
        /* Gera um número a partir do atributo de classe 'registros'.
        O id gerado tem, pelo menos, 6 dígitos. */
        registros++;
        return registros;
    }

    // -- Condutor

    public boolean autorizarCondutor(Condutor condutor) {
        /* Adiciona, na lista de condutores do seguro, o condutor dado como parâmetro.
        Se o condutor já estiver autorizado, retorna False.
        Caso contrário, retorna True. */
        if (!listaCondutores.contains(condutor)) {
            listaCondutores.add(condutor);
            setValorMensal();
            return true;
        }
        return false;
    }

    public boolean desautorizarCondutor(Condutor condutor) {
        /* Remove da lista de condutores do seguro o condutor dado como parâmetro.
        Também remove da lista de sinistros todos os sinistros associados a ele.
        Se o condutor não estiver autorizado, retorna False.
        Caso contrário, retorna True. */
        if (listaCondutores.contains(condutor)) {
            listaCondutores.remove(condutor);
            for (Sinistro s : listaSinistros)
                if (s.getCondutor().equals(condutor))
                    listaSinistros.remove(s);
            setValorMensal();
            return true;
        }
        return false;
    }

    public String listarCondutores() {
        /* Retorna uma string com todos os condutores do seguro. */
        if (listaCondutores.size() == 0)
            return "Ainda não há condutores autorizados para o seguro " + getID() + ".\n";
        String lista = "--------------------------------------------------\n" +
                       "Condutores do Seguro " + getID() + ":\n" +
                       "--------------------------------------------------\n";
        for (Condutor c : listaCondutores)
            lista += c.toString() + "------------------------------\n";
        return lista;
    }

    public Condutor buscarCondutor(String identificacao) {
        /* Busca, na lista de condutores do seguro, o condutor cujo
        CPF é igual à identificação dada como parâmetro.
        Retorna o condutor que atende ao critério.
        Caso contrário, retorna null. */
        identificacao = identificacao.replaceAll("[^0-9]", "");
        for (Condutor c : listaCondutores) {
            String cpf = c.getCPF().replaceAll("[^0-9]", "");
            if (cpf.equals(identificacao))
                return c;
        }
        return null;
    }

    // -- Sinistro

    public boolean gerarSinistro(Sinistro sinistro) {
        /* Adiciona um novo sinistro na lista de sinistros do seguro.
        É garantido o id sempre será único.
        Também adiciona o sinistro na lista de sinistros do condutor associado a ele.
        Retorna True. */
        sinistro.getCondutor().adicionarSinistro(sinistro);
        setValorMensal();
        return this.listaSinistros.add(sinistro);
    }

    public boolean excluirSinistro(Sinistro sinistro) {
        /* Remove um sinistro da lista de sinistros do seguro.
        Também remove o sinistro da lista de sinistros do condutor associado a ele.
        Se o sinistro estiver na lista, retorna True.
        Caso contrário, retorna False. */
        if (listaSinistros.contains(sinistro)) {
            sinistro.getCondutor().removerSinistro(sinistro);
            setValorMensal();
        }
        return this.listaSinistros.remove(sinistro);
    }

    public String listarSinistros() {
        /* Retorna uma string com todos os sinistros do seguro. */
        if (listaSinistros.size() == 0)
            return "Ainda não há sinistros para o seguro " + getID() + ".\n";
        String lista = "--------------------------------------------------\n" +
                       "Sinistros do Seguro " + getID() + ":\n" +
                       "--------------------------------------------------\n";
        for (Sinistro s : listaSinistros)
            lista += s.toString() + "------------------------------\n";
        return lista;
    }

    public Sinistro buscarSinistro(int id) {
        /* Busca, na lista de sinistros do seguro, o sinistro cujo
        ID é igual ao id dado como parâmetro.
        Retorna o sinistro que atende ao critério.
        Caso contrário, retorna null. */
        for (Sinistro s : listaSinistros) {
            if (s.getID() == id)
                return s;
        }
        return null;
    }

    // -- Cálculo do valor mensal

    public abstract double calculaValor();
    /* Operação abstrata.
    As subclasses implementarão o comportamento dessa operação. */

    @Override
    public String toString() {
        return "ID: " + this.ID + "\n" +
               "Data de Incío: " + this.dataInicio + "\n" +
               "Data de Término: " + this.dataFim + "\n" +
               "Valor Mensal: " + getValorMensal() + "\n" + "\n" +
               "- Seguradora -\n" + this.seguradora + "\n";
    }
}
