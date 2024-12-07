import java.time.LocalDate;

public class SeguroPJ extends Seguro{
    // Atributos (propriedades)
    private ClientePJ cliente;
    private Frota frota;
    
    
    // Construtor
    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
                    ClientePJ cliente, Frota frota) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public ClientePJ getCliente() {
        return cliente;
    }
    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    public Frota getFrota() {
        return frota;
    }
    public void setFrota(Frota frota) {
        this.frota = frota;
    }


    // - Funções da classe SeguroPJ

    public double calculaValor() {
        /* Calcula o valor mensal do seguro para o ClientePJ. 
        Utiliza o conceito de sobrecarga de métodos, a partir da
        superclasse Seguro.*/
        double valorBase = CalculoSeguro.VALOR_BASE.getValor();
        int quantidadeFuncionarios = cliente.getQtdeFuncionarios();
        int anosPosFundacao = cliente.calculaAnosPosFundacao();
        
        /* quantidadeVeiculos = quantidade total de veículos do ClientePF */
        int quantidadeVeiculos = frota.getListaVeiculos().size();
        /* quantidadeSinistrosCliente = quantidade total de sinistros do cliente
        (a soma de todos os sinistros relacionados a ele) em uma seguradora */
        int quantidadeSinistrosCliente = getSeguradora().getSinistrosPorCliente(cliente).size();
        /* quantidadeSinistrosCondutor = quantidade total de sinistros dos condutores
        associados ao seguro em uma seguradora */
        int quantidadeSinistrosCondutor = getListaSinistros().size();

        return (valorBase * (quantidadeFuncionarios/10) *
                (1 + 1/(quantidadeVeiculos + 2)) *
                (1 + 1/(anosPosFundacao + 2)) *
                (2 + quantidadeSinistrosCliente/10) *
                (5 + quantidadeSinistrosCondutor/10));
    }

    @Override
    public String toString() {
        return super.toString() +
               "- Cliente -\n" + this.cliente + "\n" +
               "- Frota -\n" + this.frota + "\n";
    }
}
