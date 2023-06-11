import java.time.LocalDate;

public class SeguroPF extends Seguro{
    // Atributos (propriedades)
    private ClientePF cliente;
    private Veiculo veiculo;
    
    
    // Construtor
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
                    ClientePF cliente, Veiculo veiculo) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }
    

    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public ClientePF getCliente() {
        return cliente;
    }
    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
    
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    // - Funções da classe SeguroPF

    public double calculaValor() {
        /* Calcula o valor mensal do seguro para o ClientePF. 

        Utiliza os fatores da classe CalculoSeguro, segundo os
        seguintes critérios:
        Se idade < 30: fatorIdade = 1.25;
        Se 30 <= idade <= 60: fatorIdade = 1.0;
        Se idade > 60: fatorIdade = 1.5.
        
        Utiliza o conceito de sobrecarga de métodos, a partir da
        superclasse Seguro.*/
        int idade = cliente.calculaIdade();
        double valorBase = CalculoSeguro.VALOR_BASE.getValor();
        double fatorIdade;
        if (idade < 30)
            fatorIdade = CalculoSeguro.FATOR_MENOR_30.getValor();
        else if (idade <= 60)
            fatorIdade = CalculoSeguro.FATOR_30_60.getValor();
        else
            fatorIdade = CalculoSeguro.FATOR_MAIOR_60.getValor();
        
        /* quantidadeVeiculos = quantidade total de veículos do ClientePF */
        int quantidadeVeiculos = cliente.getListaVeiculos().size();
        /* quantidadeSinistrosCliente = quantidade total de sinistros do cliente
        (a soma de todos os sinistros relacionados a ele) em uma seguradora */
        int quantidadeSinistrosCliente = getSeguradora().getSinistrosPorCliente(cliente).size();
        /* quantidadeSinistrosCondutor = quantidade total de sinistros dos condutores
        associados ao seguro em uma seguradora */
        int quantidadeSinistrosCondutor = getListaSinistros().size();

        return (valorBase * fatorIdade *
                (1 + 1/(quantidadeVeiculos + 2)) *
                (2 + quantidadeSinistrosCliente/10) *
                (5 + quantidadeSinistrosCondutor/10));
    }

    @Override
    public String toString() {
        return super.toString() +
               "- Cliente -\n" + this.cliente + "\n" +
               "- Veículo -\n" + this.veiculo + "\n";
    }
}
