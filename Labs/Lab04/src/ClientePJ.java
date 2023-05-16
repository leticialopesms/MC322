import java.util.Date;

public class ClientePJ extends Cliente{
    // Atributos (Propriedades)
    private final String CNPJ;
    private Date dataFundacao;
    private int qtdeFuncionarios;


    // Construtor
    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }


    // Métodos

    // - Getters (acessors) e Setters (mutators)

    public String getCNPJ() {
        return CNPJ;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }


    // - Funções da classe ClientePJ

    public double calculaScore() {
        /* Calcula o valor do seguro.
        Utiliza o conceito de sobrecarga de métodos,
        a partir a superclasse Cliente. */
        double valor = CalcSeguro.VALOR_BASE.getValor();
        int qtdeVeiculos = this.getListaVeiculos().size();
        return  valor * (1 + ((double)qtdeFuncionarios/100)) * qtdeVeiculos;
    }

    @Override
    public String toString() {
        return super.toString() +
               "CNPJ: " + this.CNPJ + "\n" +
               "Data de Fundação: " + this.dataFundacao + "\n";
    }
}
