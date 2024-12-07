import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    // Atributos (Propriedades)
    private final String CNPJ;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;
    private ArrayList<Frota> listaFrotas;
    
    
    // Construtor
    public ClientePJ(String nome, String telefone, String endereco, String email,
    String cnpj, LocalDate dataFundacao, int qtdeFuncionarios) {
        super(nome, telefone, endereco, email);
        this.CNPJ = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
        this.listaFrotas = new ArrayList<Frota>();
    }
    
    
    // Métodos
    // - Getters (acessors) e Setters (mutators)
    
    public String getCNPJ() {
        return CNPJ;
    }
    
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    
    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }
    
    
    // - Funções da classe ClientePJ
    
    public int calculaAnosPosFundacao() {
        /* Calcula o tempo, em anos, entre a data atual e a data de Fundação do ClientePJ.
        Utiliza métodos da classe LocalDate. */
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataFundacao, dataAtual);
        int anosPosFundacao = periodo.getYears();
        return anosPosFundacao;
    }

    public boolean cadastrarFrota(Frota frota) {
        if (!listaFrotas.contains(frota)) {
            listaFrotas.add(frota);
            return true;
        }
        return false;
    }

    public boolean atualizarFrota(int operacao, Frota frota, Veiculo veiculo) {
        /* Recebe uma operação, uma frota a ser atualizada e um veículo.
        Pode realizar 2 operações:
            [1] Adicionar veículo na frota
            [2] Remover veiculo da frota
        Retorna True se as operações forem realizadas com sucesso.
        Caso contrário, retorna False.*/
        if (operacao == 1) {
            return frota.adicionarVeiculoFrota(veiculo);
        }
        else if (operacao == 2) {
            return frota.removerVeiculoFrota(veiculo);
        }
        return false; // Caso a operação não seja válida
    }

    public boolean excluirFrota(Frota frota) {
        /* Recebe uma frota a ser removida da lista de frotas do clientePJ atual.
        Retorna True se a frota for excluída com sucesso.
        Caso contrário, retorna False.*/
        return listaFrotas.remove(frota);
    }

    public Frota buscarFrota(String code) {
        /* Busca, na lista de frotas, a frota cujo código (code) é igual
        ao código dado como parâmetro.
        Retorna a frota que atende ao critério (code é único).
        Caso contrário, retorna null. */
        for (Frota f : listaFrotas) {
            if (f.getCode().equals(code))
                return f;
        }
        return null;
    }

    public String listarFrotas() {
        /* Retorna uma string com todos as frotas do ClientePJ. */
        if (listaFrotas.size() == 0)
            return "Ainda não há frotas cadastradas para " + super.getNome() + ".\n";
        String lista = "--------------------------------------------------\n" +
                       "Frotas de " + super.getNome() + ":\n" +
                       "--------------------------------------------------\n";
        for (Frota f : listaFrotas)
            lista += f.toString() + "------------------------------\n";
        return lista;
    }

    public ArrayList<Veiculo> getVeiculosPorFrota(Frota frota) {
        /* Retorna uma lista dos veiculos da frota dada como parâmetro. */
        return frota.getListaVeiculos();
    }

    @Override
    public String toString() {
        return super.toString() +
               "CNPJ: " + this.CNPJ + "\n" +
               "Data de Fundação: " + this.dataFundacao + "\n";
    }
}
